package com.bugchain.android.development.analoganddigitalclock;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private TextView textTitle;
    private TextClock digitalClock;
    private AnalogClock analogClock;
    private String digitalClockFormat = "H : mm";
    private Button buttonControl;
    private boolean isDigitalClock = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTitle = (TextView)findViewById(R.id.textTitle);
        digitalClock = (TextClock)findViewById(R.id.textClock);
        analogClock = (AnalogClock)findViewById(R.id.analogClock);
        buttonControl = (Button)findViewById(R.id.buttonControl);

        analogClock.setVisibility(View.GONE);
        digitalClock.setFormat24Hour(digitalClockFormat);
        buttonControl.setOnClickListener(this);
        buttonControl.setText("Change to analog clock");
        textTitle.setText("Digital Clock");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonControl:
                if(isDigitalClock){
                    textTitle.setText("Analog Clock");
                    analogClock.setVisibility(View.VISIBLE);
                    digitalClock.setVisibility(View.GONE);
                    isDigitalClock = false;
                    buttonControl.setText("Change to digital clock");
                }else{
                    textTitle.setText("Digital Clock");
                    digitalClock.setVisibility(View.VISIBLE);
                    analogClock.setVisibility(View.GONE);
                    isDigitalClock = true;
                    buttonControl.setText("Change to analog clock");
                }
                break;
        }
    }
}
