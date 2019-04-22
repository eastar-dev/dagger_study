package com.chihacker.daggersample.ui;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.chihacker.daggersample.R;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by chihacker on 2017. 8. 13..
 */

public class MoviesFragment extends Fragment implements MoviesFragmentContract.View {

    @Inject MoviesFragmentContract.Presenter presenter;

    private ListView listMovies;

    public static MoviesFragment newInstance(String category){

        MoviesFragment fragment = new MoviesFragment();

        Bundle bundle = new Bundle();
        bundle.putString("category",category);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        listMovies = (ListView)view.findViewById(R.id.lv_movies);
        presenter.loadMovies(getArguments().getString("category"));

    }



    @Override
    public void setList(List<String> movies) {
        ArrayAdapter adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,movies.toArray());
        listMovies.setAdapter(adapter);
    }
}
