package com.junghhwang.calenther;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NewEventActivity extends AppCompatActivity {

    EditText searchView;
    Button addButton;
    ListView listView;
    List<String> users;
    EventChat newEvent;
    String key;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference usersRef = database.getReference().child("UIDMap");
    private ArrayAdapter adapter;
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        newEvent = getIntent().getExtras().getParcelable(EventChat.EVENT_CHAT_KEY);
        key = getIntent().getExtras().getString("database_key");
        users = new ArrayList<>();

        database.getReference().child("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child("events").push().setValue(key);

        searchView = (EditText) findViewById(R.id.editText_search);

        Button nextButton = (Button) findViewById(R.id.button_to_2);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NewEvent2Activity.class)
                        .putExtra(EventChat.EVENT_CHAT_KEY, newEvent)
                        .putExtra("database_key", key);
                startActivity(intent);
            }
        });

        addButton = (Button) findViewById(R.id.button_add_user);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUID = searchView.getText().toString();
                if (newUID == null || usersRef.child(newUID) == null || users.contains(newUID)) {
                    Toast.makeText(NewEventActivity.this, "No such user found!", Toast.LENGTH_SHORT).show();
                    usersRef.child(newUID).removeValue();
                } else {
                    database.getReference().child("Users").child(newUID).child("events").push().setValue(key);
                    newEvent.getUserUIDs().add(newUID);
                    database.getReference().child("Events").child(key).setValue(newEvent);
                    users.add(newUID);
                }
            }
        });

        listView = (ListView) findViewById(R.id.list_view_users);
        adapter = new UsersAdapter(this, R.layout.list_item_user);
        listView.setAdapter(adapter);

        UpdateUsersTask updateUsersTask = new NewEventActivity.UpdateUsersTask();
        updateUsersTask.execute();
    }

    private User findUser(String uid) {
        final User[] user = new User[1];
        database.getReference().child("Users").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user[0] = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return user[0];
    }

    public class UpdateUsersTask extends AsyncTask<Void, Void, List<String>> {

        private static final String URL_STRING = "http://projects.fivethirtyeight.com/2016-election-forecast/summary.json";

        @Override
        protected List<String> doInBackground(Void... params) {
            return users;
        }

        @Override
        protected void onPostExecute(List<String> users) {
            adapter.clear();
            for (String uid : users) {
                adapter.add(uid);
//                database.getReference().child("Users").child(uid).addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        User user = dataSnapshot.getValue(User.class);
//                        adapter.add(user);
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
            }
            super.onPostExecute(users);
        }
    }

    public class UsersAdapter extends ArrayAdapter<String> {

        public UsersAdapter(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public View getView(int position, View v, ViewGroup parent) {
            if (v == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                v = inflater.inflate(R.layout.list_item_event, null);
            }

            final String uid = getItem(position);

            TextView username = (TextView) v.findViewById(R.id.list_item_name);

            if (username != null) {
                username.setText(uid);
            }

            ImageButton ib = (ImageButton) v.findViewById(R.id.imageButton);
            ib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    users.remove(uid);
                }
            });
            return v;
        }
    }
}