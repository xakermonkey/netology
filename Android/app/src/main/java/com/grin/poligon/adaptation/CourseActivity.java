package com.grin.poligon.adaptation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.grin.poligon.R;
 import com.grin.poligon.video.video3.MainActivity;

import org.qap.ctimelineview.TimelineRow;
import org.qap.ctimelineview.TimelineViewAdapter;

import java.util.ArrayList;

public class CourseActivity extends AppCompatActivity {
    private ArrayList<TimelineRow> timelineRowsList = new ArrayList<>();
    ArrayAdapter<TimelineRow> myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        for (int i = 0; i < 15; i++) {
            //add the new row to the list
            timelineRowsList.add(createRandomTimelineRow(i));
        }

        //Create the Timeline Adapter
        myAdapter = new TimelineViewAdapter(CourseActivity.this, 0, timelineRowsList,
                //if true, list will be sorted by date
                true);


        //Get the ListView and Bind it with the Timeline Adapter
        ListView myListView = (ListView) findViewById(R.id.timeline_listView);
        myListView.setAdapter(myAdapter);



        //if you wish to handle list scrolling
        myListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int currentVisibleItemCount;
            private int currentScrollState;
            private int currentFirstVisibleItem;
            private int totalItem;
            private LinearLayout lBelow;


            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                // TODO Auto-generated method stub
                this.currentScrollState = scrollState;
                this.isScrollCompleted();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                // TODO Auto-generated method stub
                this.currentFirstVisibleItem = firstVisibleItem;
                this.currentVisibleItemCount = visibleItemCount;
                this.totalItem = totalItemCount;


            }

            private void isScrollCompleted() {
                if (totalItem - currentFirstVisibleItem == currentVisibleItemCount
                        && this.currentScrollState == SCROLL_STATE_IDLE) {

                    ////on scrolling to end of the list, add new rows
                    for (int i = 0; i < 15; i++) {
                        //       myAdapter.add(createRandomTimelineRow(i));
                    }

                }
            }


        });

        //if you wish to handle the clicks on the rows
        AdapterView.OnItemClickListener adapterListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TimelineRow row = timelineRowsList.get(position);
                startActivity(new Intent(CourseActivity.this, MainActivity.class));
       //         startActivity(new Intent(CourseActivity.this, PlayerActivity.class));
                //    Toast.makeText(TimelineTest.this, row.getTitle(), Toast.LENGTH_SHORT).show();
            }
        };
        myListView.setOnItemClickListener(adapterListener);

    }

    private TimelineRow createRandomTimelineRow(int id) {

        // Create new timeline row (pass your Id)
        TimelineRow myRow = new TimelineRow(id);

        //to set the row Date (optional)
        //  myRow.setDate(getRandomDate());
        //to set the row Title (optional)
        myRow.setTitle("Урок " + id);
        //to set the row Description (optional)
        myRow.setDescription("Пройдено: 0%");
        //to set the row bitmap image (optional)
        //to set row Below Line Color (optional)
        myRow.setBellowLineColor(getResources().getColor(R.color.grey_l));
        //to set row Below Line Size in dp (optional)
        myRow.setBellowLineSize(3);
        //to set row Image Size in dp (optional)
        //to set background color of the row image (optional)
        myRow.setBackgroundColor(getResources().getColor(R.color.orange_l));
        //to set the Background Size of the row image in dp (optional)
        myRow.setBackgroundSize(15);
        //to set row Date text color (optional)
        // myRow.setDateColor(getRandomColor());
        //to set row Title text color (optional)
        //  myRow.setTitleColor(getRandomColor());
        //to set row Description text color (optional)
        //  myRow.setDescriptionColor(getRandomColor());
        //       myRow.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.ic_menu_camera));
        //       myRow.setImageSize(50);

        return myRow;
    }

}