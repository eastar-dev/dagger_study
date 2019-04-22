package com.chihacker.daggersample.ui;


import java.util.List;

/**
 * Created by chihacker on 2017. 7. 28..
 */

public interface MainActivityContract {

    interface View{
        void setViewPager(List<String> categories);
    }

    interface Presenter{
        void loadCategory();
    }
}
