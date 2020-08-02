package com.example.homework8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.homework8.models.Node;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE_CHILD = 1;
    ListView listView;
    NodeAdapter adapter;
    FloatingActionButton floatingActionButton;
    ArrayList<Node> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        listView = findViewById(R.id.nodeList);
        floatingActionButton = findViewById(R.id.fab);

        list.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        list.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        list.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        list.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        list.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        list.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        list.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        list.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        list.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        adapter = new NodeAdapter(list, getApplicationContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    public void onClickFAB(View view) {
        Intent intent = new Intent(MainActivity.this, NoteEditActivity.class);
        startActivityForResult(intent, REQ_CODE_CHILD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        Node node = data.getParcelableExtra(Node.class.getSimpleName());
        list.add(node);
        adapter.notifyDataSetChanged();
    }

}