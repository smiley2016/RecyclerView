package com.example.fragmentrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup newLayout = findViewById(R.id.constraintFragment);

        if(newLayout != null){
            MainFragment fragment = new MainFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(newLayout.getId(), fragment, MainFragment.class.getName());
            ft.addToBackStack("main_fragment");
            ft.commit();
        }
    }
}
