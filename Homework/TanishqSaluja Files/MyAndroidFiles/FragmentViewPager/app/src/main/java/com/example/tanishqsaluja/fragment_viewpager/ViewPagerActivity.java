package com.example.tanishqsaluja.fragment_viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

/**
 * Created by tanishqsaluja on 25/1/18.
 */

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_layout);
        MyViewPagerAdapter myViewPagerAdapter=new MyViewPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager=findViewById(R.id.viewPager);
        viewPager.setAdapter(myViewPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
    class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Chats";
                case 1 :
                    return "Status";
                case 2 :
                    return "Call";
                case 3 :
                    return "Home";
                case 4 :
                    return "Work";
                case 5 :
                    return "Play";
                case 6 :
                    return "Food";
                case 7 :
                    return "Commuting";
                default:
                    return "No Title";
            }
        }
        @Override
        public Fragment getItem(int position) {
            Fragment fragment=new MyFragment();
            Bundle bundle=new Bundle();
            bundle.putInt("POS",position);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return 15;
        }
    }
}
