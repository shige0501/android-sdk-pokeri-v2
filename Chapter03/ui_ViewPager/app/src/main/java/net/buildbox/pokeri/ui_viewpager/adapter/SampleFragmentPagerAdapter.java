package net.buildbox.pokeri.ui_viewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.buildbox.pokeri.ui_viewpager.fragment.FirstFragment;
import net.buildbox.pokeri.ui_viewpager.fragment.SecondFragment;
import net.buildbox.pokeri.ui_viewpager.fragment.ThirdFragment;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FirstFragment.newInstance();
            case 1:
                return SecondFragment.newInstance();
            case 2:
                return ThirdFragment.newInstance();
            default:
                throw new IllegalArgumentException("position: " + position + " is unsupported.");
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (position + 1) + " ページ";
    }
}
