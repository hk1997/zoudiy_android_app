package com.example.zoudiy;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String Base_Url="https://zoudiy.com/";
    private static  RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit=new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(mInstance==null)
            mInstance=new RetrofitClient();
        return mInstance;
    }
    public JsonPlaceholderApi getApi(){
        return retrofit.create(JsonPlaceholderApi.class);
    }
}
