package com.junghhwang.calenther;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewEvent2Activity extends AppCompatActivity {

    EditText nameInput;
    DatePicker datePicker;
    EventChat newEvent;
    String key;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event2);

        newEvent = getIntent().getExtras().getParcelable(EventChat.EVENT_CHAT_KEY);
        key = getIntent().getExtras().getString("database_key");

        TextView name = (TextView) findViewById(R.id.textView_event_name);
        TextView date = (TextView) findViewById(R.id.textView_event_date);

        nameInput = (EditText) findViewById(R.id.editText_event_name);

        datePicker = (DatePicker) findViewById(R.id.datePicker);


        Button nextButton = (Button) findViewById(R.id.button_to_3);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String eventName = nameInput.getText().toString();
                if (eventName != null) {
                    newEvent.setYear(datePicker.getYear());
                    newEvent.setMonth(datePicker.getMonth());
                    newEvent.setDayOfMonth(datePicker.getDayOfMonth());
                    newEvent.setName(eventName);
                    ref.child("Events").child(key).setValue(newEvent);
                    Intent intent = new Intent(view.getContext(), NewEvent3Activity.class)
                            .putExtra(EventChat.EVENT_CHAT_KEY, newEvent)
                            .putExtra("database_key", key);
                    startActivity(intent);
                } else {
                    Toast.makeText(NewEvent2Activity.this, "Input a name!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
