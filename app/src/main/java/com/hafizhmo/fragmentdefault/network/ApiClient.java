package com.hafizhmo.fragmentdefault.network;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String API_KEY = "0932a7e47c1a3feb4b979a65ad30aa5c";

    public ApiInterface apiInterface() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).client(okHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiInterface.class);
    }

    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder().addInterceptor(chain -> {
            Request original = chain.request();
            HttpUrl url = original.url().newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .build();

            Request.Builder builder = original.newBuilder().url(url);
            return chain.proceed(builder.build());
        }).build();
    }
}
