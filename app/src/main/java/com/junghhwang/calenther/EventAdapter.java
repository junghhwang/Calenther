package com.junghhwang.calenther;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.Query;

/**
 * Created by junghhwang on 11/29/16.
 */

public class EventAdapter extends FirebaseListAdapter<EventChat> {

    /**
     * @param mRef        The Firebase location to watch for data changes. Can also be a slice of a location, using some
     *                    combination of <code>limit()</code>, <code>startAt()</code>, and <code>endAt()</code>,
     * @param mModelClass Firebase will marshall the data at a location into an instance of a class that you provide
     * @param mLayout     This is the mLayout used to represent a single list item. You will be responsible for populating an
     *                    instance of the corresponding view with the data from an instance of mModelClass.
     * @param activity    The activity containing the ListView
     */
    public EventAdapter(Query mRef, Class<EventChat> mModelClass, int mLayout, Activity activity) {
        super(mRef, mModelClass, mLayout, activity);
    }

    @Override
    protected void populateView(View v, EventChat model) {
        TextView name = (TextView) v.findViewById(R.id.list_item_name);
        TextView time = (TextView) v.findViewById(R.id.list_item_time);
        ImageView image = (ImageView) v.findViewById(R.id.imageView_event);

        if (name != null && model.getName() != null) {
            name.setText(model.getName().substring(0, Math.min(25, model.getName().length())));
        }
        if (time != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(model.getStartHour()); sb.append(":");
            sb.append(model.getStartMinute()); sb.append(" ");
            sb.append(model.getMonth()); sb.append("/");
            sb.append(model.getDayOfMonth()); sb.append("/");
            sb.append(model.getYear());
            time.setText(sb.toString());
        }
    }
}