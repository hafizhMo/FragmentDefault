package com.hafizhmo.fragmentdefault.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movies {

    @SerializedName("results")
    public List<Result> results;

    public static class Result {

        @SerializedName("backdrop_path")
        public String image;

        @SerializedName("original_title")
        public String title;
    }
}
