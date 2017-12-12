package com.ryan.testdemo.douban.network.observable;

import com.ryan.network.observable.UseObservable;
import com.ryan.testdemo.douban.network.DouBanResponse;
import com.ryan.testdemo.douban.network.repository.DoubanRepositoryImpl;

import io.reactivex.Observable;

/**
 * 豆瓣被观察者使用
 * author： sr on 2017/8/18.
 * e-mail：
 */

public class DoubanUseObservable extends UseObservable<DouBanResponse> {
    private DoubanRepositoryImpl mDoubanRepository = new DoubanRepositoryImpl();
    private int start;
    private int count;
    public void setParams(int start,int count){
        this.start = start;
        this.count = count;
    }

    @Override
    protected Observable<DouBanResponse> bindUseObserver() {
        return mDoubanRepository.getTopMovies(start,count);
    }
}
