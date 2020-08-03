package com.example.homework8.controller;

import com.example.homework8.models.Node;
import com.example.homework8.models.NodeRepository;
import com.example.homework8.services.MainContract;

import java.util.ArrayList;

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;
    NodeRepository repository = new NodeRepository();
    ArrayList<Node> nodes;

    public MainPresenter(MainContract.View view){
        this.view = view;
        this.nodes = repository.getNodes();
        this.view.setNodes(nodes);
    }

    @Override
    public void onClickAddNodeButton() {

    }

    @Override
    public void addNode(Node node) {
        nodes.add(node);
        view.updateNodeList();
    }
}
