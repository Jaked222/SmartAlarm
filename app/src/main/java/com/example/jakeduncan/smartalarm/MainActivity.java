package com.example.jakeduncan.smartalarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button alarmButton;
    List alarmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        alarmList = createList(30);
        AlarmAdapter ca = new AlarmAdapter(alarmList);
        recList.setAdapter(ca);

        alarmButton =(Button)findViewById(R.id.alarm_button);
        this.alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //prompt user for time entry and title(this could just be made default)
                //add time to list.
            }
        });
    }

    private List createList(int size) {

        List result = new ArrayList();
        for (int i = 1; i <= size; i++) {

            AlarmInfo ci = new AlarmInfo();
            ci.title = "sample title" + i;
            ci.time = "sample time" + i;

            result.add(ci);

        }

        return result;
    }


}
