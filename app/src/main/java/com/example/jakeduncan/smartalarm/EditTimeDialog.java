package com.example.jakeduncan.smartalarm;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import static com.example.jakeduncan.smartalarm.MainActivity.alarmList;
import static com.example.jakeduncan.smartalarm.MainActivity.ca;
import static com.example.jakeduncan.smartalarm.MainActivity.recList;
import static com.example.jakeduncan.smartalarm.R.id.timePicker;

/**
 * Created by jakeduncan on 10/12/16.
 */

public class EditTimeDialog extends DialogFragment implements TimePicker.OnTimeChangedListener{


    private TimePicker mTimePicker;

    public EditTimeDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_time, container);
        mTimePicker = (TimePicker) view.findViewById(timePicker);
        getDialog().setTitle("Enter Time");

        Button doneButton = (Button) view.findViewById(R.id.done_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               //add doesnt seem to update the view here unless i set the adapter here again aswell.
                recList.setAdapter(ca);

                AlarmInfo test = new AlarmInfo();

               boolean pm = false;
               int hour = mTimePicker.getCurrentHour();
               int minutes = mTimePicker.getCurrentMinute();
                if (hour > 12){
                    hour = hour-12;
                    pm = true;
               }
                if (hour == 0){
                    hour = 12;
                    pm = false;
                }
                String alarmTime = hour + ":" + pad(minutes);
                if (pm == true) alarmTime += "PM";
                else alarmTime += "AM";

                test.time = alarmTime;
                test.title= "Alarm";
                alarmList.add(test);
                getDialog().dismiss();
            }
        });

        mTimePicker.setOnTimeChangedListener(this);
        return view;
    }

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

    }
}