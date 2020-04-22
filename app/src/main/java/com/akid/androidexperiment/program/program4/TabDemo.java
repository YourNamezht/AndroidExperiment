package com.akid.androidexperiment.program.program4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.akid.androidexperiment.R;
import com.google.android.material.tabs.TabLayout;


public class TabDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_demo_activity);
        setTitle(R.string.program4_activity_name_3);

        TabHost tabHost = (TabHost)findViewById(R.id.tabhost);
        tabHost.setup();
        // 方法3使用，动态载入xml，不需要Activity
        LayoutInflater.from(this).inflate(R.layout.tab1, tabHost.getTabContentView());
        LayoutInflater.from(this).inflate(R.layout.tab2, tabHost.getTabContentView());
        LayoutInflater.from(this).inflate(R.layout.tab3, tabHost.getTabContentView());

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("标签页一").setContent(R.id.tab01));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("标签页二").setContent(R.id.tab02));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("标签页三").setContent(R.id.tab03));

    }
}
