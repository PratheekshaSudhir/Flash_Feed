# Flash Feed

Flash Feed is a daily news application built using Android Studio that provides users with the latest news from various categories. The app fetches news data from the [News API](https://newsapi.org/) and displays it in a user-friendly interface. Users can browse news articles from categories such as Business, Sports, Science, Health, Technology, General, and Entertainment. The app also features a search bar to find news articles of interest, and displays detailed content, including the news headline, image, author, and publication time.

## Features

- **Daily News Updates**: Stay up-to-date with the latest news from reliable sources.
- **Multiple Categories**: Explore news articles from various categories:
  - Business
  - Sports
  - Science
  - Health
  - Technology
  - General
  - Entertainment
- **Search Functionality**: Find specific news articles using the built-in search bar.
- **News Details**: View detailed news articles, including:
  - Headline
  - Content
  - Featured image
  - Author information
  - Publishing time
- **User-Friendly Interface**: Simple and clean design for easy browsing.

## Prerequisites

To run Flash Feed on your local machine, you'll need the following:

- [Android Studio](https://developer.android.com/studio) (version 4.1 or higher recommended)
- A device or emulator running Android 5.0 (Lollipop) or higher
- A [News API key](https://newsapi.org/) (required for fetching news data)

## Tech used

- Android Studio: The development environment used to build the app
- Java: used for the Android app development
- News API: Provides the news data for various categories
- RecyclerView: For displaying the list of news articles
- CardView: To design news cards for a consistent layout
- Picasso: For loading images in the app
- Retrofit: For handling network requests to the News API
- SearchView: For search bar
- Json convertor dependency: For converting the json data into text form
