package com.example.tablayoutanimated;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tablayoutanimated.fragments.Fragment1;
import com.example.tablayoutanimated.fragments.Fragment2;
import com.example.tablayoutanimated.fragments.Fragment3;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    SmartTabLayout tabLayout;
    ViewPager viewPager;

    ArrayList<Class<?>> selectedFragment=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        setViewPager();
        setTypeface();

    }
    private void setViewPager() {

// to use in fragment        PagerAAdapter adapter = new PagerAAdapter(getChildFragmentManager(),getSelectedFragment(),getTabTitles());
        PagerAAdapter adapter = new PagerAAdapter(getSupportFragmentManager(),getSelectedFragment(),getTabTitles());  // to use in activity

        viewPager.setAdapter(adapter);
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager);

        viewPager.setCurrentItem(3);
    }

    private String[] getTabTitles() {
        return   getResources().getStringArray(R.array.library_title);
    }

    public ArrayList<Class<?>> getSelectedFragment(){
        selectedFragment.add(Fragment1.class);
        selectedFragment.add(Fragment2.class);
        selectedFragment.add(Fragment3.class);
        return selectedFragment;

    }


    public void setTypeface() {

        ViewGroup vg = (ViewGroup)tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            TextView vgTab = (TextView) vg.getChildAt(j);
            vgTab.setTypeface(FontUtil.getInstance(this).getRegularFont());

        }
    }

}