package com.ilkayaktas.makemepopular.views.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.ilkayaktas.makemepopular.views.activities.base.BaseFragment;
import com.ilkayaktas.makemepopular.views.fragments.photogrid.PhotosGridFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iaktas on 12.09.2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "ViewPagerAdapter";
    private final String[] categories;
    private FragmentManager fragmentManager;
    private List<BaseFragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm, String[] categories) {
        super(fm);
        this.fragmentManager = fm;
        this.categories = categories;
        this.fragmentList = new ArrayList<>();

        initiateFragments();

    }

    private void initiateFragments(){
        for (String category : categories) {
            fragmentList.add(PhotosGridFragment.newInstance(category));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return categories.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categories[position];
    }

    public void updateVisibleFragment(int position){
        ((PhotosGridFragment)fragmentList.get(position)).updateFragment();
    }

    public interface OnUpdateFragment{
        void updateFragment();
    }
}
