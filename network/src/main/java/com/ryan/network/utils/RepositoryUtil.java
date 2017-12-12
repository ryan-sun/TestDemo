package com.ryan.network.utils;

import com.ryan.network.exception.NetworkConnectionException;
import com.ryan.network.exception.ResponseException;
import com.ryan.network.response.BaseResponse;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * 资源库工具
 * author： sr on 2017/8/18.
 * e-mail：
 */

public class RepositoryUtil {
    public static  <T extends BaseResponse> Observable<T> extractData(final Observable<T> observable){
        return observable.concatMap(new Function<T, ObservableSource<? extends T>>() {
            @Override
            public ObservableSource<? extends T> apply(@NonNull T t) throws Exception {
                BaseResponse response = t;
                if(response == null){
                    //没有数据返回
                    Observable.error(new NetworkConnectionException());
                }else if(!response.isSuccess()){
                    //数据请求失败
                    Observable.error(new ResponseException(response));
                }else{
                    //访问数据成功
                    Observable.just(response);
                }
                return null;
            }
        });
    }
}
