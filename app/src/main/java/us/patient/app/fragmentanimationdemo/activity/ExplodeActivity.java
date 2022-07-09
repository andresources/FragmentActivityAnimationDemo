package us.patient.app.fragmentanimationdemo.activity;


import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import us.patient.app.fragmentanimationdemo.R;

public class ExplodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        //Transition explode = TransitionInflater.from(this).inflateTransition(android.R.transition.explode);
        //getWindow().setEnterTransition(explode);

        //OR
        getWindow().requestFeature(android.view.Window.FEATURE_CONTENT_TRANSITIONS);
        Slide s=new Slide();//Slide(); //Explode();
        s.setSlideEdge(Gravity.RIGHT);//TOP,BOTTOM,LEFT,RIGHT
        Transition ts = s;
        ts.setDuration(700);

        getWindow().setEnterTransition(ts);
        getWindow().setExitTransition(ts);

        setContentView(R.layout.activity_three);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }
}
