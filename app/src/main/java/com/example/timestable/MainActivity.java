package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView numContainer;

    public void generator (int timeTable){
        ArrayList<String> numBarContent = new ArrayList<String>();

        for (int j = 1; j <= 12; j++) {
            numBarContent.add(Integer.toString(j * timeTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,numBarContent);

        numContainer.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar numBar = (SeekBar) findViewById(R.id.numBar);
        numContainer = (ListView) findViewById(R.id.numContainer);

        int max = 20;
        int startingPosition = 10;

        numBar.setMax(max);
        numBar.setProgress(startingPosition);
        generator(startingPosition);

        numBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {

                int min = 1;
                int timeTable;

                if (i < min) {
                    timeTable = min;
                    numBar.setProgress(min);
                } else {
                    timeTable = i;
                }

                Log.i("Info",String.valueOf(timeTable));
                generator(timeTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
