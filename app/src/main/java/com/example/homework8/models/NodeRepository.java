package com.example.homework8.models;

import com.example.homework8.services.MainContract;
import java.util.ArrayList;

public class NodeRepository implements MainContract.Repository {


    @Override
    public ArrayList<Node> getNodes() {
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        nodes.add(new Node("Text", "Body sdfsd fsdfsdfsd"));
        return nodes;
    }
}
