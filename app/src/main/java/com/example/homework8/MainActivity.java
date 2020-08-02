package com.example.homework8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.homework8.models.Node;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE_CHILD = 1;
    ListView listView;
    NodeAdapter adapter;
    FloatingActionButton floatingActionButton;
    ArrayList<Node> nodes = new ArrayList<>();
    static final String NODE_LIST_KEY = "NODE_LIST_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.nodeList);
        floatingActionButton = findViewById(R.id.fab);

        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        adapter = new NodeAdapter(nodes, getApplicationContext());
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
        nodes.add(node);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        outState.putParcelableArrayList(NODE_LIST_KEY, nodes);
        adapter.notifyDataSetChanged();
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        nodes = savedInstanceState.<Node>getParcelableArrayList(NODE_LIST_KEY);
        adapter.notifyDataSetChanged();
    }
}