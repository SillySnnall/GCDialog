package com.stringbox.dialogtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.stringbox.gcdialog.GCDialog;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GCDialog gcDialog = new GCDialog(this).loadLayout(R.layout.dialog_prompt);
        gcDialog.setText(R.id.dialog_prompt_title, "提示");
        gcDialog.show();
    }
}
