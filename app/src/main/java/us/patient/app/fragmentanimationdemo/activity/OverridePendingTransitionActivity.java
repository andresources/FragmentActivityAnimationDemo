package us.patient.app.fragmentanimationdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import spencerstudios.com.bungeelib.Bungee;
import us.patient.app.fragmentanimationdemo.R;

public class OverridePendingTransitionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_override_pending_transition);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.swipeRight(OverridePendingTransitionActivity.this);
    }
}