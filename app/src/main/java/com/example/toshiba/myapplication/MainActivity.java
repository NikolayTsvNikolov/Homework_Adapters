package com.example.toshiba.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnEventClicListener {

    private static final int REQUEST_CODE_COMMENT = 1;
    @Bind(R.id.recView)
    RecyclerView recView;
    List<Event> events = new ArrayList<>();
    MyAdapter adapter = new MyAdapter(events, this);
    int commentCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        events.add(new Event("1st Title", R.drawable.ic_gag1));
        events.add(new Event("2nd Title", R.drawable.ic_gag2));
        events.add(new Event("3th Title", R.drawable.ic_gag3));
        events.add(new Event("4th Title", R.drawable.ic_gag4));
        events.add(new Event("5th Title", R.drawable.ic_gag5));
        events.add(new Event("6th Title", R.drawable.ic_gag6));
        events.add(new Event("7th Title", R.drawable.ic_gag7));
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recView.setLayoutManager(mLayoutManager);
        recView.setAdapter(adapter);
    }


    @Override
    public void onShareClicked() {

    }

    @Override
    public void onPointClicked(boolean isPositive, int position) {
        int countPoints = 0;
        if (isPositive == true) {
            countPoints++;
            adapter.getEvent(position).setNumPoints(countPoints + "points");
            adapter.getEvent(position).setPointsUpId(R.drawable.arrows_up_blue);
            adapter.getEvent(position).setPointsDownId(R.drawable.arrows_down_grey);
            adapter.notifyItemChanged(position);
        } else {
            countPoints--;
            adapter.getEvent(position).setNumPoints(countPoints + "points");
            adapter.getEvent(position).setPointsDownId(R.drawable.arrows_down_blue);
            adapter.getEvent(position).setPointsUpId(R.drawable.arrows_up_grey);
            adapter.notifyItemChanged(position);
        }

    }

    @Override
    public void onCommentClicked(int position) {
        Intent intent = new Intent(this, AddComment.class);
        intent.putExtra("position", position);
        startActivityForResult(intent, REQUEST_CODE_COMMENT);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("bla", "passed");
        int position = data.getIntExtra("position", 0);
        if (requestCode == REQUEST_CODE_COMMENT && resultCode == RESULT_OK) {
            commentCount = data.getIntExtra("countComment", 0);
            adapter.getEvent(position).numComments = "" + commentCount + " comments";
            adapter.notifyDataSetChanged();

        }
    }
}
