package com.hafizhmo.fragmentdefault.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hafizhmo.fragmentdefault.R;
import com.hafizhmo.fragmentdefault.adapter.MovieAdapter;
import com.hafizhmo.fragmentdefault.databinding.FragmentHomeBinding;
import com.hafizhmo.fragmentdefault.model.Movies;
import com.hafizhmo.fragmentdefault.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fetchMovies();
    }

    private void fetchMovies(){
        ApiClient api = new ApiClient();
        api.apiInterface().getMoviesNowPlaying().enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {

                binding.recyclerMovie.setLayoutManager(new GridLayoutManager(getContext(), 3));
                binding.recyclerMovie.setAdapter(new MovieAdapter(response.body().results, getContext()));

            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.e("RESPONSE", t.toString());
            }
        });
    }

}