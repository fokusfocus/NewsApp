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
package com.example.android.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each book
 * in the data source (a list of {@link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param newses is the list of newses, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> newses) {

        super(context, 0, newses);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news article at the given position in the list of news articles
        final News currentNews = getItem(position);


        //find the TextView with view ID news_title, map it to title
        TextView titleView = (TextView) listItemView.findViewById(R.id.news_title);
        titleView.setText(currentNews.getNewsTitle());

        //find the TextView with view ID section_name, map it to sectionName
        TextView sectionNameView = (TextView) listItemView.findViewById(R.id.section_name);
        sectionNameView.setText(currentNews.getNewsSection());

        //find the TextView with view ID web_url, map it to web_url
        TextView urlView = (TextView)  listItemView.findViewById(R.id.web_url);
        urlView.setText(currentNews.getNewsUrl());

        Button urlButton = (Button) listItemView.findViewById(R.id.url_link);
        urlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //opening URL in a browser
                //System.out.println("this should open URL in a browser"); FOR TESTING
                String url = currentNews.getNewsUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                v.getContext().startActivity(intent);

            }
        });

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

}
