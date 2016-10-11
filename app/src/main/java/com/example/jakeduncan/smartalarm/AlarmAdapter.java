package com.example.jakeduncan.smartalarm;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder> {

    private List<AlarmInfo> AlarmList;

    public AlarmAdapter(List<AlarmInfo> contactList) {
        this.AlarmList = contactList;
    }

    @Override
    public int getItemCount() {
        return AlarmList.size();
    }

    @Override
    public void onBindViewHolder(AlarmViewHolder AlarmViewHolder, int i) {
        AlarmInfo ci = AlarmList.get(i);

        AlarmViewHolder.vTime.setText(ci.time);
        AlarmViewHolder.vTitle.setText(ci.title);
    }

    @Override
    public AlarmViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.alarm_view, viewGroup, false);

        return new AlarmViewHolder(itemView);
    }


    public class AlarmViewHolder extends RecyclerView.ViewHolder {
        protected TextView vTime;
        protected TextView vTitle;

        public AlarmViewHolder(View v) {
            super(v);
            vTime = (TextView) v.findViewById(R.id.time);
            vTitle = (TextView) v.findViewById(R.id.title);
        }
    }
}