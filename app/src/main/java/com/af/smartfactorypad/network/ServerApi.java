package com.af.smartfactorypad.network;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by winton on 2017/6/22.
 */

public interface ServerApi {

    public static final String BASE_URL = "https://leadtotech.com/mes-cnc/";

    @GET("{url}")
    Flowable<ResponseBody> executeGet(@Path("url") String url, @QueryMap Map<String,String> params);
    @POST("{url}")
    Flowable<ResponseBody> executePost(@Path("url")String url ,@QueryMap Map<String,String> params);

}
