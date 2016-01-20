package com.example.toshiba.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.example.toshiba.myapplication.R.*;

/**
 * Created by toshiba on 7.1.2016 г..
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private List<Event> events = new ArrayList<>();

    OnEventClicListener listener;


    public MyAdapter(List<Event> events, OnEventClicListener listener) {
        this.listener = listener;
        this.events = events;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(layout.list_item_ivent, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.position = position;
        holder.txtTitle.setText(events.get(position).titleId);
        holder.numComments.setText(events.get(position).numComments);
        holder.img.setImageResource(events.get(position).imgId);
        holder.numPoints.setText(events.get(position).numPoints);
        holder.btnPointsUp.setBackgroundResource(events.get(position).pointsUpId);
        holder.btnPointsDown.setBackgroundResource(events.get(position).pointsDownId);

    }

    @Override
    public int getItemCount() {

        return events.size();
    }

    public Event getEvent(int position) {

        return events.get(position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(id.btn_share)
        Button btnShare;
        @Bind(id.btn_points_up)
        Button btnPointsUp;
        @Bind(id.btn_points_down)
        Button btnPointsDown;
        @Bind(id.btn_comment)
        Button btnComment;
        @Bind(id.img)
        ImageView img;
        @Bind(id.txt_comments)
        TextView numComments;
        @Bind(id.txt_points)
        TextView numPoints;
        @Bind(id.txt_title)
        TextView txtTitle;
        int position;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            btnPointsUp.setOnClickListener(this);
            btnPointsDown.setOnClickListener(this);
            btnComment.setOnClickListener(this);
            btnShare.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case id.btn_comment:
                    listener.onCommentClicked(position);
                    break;

                case id.btn_points_up:
                    listener.onPointClicked(true, position);
                    break;

                case id.btn_points_down:
                    listener.onPointClicked(false, position);
                    break;

                case id.btn_share:
                    listener.onShareClicked();
                    break;
            }


        }
    }


    public interface OnEventClicListener {

        void onShareClicked();

        void onPointClicked(boolean is, int position);

        void onCommentClicked(int position);


    }

}


