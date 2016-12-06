package com.junghhwang.calenther;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewEvent3Activity extends AppCompatActivity {

    TimePicker tp;
    Button next;
    EventChat newEvent;
    String key;
    final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event3);

        Bundle extras = getIntent().getExtras();
        newEvent = extras.getParcelable(EventChat.EVENT_CHAT_KEY);
        key = extras.getString("database_key");

        tp = (TimePicker) findViewById(R.id.timePicker_start);

        next = (Button) findViewById(R.id.button_done);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newEvent.setStartHour(tp.getHour());
                newEvent.setStartMinute(tp.getMinute());
                ref.child("Events").child(key).setValue(newEvent);
                Intent intent = new Intent(view.getContext(), Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
