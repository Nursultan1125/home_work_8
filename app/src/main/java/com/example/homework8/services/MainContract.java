package com.example.homework8.services;

import com.example.homework8.models.Node;

import java.util.ArrayList;

public interface MainContract {
    interface View{
        void setNodes(ArrayList<Node> nodes);
        void updateNodeList();
    }
    interface Repository{
        ArrayList<Node> getNodes();
    }

    interface Presenter{
        void onClickAddNodeButton();
        void addNode(Node node);
    }
}
