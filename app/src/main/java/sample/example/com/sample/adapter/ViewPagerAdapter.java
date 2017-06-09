package sample.example.com.sample.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import sample.example.com.sample.fragment.Images;
import sample.example.com.sample.fragment.MIlestones;
import sample.example.com.sample.fragment.Videos;

/**
 * Created by HNAbbasi on 8/18/15.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    String[] tabs;

    public ViewPagerAdapter(FragmentManager fm, String[] tabs) {
        super(fm);
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int i) {
        if(i==0)
        {
            return Videos.newInstance(String.format("%s Fragment", tabs[i]));
        }
        if(i==1)
        {
            return Images.newInstance(String.format("%s Fragment", tabs[i]));
        }
        else {
            return MIlestones.newInstance(String.format("%s Fragment", tabs[i]));
        }

    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
