package com.example.toshiba.myapplication;

import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by toshiba on 23.12.2015 г..
 */
public class Event {

    String titleId;
    int imgId;
    String numComments = "*** comments";
    String numPoints = "*** points";
    int pointsUpId = R.drawable.arrows_up_grey;
    int pointsDownId = R.drawable.arrows_down_grey;

    public void setNumPoints(String numPoints) {
        this.numPoints = numPoints;
    }

    public void setPointsUpId(int pointsUpId) {
        Log.e("upBlue", "true");

        this.pointsUpId = pointsUpId;
    }


    public void setPointsDownId(int pointsDownId) {

        this.pointsDownId = pointsDownId;
    }


    public Event(String titleId, int imgId) {
        this.titleId = titleId;
        this.imgId = imgId;

    }
}
