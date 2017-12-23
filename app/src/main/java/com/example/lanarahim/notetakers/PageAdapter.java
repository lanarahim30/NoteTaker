package com.example.lanarahim.notetakers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Lana Rahim on 12/20/2017.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                PribadiFragment tab1 = new PribadiFragment();
                return tab1;
            case 1:
                BisnisFragment tab2 = new BisnisFragment();
                return tab2;
            case 2:
                EdukasiFragment tab3 = new EdukasiFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
