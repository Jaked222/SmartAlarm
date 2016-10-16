package com.example.jakeduncan.smartalarm;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EditTimeDialog.EditTimeDialogListener {

    Button alarmButton;

    RecyclerView recList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        List alarmList = createList(30);
        AlarmAdapter ca = new AlarmAdapter(alarmList);
        recList.setAdapter(ca);

        alarmButton =(Button)findViewById(R.id.alarm_button);
        this.alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //prompt user for time entry
                showEditDialog();
            }
        });
    }

    private List createList(int size) {

        List result = new ArrayList();
        for (int i = 1; i <= size; i++) {

            AlarmInfo ai = new AlarmInfo();
            ai.title = "sample title" + i;
            ai.time = "sample time" + i;

            result.add(ai);

        }

        return result;
    }

    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        EditTimeDialog editTimeDialog = new EditTimeDialog();
        editTimeDialog.show(fm, "fragment_edit_time");
    }
    @Override
    public void onFinishEditDialog(int hour, int minute) {
        Toast.makeText(this, "hour: " + hour + "minute: " + minute, Toast.LENGTH_SHORT).show();

    }
}
