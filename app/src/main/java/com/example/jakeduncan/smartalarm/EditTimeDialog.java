package com.example.jakeduncan.smartalarm;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import static com.example.jakeduncan.smartalarm.R.id.timePicker;

/**
 * Created by jakeduncan on 10/12/16.
 */

public class EditTimeDialog extends DialogFragment implements TimePicker.OnTimeChangedListener{


    public interface EditTimeDialogListener {
        void onFinishEditDialog(int hour, int minute);
    }
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

        Button button = (Button) view.findViewById(R.id.done_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        mTimePicker.setOnTimeChangedListener(this);
        return view;
    }
    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        EditTimeDialogListener activity = (EditTimeDialogListener) getActivity();
        activity.onFinishEditDialog(mTimePicker.getCurrentHour(), mTimePicker.getCurrentMinute());

    }
}
