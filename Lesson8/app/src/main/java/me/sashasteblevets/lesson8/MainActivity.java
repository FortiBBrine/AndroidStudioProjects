package me.sashasteblevets.lesson8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button fragment1;
    private Button fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = findViewById(R.id.button1);
        fragment2 = findViewById(R.id.button2);

        FirstFragment firstFragment = new FirstFragment();
        SecondFragment secondFragment = new SecondFragment();

        this.setFragment(firstFragment);

        fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(firstFragment);
            }
        });

        fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(secondFragment);
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.frameLayout, fragment);
        // Щоб менше пам'яті їло
        // ft.addToBackStack(null);
        ft.commit();
    }

}