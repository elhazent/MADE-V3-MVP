package com.elhazent.education.madev3.ui.tvshow;

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

public class TvshowFragment extends Fragment implements TvshowContract.View {


    private RecyclerView recyclerView;
    public final String EXTRA_DATA = "data";
    private ProgressBar progressBar;
    private ArrayList<ResultsItem> data = new ArrayList<>();
    private TvshowAdapter adapter;
    private TvshowPresenter presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_tvshow);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void showTvshow(ResponseMovies dataTvshow) {
        data = (ArrayList<ResultsItem>) dataTvshow.getResults();
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new TvshowPresenter(this);

        adapter = new TvshowAdapter(getContext(),data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        if (savedInstanceState == null){
            presenter.getTvshow();

        } else {
            data= savedInstanceState.getParcelableArrayList(EXTRA_DATA);
            adapter.refill(data);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList(EXTRA_DATA, data);
        super.onSaveInstanceState(outState);
    }
}
