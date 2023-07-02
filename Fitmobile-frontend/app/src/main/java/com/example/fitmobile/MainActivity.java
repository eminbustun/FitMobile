package com.example.fitmobile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    String musclegr = new String();
    ViewPager2 viewPager2;

    TabLayout tabLayout;



    ExercisePageAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //  getSupportActionBar().setHomeAsUpIndicator(R.mipmap.arnold); error verdi

        viewPager2 = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        pagerAdapter = new ExercisePageAdapter(getSupportFragmentManager(), getLifecycle());

        viewPager2.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
                    musclegr = "";
                    switch (position) {

                        case 0:
                            tab.setText("Chest");
                            musclegr = "Chest";
                            break;

                        case 1:
                            tab.setText("Back");
                            musclegr = "Back";

                            break;

                        case 2:
                            tab.setText("Legs");
                            musclegr = "Legs";

                            break;

                        case 3:
                            tab.setText("Core");
                            musclegr = "Core";

                            break;

                        case 4:
                            tab.setText("Arms");
                            musclegr = "Arms";


                            break;
                    }


                }
        ).attach();

    }



    class ExercisePageAdapter extends FragmentStateAdapter{


        public ExercisePageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {

            if (position == 0){
                musclegr = "Chest";

            }
            else if (position == 1){
                musclegr = "Back";

            }
            else if (position == 2){
                musclegr = "Legs";

            }
            else if (position == 3){
                musclegr = "Core";

            }
            else if (position == 4){
                musclegr = "Arms";

            }

            Fragment frg = new ExerciseListFragment(musclegr, ((ExerciseApplication)getApplication()).srv);
            return frg;
        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }



}