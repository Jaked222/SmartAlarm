package com.example.jakeduncan.smartalarm;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    Button alarmButton;
    public static List alarmList;
    public static RecyclerView recList;
    public static AlarmAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        alarmList = new ArrayList();
        ca = new AlarmAdapter(alarmList);
        recList.setAdapter(ca);

        //note.. adding to list after updating adapter does update the view.

        alarmButton =(Button)findViewById(R.id.alarm_button);
        this.alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //prompt user for time entry
                showEditDialog();
            }
        });
    }


    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        EditTimeDialog editTimeDialog = new EditTimeDialog();
        editTimeDialog.show(fm, "fragment_edit_time");
    }


}
