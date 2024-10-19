package com.example.newme;

import com.example.newme.Models.NewsHeadlines;

//to define the action that needs to be executed on click of a news
public interface SelectListener {
    void OnNewsClicked(NewsHeadlines headlines);
}
