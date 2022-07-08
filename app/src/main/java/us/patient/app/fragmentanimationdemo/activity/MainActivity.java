package us.patient.app.fragmentanimationdemo.activity;

import android.app.ActivityOptions;
import android.content.Intent;

import android.os.Bundle;

import androidx.core.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.util.Pair;
import androidx.core.app.ActivityOptionsCompat;

import us.patient.app.fragmentanimationdemo.R;

public class MainActivity extends AppCompatActivity {
    //https://gist.github.com/lopspower/1a0b4e0c50d90fbf2379
    //https://github.com/lgvalle/Material-Animations
    //https://developer.android.com/guide/fragments
    //https://github.com/SmartToolFactory/Animation-Tutorials
    //https://medium.com/bynder-tech/how-to-use-material-transitions-in-fragment-transactions-5a62b9d0b26b(Branding animation)
//https://www.youtube.com/watch?v=z9_EsRclGL0
    //https://github.com/Pei116/sharedelementtransition/tree/master/app/src/main/java/com/wwk/sharedelementtransition


    //https://github.com/achmadqomarudin/MaterialTransition
    private Button button1 = null;
    private Button button2 = null;
    private Button button3 = null;
    private Button button4 = null;
    private Button button5 = null;
    ImageView iv,iv1;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initListener();
    }

    /**
     * 实现组件的初始化操作
     */
    private void initView() {
        button1 = (Button) findViewById(R.id.button1);
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv);
        iv1 = (ImageView) findViewById(R.id.iv1);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
    }

    /**
     * 实现组件的初始化监听
     */
    private void initListener() {
        /**
         * 点击按钮,实现Activity的跳转操作
         * 通过overridePendingTransition方法的方式实现activity的跳转动画
         */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ThreeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_right);

                /*button1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_in_top);
                    }
                }, 1000);*/
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_in_top);
                    }
                }).start();*/


            }
        });



        /**
         * 点击按钮,实现Activity的跳转操作
         * 通过android5.0及以上代码的方式实现activity的跳转动画
         */
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThreeActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                //finishAfterTransition();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FourActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                finishAfterTransition();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FiveActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, button5, "shareNames").toBundle());
            }
        });
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent(MainActivity.this, MakeSceneAnimActivity.class);
                Pair<View, String> p1=Pair.create(iv, "string1");
                Bundle b=ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, p1).toBundle();
                ActivityCompat.startActivity(MainActivity.this,intent,b);*/
                Intent intent = new Intent(MainActivity.this, MakeSceneAnimActivity.class);
                Pair<View, String> p1=Pair.create(iv, "shareNames");
                Pair<View, String> p2=Pair.create(tv, "shareNames1");
                Bundle b=ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, p1,p2).toBundle();
                ActivityCompat.startActivity(MainActivity.this,intent,b);
            }
        });
    }

    private void test1() {

    }
}
