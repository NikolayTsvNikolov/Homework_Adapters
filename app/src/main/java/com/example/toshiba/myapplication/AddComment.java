package com.example.toshiba.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddComment extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.list_view)
    ListView listView;
    @Bind(R.id.txt_add_comment)
    EditText txtAddComment;
    @Bind(R.id.btn_add_comment)
    Button btnAddComment;
    List<String> arrList = new ArrayList<>();
    private ArrayAdapter<String> arrAdapter;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);
        ButterKnife.bind(this);
        position = getIntent().getIntExtra("position", 0);
        arrAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line, arrList);
        listView.setAdapter(arrAdapter);
        btnAddComment.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        arrAdapter.add(txtAddComment.getText().toString());
//        arrList.add(txtAddComment.getText().toString());
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        int count = arrList.size();
        Intent intent = new Intent();
        intent.putExtra("countComment", count);
        intent.putExtra("position", position);
        setResult(RESULT_OK, intent);
        finish();
    }
}