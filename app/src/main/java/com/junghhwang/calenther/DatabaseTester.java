package com.junghhwang.calenther;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by solmoms on 11/28/2016.
 */

public class DatabaseTester {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mMessageRef = database.getReference("message");
    DatabaseReference mDirectoryRef = database.getReference("directory");
    DatabaseReference mChatRoomRef = database.getReference("rooms");

    public static void main(String[] args) {
    }
}
