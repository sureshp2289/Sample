package sample.example.com.sample.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import sample.example.com.sample.R;

/**
 * Created by Start4me on 6/9/2017.
 */

public class CustomPagerAdapter  extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    int [] mResources;

    public CustomPagerAdapter(Context context,int[] image) {
        mContext = context;
        mResources=image;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((FrameLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        View view = (View) itemView.findViewById(R.id.imageView);
        view.setBackgroundColor(mResources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((FrameLayout) object);
    }
}