package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ListView m_oListView = null;
    private ViewPager mViewPager;

    SectionsPagerAdapter adapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //       setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(adapter);
        TabLayout tabs = binding.tabs;

        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String[] strName = {"박강우", "김기현", "김성혁", "김성애"};
        String[] strPhone = {"010-1234-5678", "010-2345-6789", "010-4455-6677", "010-3941-9805"};
        int nDatCnt=0;
        ArrayList<ItemData> oData = new ArrayList<>();
        for (int i=0; i<strName.length; ++i)
        {
            ItemData oItem = new ItemData();
            oItem.Name = strPhone[nDatCnt];
            oItem.PhoneNumber = strName[nDatCnt++];
            oData.add(oItem);
            if (nDatCnt >= strName.length) nDatCnt = 0;
        }

        m_oListView = (ListView) findViewById(R.id.listView);
        ListAdapter oAdapter = new ListAdapter(oData);
        m_oListView.setAdapter(oAdapter);
    }

    public void onButton1Clicked(View v) {
        Toast.makeText(this,"전화 걸기", Toast.LENGTH_LONG).show();
    }

    public void onButton2Clicked(View v) {
        Toast.makeText(this,"문자 보내기", Toast.LENGTH_LONG).show();
    }
}