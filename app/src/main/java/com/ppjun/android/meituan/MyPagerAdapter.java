package com.ppjun.android.meituan;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Package :com.ppjun.android.meituan
 * Description :
 * Author :Rc3
 * Created at :2017/04/05 18:50.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> l;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> l) {
        super(fm);
        this.l = l;
    }


    @Override
    public Fragment getItem(int position) {
        return l.get(position);
    }

    @Override
    public int getCount() {
        return l.size();
    }
}
