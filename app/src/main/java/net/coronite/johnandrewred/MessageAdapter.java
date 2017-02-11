package net.coronite.johnandrewred;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import net.coronite.johnandrewred.UserMessage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class MessageAdapter extends ArrayAdapter<UserMessage> {

    SimpleDateFormat mDateFormat;
    Calendar mCalendar;
    Date mDate;
    String mDateString;


    public MessageAdapter(Context context, int resource, List<UserMessage> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(net.coronite.johnandrewred.R.layout.item_message, parent, false);
        }

        ImageView photoImageView = (ImageView) convertView.findViewById(net.coronite.johnandrewred.R.id.photoImageView);
        TextView messageTextView = (TextView) convertView.findViewById(net.coronite.johnandrewred.R.id.messageTextView);
        TextView authorTextView = (TextView) convertView.findViewById(net.coronite.johnandrewred.R.id.nameTextView);

        UserMessage message = getItem(position);

        //Get Date
        mCalendar = Calendar.getInstance();
        mCalendar.setTimeZone(TimeZone.getDefault());
        mDateFormat = new SimpleDateFormat("ccc, MMM d h:mm a", Locale.getDefault());
        mDateFormat.setCalendar(mCalendar);

        long now = message.getDateLong();
        mCalendar.setTimeInMillis(now);
        mDate = new Date();
        mDate.setTime(now);
        mDateString =  mDateFormat.format(mDate).toUpperCase();

        boolean isPhoto = message.getPhotoUrl() != null;
        if (isPhoto) {
            messageTextView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);
            Glide.with(photoImageView.getContext())
                    .load(message.getPhotoUrl())
                    .into(photoImageView);
        } else {
            messageTextView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            messageTextView.setText(message.getText());
        }
        //authorTextView.setText(message.getName() + " " + mDateString);
        authorTextView.setText(String.format(message.getName() + " %s", mDateString ));

        return convertView;
    }
}
