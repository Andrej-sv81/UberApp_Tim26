package com.example.uberapp_tim26.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.model.Message;
import com.example.uberapp_tim26.tools.Mokap;

public class MessageAdapter extends BaseAdapter {

    private Activity activity;
    public MessageAdapter(Activity activity){
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return Mokap.getMessage().size();
    }

    @Override
    public Object getItem(int position) {
        return Mokap.getMessage().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View messageView =convertView;
        Message message = Mokap.getMessage().get(position);

        if(convertView==null)
            messageView = activity.getLayoutInflater().inflate(R.layout.message_list, null);

        TextView name = (TextView)messageView.findViewById(R.id.name);
        TextView title = (TextView)messageView.findViewById(R.id.title);

        name.setText(message.getUsername());
        title.setText(message.getTitle());


        return  messageView;
    }
}
