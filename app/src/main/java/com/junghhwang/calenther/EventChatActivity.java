package com.junghhwang.calenther;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EventChatActivity extends AppCompatActivity {

    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_chat);

        key = getIntent().getExtras().getString("database_key");
    }
}
