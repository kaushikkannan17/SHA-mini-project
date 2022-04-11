package com.example.smarthomeautomation;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdap extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public LoginAdap(FragmentManager fm, Context context, int totalTabs){
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return 0;
    }

    public Fragment getItem(int position){
        switch (position){
            case 0:
                logintabfrag logintabfrag = new logintabfrag();
                return logintabfrag;
            case 1:
                signuptabfrag signuptabfrag = new signuptabfrag();
                return signuptabfrag;
            default:
                return null;
        }
    }

}
