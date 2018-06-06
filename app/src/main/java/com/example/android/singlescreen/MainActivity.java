package com.example.android.singlescreen;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout sliderDotsPanel;
    private int dotsCount;
    private ImageView dots [];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 4000,6000);
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    }
                    else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    }
                    else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(3);
                    }
                    else if (viewPager.getCurrentItem() == 3) {
                        viewPager.setCurrentItem(4);
                    }
                    else if (viewPager.getCurrentItem() == 4) {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

}

