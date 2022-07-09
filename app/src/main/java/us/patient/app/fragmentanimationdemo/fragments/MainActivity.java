package us.patient.app.fragmentanimationdemo.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import us.patient.app.fragmentanimationdemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        showFragmentOne();
    }
    private void showFragmentOne() {
        //Fragment fragmentOne = new FirstFragment();
        Fragment fragmentOne = new Image1Fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragmentOne)
                .commit();
    }
}