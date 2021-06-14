package com.grin.poligon.adam2;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.grin.poligon.R;

import org.qap.ctimelineview.TimelineRow;
import org.qap.ctimelineview.TimelineViewAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class BookFragment extends Fragment {
    private ArrayList<TimelineRow> timelineRowsList = new ArrayList<>();
    ArrayAdapter<TimelineRow> myAdapter;
    public BookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book, container, false);
       ////////////////////////////////////

//        // Add Random Rows to the List
//        for (int i = 0; i < 15; i++) {
//            //add the new row to the list
//            timelineRowsList.add(createRandomTimelineRow(i));
//        }
//
//        //Create the Timeline Adapter
//        myAdapter = new TimelineViewAdapter(getContext(), 0, timelineRowsList,
//                //if true, list will be sorted by date
//                true);
//
//
//        //Get the ListView and Bind it with the Timeline Adapter
//        ListView myListView = (ListView) view.findViewById(R.id.timeline_listView);
//        myListView.setAdapter(myAdapter);
//
//
//        //if you wish to handle list scrolling
//        myListView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            private int currentVisibleItemCount;
//            private int currentScrollState;
//            private int currentFirstVisibleItem;
//            private int totalItem;
//            private LinearLayout lBelow;
//
//
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//                // TODO Auto-generated method stub
//                this.currentScrollState = scrollState;
//                this.isScrollCompleted();
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem,
//                                 int visibleItemCount, int totalItemCount) {
//                // TODO Auto-generated method stub
//                this.currentFirstVisibleItem = firstVisibleItem;
//                this.currentVisibleItemCount = visibleItemCount;
//                this.totalItem = totalItemCount;
//
//
//            }
//
//            private void isScrollCompleted() {
//                if (totalItem - currentFirstVisibleItem == currentVisibleItemCount
//                        && this.currentScrollState == SCROLL_STATE_IDLE) {
//
//                    ////on scrolling to end of the list, add new rows
//                    for (int i = 0; i < 15; i++) {
//                 //       myAdapter.add(createRandomTimelineRow(i));
//                    }
//
//                }
//            }
//
//
//        });
//
//        //if you wish to handle the clicks on the rows
//        AdapterView.OnItemClickListener adapterListener = new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TimelineRow row = timelineRowsList.get(position);
//            //    Toast.makeText(TimelineTest.this, row.getTitle(), Toast.LENGTH_SHORT).show();
//            }
//        };
//        myListView.setOnItemClickListener(adapterListener);
//

        ////////////////////////////////
        return view;

    }



    //Method to create new Timeline Row


    //Random Methods

}
