package com.junghhwang.calenther;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.junghhwang.calenther", appContext.getPackageName());
     }

    @Test
    public void addEvent() throws Exception {
//        String name = "example";
//        String time = "7:00 - 9:00 11/28/2016";
//        String index = "chat1";
//        List<String> userUIDs = new ArrayList<>();
//        userUIDs.add("exampleUID");
//        final EventChat exampleChat = new EventChat(name, time, index, userUIDs);
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
//        final CountDownLatch writeSignal = new CountDownLatch(1);
//        reference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                assertEquals(exampleChat, dataSnapshot.getValue(EventChat.class));
//                writeSignal.countDown();
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//
//        writeSignal.await(10, TimeUnit.SECONDS);
//
//        reference.child("events").push().setValue(exampleChat);
    }
}
