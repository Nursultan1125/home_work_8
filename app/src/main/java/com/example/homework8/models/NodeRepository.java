package com.example.homework8.models;

import android.content.SharedPreferences;

import com.example.homework8.NodeAdapter;
import com.example.homework8.services.MainContract;

import java.util.ArrayList;

public class NodeRepository implements MainContract.Repository {

    private final SharedPreferences settings;
    static final String NODE_LIST_KEY = "NODE_LIST_KEY";

    public NodeRepository(SharedPreferences settings){
        this.settings =settings;
    }

    @Override
    public ArrayList<Node> getNodes() {
        return null;
    }

    @Override
    public ArrayList<Node> addNode() {
        return null;
    }

    @Override
    public ArrayList<Node> removeNode() {
        return null;
    }
}
