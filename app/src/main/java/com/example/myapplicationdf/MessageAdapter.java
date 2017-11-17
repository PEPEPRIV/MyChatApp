package com.example.myapplicationdf;

import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DatabaseReference;

public class MessageAdapter extends FirebaseListAdapter<ChatMessage>{
    private MainActivity activity;
    private DatabaseReference ref;

    public MessageAdapter(FirebaseListOptions<ChatMessage> options) {
        super(options);
    }

    protected void populateView(View v, ChatMessage model, int position) {
        // Get references to the views of message.xml
        TextView messageText = v.findViewById(R.id.message_text);
        TextView messageUser = v.findViewById(R.id.message_user);
        TextView messageTime = v.findViewById(R.id.message_time);

        // Set their text
        messageText.setText(model.getMessageText());
        messageUser.setText(model.getMessageUser());

        // Format the date before showing it
        messageTime.setText(android.text.format.DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                model.getMessageTime()));
    }
}
