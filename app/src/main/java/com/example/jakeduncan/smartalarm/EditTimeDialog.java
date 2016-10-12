package com.example.jakeduncan.smartalarm;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by jakeduncan on 10/12/16.
 */

public class EditTimeDialog extends DialogFragment implements TextView.OnEditorActionListener{
    public interface EditTimeDialogListener {
        void onFinishEditDialog(String inputText);
    }
    private TimePicker mTimePicker;

    public EditTimeDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_time, container);
        mTimePicker = (TimePicker) view.findViewById(R.id.timePicker);
        getDialog().setTitle("**Create Alarm**");

        return view;
    }
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            // Return input text to activity
            EditTimeDialogListener activity = (EditTimeDialogListener) getActivity();
            activity.onFinishEditDialog(mTimePicker.getCurrentHour().toString());
            this.dismiss();
            return true;
        }
        return false;
    }
}
