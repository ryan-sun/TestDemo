package com.ryan.testdemo.douban.network.api;


import com.ryan.testdemo.douban.network.DouBanResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author： sr on 2017/8/17.
 * e-mail：
 */

public interface DouBanApi {
    @GET("top250")
    Observable<DouBanResponse> getTopMovies(@Query("start") int start,
                                            @Query("count") int count);
}
