package com.example.asm_mob201.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.asm_mob201.fragment.Fragment_cuoi;
import com.example.asm_mob201.fragment.Fragment_khoa_hoc;
import com.example.asm_mob201.fragment.Fragment_suc_khoe;


public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Fragment_cuoi();
                break;
            case 1:
                fragment = new Fragment_khoa_hoc();
                break;
            case 2:
                fragment = new Fragment_suc_khoe();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
