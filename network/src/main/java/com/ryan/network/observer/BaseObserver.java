package com.ryan.network.observer;

import android.content.Context;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * 观察者
 * author： sr on 2017/8/17.
 * e-mail：
 */

public class BaseObserver<T> implements Observer<T> {
    private static final String TAG = "BaseObserver";
    private Context context;
    public Disposable mDisposable;


    public BaseObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(@NonNull T result) {
        Log.d(TAG,"onNext");
    }

    @Override
    public void onError(@NonNull Throwable e) {
        Log.e(TAG,"onError");
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        Log.d(TAG,"onComplete");
    }

    /**
     * 关闭Observer
     */
    public void dispose(){
        if(mDisposable != null && !mDisposable.isDisposed()){
            mDisposable.dispose();
        }
    }
}
