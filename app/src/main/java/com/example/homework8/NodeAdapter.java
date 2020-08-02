package com.example.homework8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.homework8.models.Node;

import java.util.ArrayList;

public class NodeAdapter extends ArrayAdapter<Node> {
    ArrayList<Node> notes;

    public NodeAdapter(ArrayList<Node> data, @NonNull Context context) {
        super(context, R.layout.row, data);
    }

    private static class ViewHolder{
        TextView titleTextView;
        TextView lastEditDate;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Node node = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row, parent, false);
            viewHolder.titleTextView = convertView.findViewById(R.id.noteItemTitle);
            viewHolder.lastEditDate = convertView.findViewById(R.id.noteItemLastEditDatetime);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        assert node != null;
        viewHolder.titleTextView.setText(node.getTitle());
        viewHolder.lastEditDate.setText(node.getLastEditDate());

        return convertView;
    }
}
