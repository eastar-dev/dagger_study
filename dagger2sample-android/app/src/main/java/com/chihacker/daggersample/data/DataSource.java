package com.chihacker.daggersample.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by chihacker on 2017. 8. 13..
 */

public interface DataSource {
    List<String> getMovies(String category);

    List<String> getCategory();
}
