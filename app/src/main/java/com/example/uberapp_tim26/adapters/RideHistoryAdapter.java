package com.example.uberapp_tim26.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.model.RideHistoryPlaceholder;
import com.example.uberapp_tim26.tools.MokapRideHistory;

public class RideHistoryAdapter extends BaseAdapter {
    private Activity activity;

    public RideHistoryAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return MokapRideHistory.getRideHistory().size();
    }

    @Override
    public Object getItem(int i) {
        return MokapRideHistory.getRideHistory().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi=view;
        RideHistoryPlaceholder placeholder = MokapRideHistory.getRideHistory().get(i);

        if(view==null)
            vi = activity.getLayoutInflater().inflate(R.layout.ridehistory_list, null);

        TextView name = (TextView)vi.findViewById(R.id.name);
        TextView description = (TextView)vi.findViewById(R.id.description);
        //ImageView image = (ImageView)vi.findViewById(R.id.item_icon);

        name.setText(placeholder.getComment());
        description.setText(placeholder.getComment());

        /*if (cinema.getAvatar() != -1){
            image.setImageResource(cinema.getAvatar());
        }*/

        return  vi;
    }
}
