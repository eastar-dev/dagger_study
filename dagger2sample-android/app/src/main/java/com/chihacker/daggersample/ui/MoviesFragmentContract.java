package com.chihacker.daggersample.ui;


import java.util.List;

/**
 * Created by chihacker on 2017. 8. 13..
 */

public interface MoviesFragmentContract {
    interface View{
        void setList(List<String> movies);
    }
    interface Presenter{
        void loadMovies(String category);
    }
}
