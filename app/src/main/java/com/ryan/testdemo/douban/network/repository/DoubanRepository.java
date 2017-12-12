package com.ryan.testdemo.douban.network.repository;

import com.ryan.testdemo.douban.network.DouBanResponse;

import io.reactivex.Observable;

/**
 * 豆瓣数据接口资源库
 * author： sr on 2017/8/18.
 * e-mail：
 */

public interface DoubanRepository {
    /**
     * 豆瓣top250
     * @param start
     * @param count
     * @return
     */
    Observable<DouBanResponse> getTopMovies(int start, int count);
}
