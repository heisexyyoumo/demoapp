package com.java.demo.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface ServiceApi {
    @GET
    Observable<ResponseBody> downloadPicFromNet(@Url String fileUrl);
}
