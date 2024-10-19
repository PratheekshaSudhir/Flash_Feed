package com.example.newme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newme.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

//class for the content and headlines of the news
public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    // the headlines object is the array of title of the news as mentioned in NewsHeadlines class
    private List<NewsHeadlines> headlines;
    //the object created for SelectListener interface
    private SelectListener listener;

    public CustomAdapter(Context context, List<NewsHeadlines> headlines, SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener=listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // the below line of code will represent the content in the format which is designed in headline_list_items.xml file
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //fetching the title from the array (NewsHeadlines-->Title) and setting it to the text_title (textview)
        holder.text_title.setText(headlines.get(position).getTitle());
        //fetching the source from the array (NewsHeadlines-->Source-->getName()) and setting it to the text_source (textview)
        holder.text_source.setText(headlines.get(position).getSource().getName());
        //fetching the image from the url using picasso dependency which is stored in build.gradles.kt file and then attaching the image to the imageView
        if(headlines.get(position).getUrlToImage()!=null){
            Picasso.get()
                    .load(headlines.get(position).getUrlToImage())
                    .placeholder(R.drawable.not_available) // Image shown while loading
                    .error(R.drawable.not_available)       // Image shown if the URL fails to load
                    .into(holder.image_headline);
        }
        //adding listener when a news is clicked
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnNewsClicked(headlines.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
