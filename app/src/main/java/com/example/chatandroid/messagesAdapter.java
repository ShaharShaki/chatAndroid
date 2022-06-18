package com.example.chatandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class messagesAdapter extends ArrayAdapter<Message> {
    LayoutInflater inflater;
    public messagesAdapter(Context ctx, ArrayList<Message> messagesArrayList) {
        super(ctx, R.layout.messageslayout, messagesArrayList);

        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Message message = getItem(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.messageslayout, parent, false);
        }

        ImageView imageView =  convertView.findViewById(R.id.profile_img);
        TextView username = convertView.findViewById(R.id.user_name);
        TextView lastMessage = convertView.findViewById(R.id.last_message);
        TextView time = convertView.findViewById(R.id.time);

        //todo need to get picture of user
//        imageView.setImageResource(contactUser.);
        username.setText(message.getMessage());
        return convertView;

    }
}
