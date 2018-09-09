package com.java.demo.factory;
/*
    Retrofit的建造工厂类
 */
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.java.demo.api.ServiceApi;

import retrofit2.Retrofit;

public class RetrofitFactory {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://pic41.nipic.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();


    public static ServiceApi getInstance() {
        return retrofit.create(ServiceApi.class);
    }
}
