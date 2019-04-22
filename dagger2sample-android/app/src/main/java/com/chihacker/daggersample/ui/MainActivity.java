package com.chihacker.daggersample.ui;

import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.chihacker.daggersample.R;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector,MainActivityContract.View{

    @Inject MainActivityContract.Presenter presenter;
    @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;


    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);

        viewPager = (ViewPager)findViewById(R.id.vp_list);
        tabLayout = (TabLayout)findViewById(R.id.tl_list_tab);

        presenter.loadCategory();


    }

    @Override
    public void setViewPager(List<String> categories) {
        viewPager.setAdapter(new ListPageAdapter(getSupportFragmentManager(),categories));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    private class ListPageAdapter extends FragmentPagerAdapter {

        private List<String> categories;

        public ListPageAdapter(FragmentManager fm, List<String> categories) {
            super(fm);
            this.categories = categories;
        }

        @Override
        public Fragment getItem(int position) {
            return MoviesFragment.newInstance(categories.get(position));
        }

        @Override
        public int getCount() {
            return categories.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return categories.get(position);
        }
    }
}
