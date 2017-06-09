package sample.example.com.sample;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;


import com.viewpagerindicator.CirclePageIndicator;

import sample.example.com.sample.adapter.CustomPagerAdapter;
import sample.example.com.sample.adapter.ViewPagerAdapter;
import sample.example.com.sample.apputils.AppUtils;
import sample.example.com.sample.fragment.Images;
import sample.example.com.sample.fragment.MIlestones;
import sample.example.com.sample.fragment.Videos;

public class Home extends FragmentActivity {
ViewPager sildervideo;
    private HorizontalScrollView horizontalScrollView;
CirclePageIndicator circlePageIndicator;
    CustomPagerAdapter mCustomPagerAdapter;
    private String[] tabs;
    FragmentTabHost tabHost;
    ViewPagerAdapter pagerAdapter;
    ViewPager viewPager;
    private TabWidget tabWidget;
    static ImageView tabimage;
    static TextView tabtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intialzewidgets();

    }

    private void Intialzewidgets() {
        int color=AppUtils.adjustAlpha(getResources().getColor(R.color.orange),0.8f);
        AppUtils.statusbar(Home.this,color);
        tabs = new String[] { "Videos", "Image", "Milestones" };
        sildervideo=(ViewPager)findViewById(R.id.video_slider);
        circlePageIndicator=(CirclePageIndicator) findViewById(R.id.indicator);
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabWidget = (TabWidget) findViewById(android.R.id.tabs);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realTabContent);
        setupTabHost();
        int[] mResources = {
                R.color.colorPrimaryDark,
                R.color.orange,
                R.color.pink,
                R.color.brown,

        };
        mCustomPagerAdapter = new CustomPagerAdapter(Home.this,mResources);


        sildervideo.setAdapter(mCustomPagerAdapter);
        circlePageIndicator.setViewPager(sildervideo);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabs);
        viewPager.setAdapter(pagerAdapter);
        setTabColor(tabHost);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            /**
             * on swipe select the respective tab
             * */
            @Override
            public void onPageSelected(int position) {
                invalidateOptionsMenu();
                tabHost.setCurrentTab(position);
                setTabColor(tabHost);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                invalidateOptionsMenu();
            }
        });

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                viewPager.setCurrentItem(tabHost.getCurrentTab());
                setTabColor(tabHost);

            }
        });
        }

    private void setupTabHost() {


        tabHost.addTab(tabHost.newTabSpec("Videos").setIndicator(createTabView(Home.this, getResources().getDrawable(R.drawable.record), "Videos", 0)),
                Videos.class,null);
        tabHost.addTab(tabHost.newTabSpec("Image").setIndicator(createTabView(Home.this, getResources().getDrawable(R.drawable.image), "Images", 0)),
                Images.class,null);
        tabHost.addTab(tabHost.newTabSpec("Milestones").setIndicator(createTabView(Home.this, getResources().getDrawable(R.drawable.milestones), "Milestones", 0)),
                MIlestones.class,null);
    }
    private static View createTabView(final Context context, final Drawable image, final String text, int pos) {

        View tab_view = LayoutInflater.from(context).inflate(R.layout.tablayout, null);
        tabimage = (ImageView) tab_view.findViewById(R.id.tabs_image);
        tabimage.setImageDrawable(image);
        // drawableimage=image;

        tabtext = (TextView) tab_view.findViewById(R.id.tabs_tv);


        tabtext.setText(text);
        tabtext.setTextSize(9.25f);

        //txt_text.setGravity(Gravity.CENTER);
        return tab_view;
    }
    public void setTabColor(TabHost tabhost) {
        //  Toast.makeText(Tablayout.this,""+tabhost.getCurrentTab(),Toast.LENGTH_SHORT).show();
        for (int i = 0; i < tabhost.getTabWidget().getChildCount(); i++) {
            int color= getResources().getColor(R.color.grey);
            tabhost.getTabWidget().getChildAt(i).setBackgroundColor(color);
            tabtext = (TextView) tabhost.getTabWidget().getChildAt(i).findViewById(R.id.tabs_tv);//Unselected Tabs
            tabtext.setTextColor(getResources().getColor(R.color.lightgrey));
            tabtext.setTextSize(TypedValue.COMPLEX_UNIT_DIP,10f);

            tabimage = (ImageView) tabhost.getTabWidget().getChildAt(i).findViewById(R.id.tabs_image);
            tabimage.setColorFilter(getResources().getColor(R.color.lightgrey), PorterDuff.Mode.SRC_ATOP);//Unselected Tabs
            // img.setImageDrawable(drawableimage);
            //unselected
            // }
        }
        // tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab()).setBackgroundColor(Color.parseColor("#B37D4E")); // selected
        if (tabhost.getCurrentTab() == 0) {
            tabtext = (TextView) tabhost.getCurrentTabView().findViewById(R.id.tabs_tv);
            //Unselected Tabs

            tabtext.setTextColor(getResources().getColor(R.color.orange));
            tabimage = (ImageView) tabhost.getCurrentTabView().findViewById(R.id.tabs_image);
            tabimage.setColorFilter(getResources().getColor(R.color.orange), PorterDuff.Mode.SRC_ATOP);



        } else {
            tabtext = (TextView) tabhost.getCurrentTabView().findViewById(R.id.tabs_tv);
            //Unselected Tabs
            tabtext.setTextColor(getResources().getColor(R.color.orange));
            tabimage = (ImageView) tabhost.getCurrentTabView().findViewById(R.id.tabs_image);
            tabimage.setColorFilter(getResources().getColor(R.color.orange), PorterDuff.Mode.SRC_ATOP);
        }


    }


}
