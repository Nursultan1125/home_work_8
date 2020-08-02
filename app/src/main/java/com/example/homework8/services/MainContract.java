package com.example.homework8.services;

import com.example.homework8.models.Node;

import java.util.ArrayList;

public interface MainContract {
    interface View{

    }
    interface Repository{
        ArrayList<Node> getNodes();
        ArrayList<Node> addNode();
        ArrayList<Node> removeNode();
    }

    interface Presenter{
        void onClickAddNodeButton();
    }
}
