package com.example.android.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static int currentCounter = 0;
    static String COUNT = "restartCounter";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            currentCounter = savedInstanceState.getInt(COUNT);
        }
        setContentView(R.layout.activity_main);
        currentCounter = 0;
        TextView textView = (TextView) findViewById(R.id.currentCounter);
        textView.setText("Thread Count: "+ String.format("%04d", currentCounter));
        Log.e("onCreate ------ ", "MainActivity: onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart ------ ","MainActivity: onStart()");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume ------ ","MainActivity: onResume()");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause ------ ","MainActivity: onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop ------ ","MainActivity: onStop()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy ------ ","MainActivity: onDestroy()");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart ------ ","MainActivity: onRestart()");
        currentCounter += 1;
        TextView textView = (TextView) findViewById(R.id.currentCounter);
        textView.setText("Thread Count: "+ String.format("%04d", currentCounter));
    }

    public void switchActivity(View view){
        Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
        startActivity(intent);
    }

    public void closeActivity(View view){
        finish();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt(COUNT, currentCounter);

        super.onSaveInstanceState(savedInstanceState);
    }

    public void openDialog(View view){
        SampleDialog sampleDialog = new SampleDialog();
        sampleDialog.show(getSupportFragmentManager(),"sample dialog");
    }
}
