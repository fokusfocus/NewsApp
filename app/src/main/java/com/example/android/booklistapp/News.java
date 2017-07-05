/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.booklistapp;

/**
 * An {@link News} object contains information related to a single earthquake.
 */
public class News {

    //placeholder for the title of the news
    private String mNewsTitle;

    //which section the news belong to
    private String mNewsSection;

    //url of the article
    private String mNewsUrl;

    //author of book(s)
    private StringBuilder mBookAuthor;


    //constructor for book
    public News(String newsTitle, String newsSection, String newsUrl, StringBuilder bookAuthor) {

        mNewsTitle = newsTitle;
        mNewsSection = newsSection;
        mNewsUrl = newsUrl;

        mBookAuthor =bookAuthor;
    }



    //getter for the title of the book
    public String getBookTitle() {

        return mNewsTitle;
    }

    //getter the publisher of the book
    public  String getBookPublisher() {

        return mNewsSection;
    }

    //getter for the url of the news article
    public String getNewsUrl() {
        return mNewsUrl;
    }

    //getter the author(s) of the book
    public StringBuilder getBookAuthor() {

        return mBookAuthor;
    }
}
