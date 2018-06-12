package com.af.smartfactorypad.network;

import android.text.TextUtils;

import com.af.smartfactorypad.BuildConfig;
import com.af.smartfactorypad.MyApplication;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by winton on 2017/6/23.
 */

public class RetrofitClient {

    private static final int DEFAULT_TIMEOUT = 5;
    private ServerApi mServer;

    public static String baseUrl = ServerApi.BASE_URL;


    private OkHttpClient mOkHttpClient;


    private static class InstanceHolder{
        private static RetrofitClient instance = new RetrofitClient();
    }

    public static RetrofitClient getInstance(){
        return InstanceHolder.instance;
    }


    private RetrofitClient(){
        this(null);
    }

    private RetrofitClient(String url){
        if(TextUtils.isEmpty(url)){
            url = baseUrl;
        }
        ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(),new SharedPrefsCookiePersistor(MyApplication.INSTANCE));
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .cookieJar(cookieJar);
        if(BuildConfig.DEBUG){
            builder.addInterceptor(new LoggerInterceptor("OKHttp"));
        }

        mOkHttpClient = new OkHttpClient.Builder()
                        .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .build();
        Retrofit retrofit = new Retrofit.Builder()
                                .client(mOkHttpClient)
                                .addConverterFactory(GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .baseUrl(url)
                                .build();
        mServer = retrofit.create(ServerApi.class);
    }

    /**
     * 线程调度器
     * @return
     */
    public static FlowableTransformer schedulersTransForm(){
        return new FlowableTransformer(){

            @Override
            public Publisher apply(Flowable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /****************************************接口实现*********************************************/

    public void post(String url , Map<String,String> params, Subscriber<ResponseBody> subscriber){
        mServer.executePost(url,params)
                .compose(schedulersTransForm())
                .subscribe(subscriber);
    }

    public void get(String url,Map<String,String> params,Subscriber<ResponseBody> subscriber){
        mServer.executeGet(url,params)
                .compose(schedulersTransForm())
                .subscribe(subscriber);
    }

    public ServerApi getServer(){
        return mServer;
    }

}
