package com.example.toshiba.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddCommetnsActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.btn_add_comment)
    Button btnAddComment;
    @Bind(R.id.list_view)
    ListView listView;
    @Bind(R.id.txt_add_comment)
    EditText txtAddComment;
    List<String> comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_commetns);
        ButterKnife.bind(this);
        ArrayAdapter<String> arrAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, comments);
        listView.setAdapter(arrAdapter);
        btnAddComment.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

    }
}
