package us.patient.app.fragmentanimationdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import us.patient.app.fragmentanimationdemo.R;

public class ImageScaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_scale);
    }

    @Override
    public void onBackPressed() {
        finishAfterTransition();
        super.onBackPressed();
    }
}