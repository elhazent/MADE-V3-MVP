package com.elhazent.education.madev3.ui.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elhazent.education.madev3.R;
import com.elhazent.education.madev3.model.ResponseMovies;
import com.elhazent.education.madev3.model.ResultsItem;

import java.util.ArrayList;

public class MoviesFragment extends Fragment implements MoviesContract.View {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<ResultsItem> data = new ArrayList<>();
    private MoviesAdapter adapter;
    private MoviesPresenter presenter;
    public final String EXTRA_DATA = "data";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_movies);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void showMovies(ResponseMovies dataMovies) {
        data = (ArrayList<ResultsItem>) dataMovies.getResults();
        adapter.refill(data);

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
    }

    @Override
    public void onDettachView() {
        presenter.onDettach();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new MoviesPresenter(this);


        adapter = new MoviesAdapter(getContext(),data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        if (savedInstanceState == null){
            presenter.getMovies();

        } else {
            data= savedInstanceState.getParcelableArrayList(EXTRA_DATA);
            adapter.refill(data);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onStart() {
        onAttachView();
        super.onStart();
    }

    @Override
    public void onDestroy() {
        onDettachView();
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList(EXTRA_DATA, data);
        super.onSaveInstanceState(outState);
    }
}