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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        AlarmAdapter ca = new AlarmAdapter(createList(30));
        recList.setAdapter(ca);

        alarmButton =(Button)findViewById(R.id.alarm_button);
        this.alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make the button add menu items with fake alarm data
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
