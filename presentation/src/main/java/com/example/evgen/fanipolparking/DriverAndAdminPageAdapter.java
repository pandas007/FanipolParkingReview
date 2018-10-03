package com.example.evgen.fanipolparking;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class DriverAndAdminPageAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    private static String tabTitles[] = new String[] {"Водитель", "Администратор"};
    private Context context;

    public DriverAndAdminPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new DriverFragment();

            case 1:
                return new AdminFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
