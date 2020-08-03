package com.example.homework8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ListView;
import com.example.homework8.controller.MainPresenter;
import com.example.homework8.models.Node;
import com.example.homework8.services.MainContract;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final int REQ_CODE_CHILD = 1;
    ListView listView;
    NodeAdapter adapter;
    ArrayList<Node> nodes = new ArrayList<>();
    static final String NODE_LIST_KEY = "NODE_LIST_KEY";
    MainPresenter controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.nodeList);

        controller = new MainPresenter(this);
    }

    @Override
    public void setNodes(ArrayList<Node> nodes){
        adapter = new NodeAdapter(nodes, getApplicationContext());
        listView.setAdapter(adapter);
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
        controller.addNode(node);
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

    @Override
    public void updateNodeList(){
        adapter.notifyDataSetChanged();
    }
}