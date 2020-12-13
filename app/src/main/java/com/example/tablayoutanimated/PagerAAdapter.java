package com.example.tablayoutanimated;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PagerAAdapter extends FragmentPagerAdapter {

    ArrayList<Class<?>> selectedFragment=new ArrayList<>();
    String []tabTitles;

    public PagerAAdapter(FragmentManager fm, ArrayList<Class<?>> selectedFragment, String[] tabTitles) {
        super(fm);
        this.selectedFragment=selectedFragment;
        this.tabTitles=tabTitles;
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = null;
        try {
            fragment = (Fragment)selectedFragment.get(2-i).newInstance();
        } catch (IllegalAccessException e) {

            e.printStackTrace();
        } catch (InstantiationException e) {

            e.printStackTrace();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[2-position];


    }
}
