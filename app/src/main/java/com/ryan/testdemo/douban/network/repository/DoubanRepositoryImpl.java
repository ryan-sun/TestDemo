package com.ryan.testdemo.douban.network.repository;

import com.ryan.network.RetrofitService;
import com.ryan.testdemo.douban.network.DouBanResponse;
import com.ryan.testdemo.douban.network.api.DouBanApi;

import io.reactivex.Observable;


/**
 * 豆瓣资源库实现
 * author： sr on 2017/8/18.
 * e-mail：
 */

public class DoubanRepositoryImpl implements DoubanRepository {
    private DouBanApi mDouBanApi = RetrofitService.getInstance().createApi(DouBanApi.class);
    @Override
    public Observable<DouBanResponse> getTopMovies(int start, int count) {
        return mDouBanApi.getTopMovies(start,count);
    }
}
