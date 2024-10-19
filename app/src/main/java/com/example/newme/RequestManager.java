package com.example.newme;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.newme.Models.NewsApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {
    Context context;
    //to manage the new data fetched we use retrofit
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/") //only base url is put from the entire news api url
            .addConverterFactory(GsonConverterFactory.create())
            .build();


//    the actual management of the data is done here
    public void getNewsHeadlines(OnFetchDataListener listener, String category, String query){
        CallNewsApi callNewsApi = retrofit.create(CallNewsApi.class);
        Call<NewsApiResponse> call = callNewsApi.callHeadlines("us", category, query, context.getString(R.string.api_key));

        try{
            call.enqueue(new Callback<NewsApiResponse>() {
                @Override
                public void onResponse(@NonNull Call<NewsApiResponse> call, @NonNull Response<NewsApiResponse> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(context, "Error!!!", Toast.LENGTH_SHORT).show();
                    }

                    listener.onFetchData(response.body().getArticles(),response.message());
                }

                @Override
                public void onFailure(@NonNull Call<NewsApiResponse> call, @NonNull Throwable throwable) {
                    listener.onError("Request Failed!!!");
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public RequestManager(Context context) {
        this.context = context;
    }

    public interface CallNewsApi{
        @GET("top-headlines")  //coz the url has Get call
        Call<NewsApiResponse> callHeadlines(
                //queries are available in the documentation part of news api.org
                @Query("country") String country,
                @Query("category") String category,
                @Query("q") String query,
                @Query("apiKey") String api_key
        );
    }
}
