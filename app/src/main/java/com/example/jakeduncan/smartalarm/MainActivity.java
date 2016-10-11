package com.example.jakeduncan.smartalarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
