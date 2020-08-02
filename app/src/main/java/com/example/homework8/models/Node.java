package com.example.homework8.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.homework8.utils.DateUtils;

import java.util.Date;

public class Node implements Parcelable {
    private String title;
    private String body;
    private String lastEditDate;

    public Node(String title, String body, String lastEditDate){
        this.title = title;
        this.body = body;
        this.lastEditDate = lastEditDate;
    }

    public Node(String title, String body){
        this(title, body, DateUtils.dateToString(new Date()));
    }


    public static final Creator<Node> CREATOR = new Creator<Node>() {
        @Override
        public Node createFromParcel(Parcel in) {
            String title = in.readString();
            String body = in.readString();
            String lastEditDate = in.readString();
            return new Node(title, body, lastEditDate);
        }

        @Override
        public Node[] newArray(int size) {
            return new Node[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(String lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(body);
        dest.writeString(lastEditDate);
    }
}
