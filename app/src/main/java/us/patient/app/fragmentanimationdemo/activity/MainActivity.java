package us.patient.app.fragmentanimationdemo.activity;

import android.app.ActivityOptions;
import android.content.Intent;

import android.os.Bundle;

import androidx.core.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import spencerstudios.com.bungeelib.Bungee;
import us.patient.app.fragmentanimationdemo.R;

public class MainActivity extends AppCompatActivity {
    //https://gist.github.com/lopspower/1a0b4e0c50d90fbf2379
    //https://developer.android.com/training/animation
    //https://github.com/lgvalle/Material-Animations
    //https://developer.android.com/guide/fragments
    //https://github.com/SmartToolFactory/Animation-Tutorials
    //https://medium.com/bynder-tech/how-to-use-material-transitions-in-fragment-transactions-5a62b9d0b26b(Branding animation)
    //https://www.youtube.com/watch?v=z9_EsRclGL0
    //https://github.com/Pei116/sharedelementtransition/tree/master/app/src/main/java/com/wwk/sharedelementtransition
    //https://github.com/achmadqomarudin/MaterialTransition
    //https://github.com/android/animation-samples/tree/main/ActivitySceneTransitionBasic
    //https://developer.android.com/training/transitions/start-activity
   // https://www.tabnine.com/code/java/methods/android.app.ActivityOptions/makeSceneTransitionAnimation
    ImageView iv,iv1,ivUser;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv);
        iv1 = (ImageView) findViewById(R.id.iv1);
        ivUser = (ImageView) findViewById(R.id.ivUser);
    }

    private void initListener() {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, button5, "shareNames").toBundle());*/
                Intent intent = new Intent(MainActivity.this, MakeSceneAnimActivity.class);
                Pair<View, String> p1=Pair.create(iv, "shareNames");
                Pair<View, String> p2=Pair.create(tv, "shareNames1");
                Bundle b=ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, p1,p2).toBundle();
                ActivityCompat.startActivity(MainActivity.this,intent,b);
            }
        });
    }

    public void explodeAnimation(View view) {
        Intent intent = new Intent(MainActivity.this, ExplodeActivity.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this).toBundle());
        //finishAfterTransition();
    }

    public void overridePendingTransition(View view) {
        Intent intent = new Intent(MainActivity.this, OverridePendingTransitionActivity.class);
        startActivity(intent);
        Bungee.swipeLeft(MainActivity.this);

    }

    public void styleActivity(View view) {
        //Enale in style sheeet
        Intent intent = new Intent(MainActivity.this, StyleAnimActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
        //finishAfterTransition();
    }

    public void scaleImage(View view) {
        Intent intent = new Intent(MainActivity.this, ImageScaleActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
        ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
    }
}
