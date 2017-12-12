package com.ryan.network.observable;

import com.ryan.network.observer.BaseConsumer;
import com.ryan.network.RxSchedulers;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 *  被观察者的使用
 * author： sr on 2017/8/17.
 * e-mail：
 */

public abstract class UseObservable<T> {
    public Observable<T> mObservable;
    private Disposable mDisposable;
    /**
     * 订阅Observer对象
     * 建立订阅关系
     * @param observer
     */
    public void subscribe(Observer<T> observer){
        mObservable = bindUseObserver();
        mObservable.compose(RxSchedulers.<T>compose())
                .subscribe(observer);
    }

    protected abstract Observable<T> bindUseObserver();

    /**
     * Observable订阅consumer
     * @param baseConsumer
     */
    public void subscriber(BaseConsumer<T> baseConsumer){
        mDisposable = bindUseObserver().compose(RxSchedulers.<T>compose())
                .subscribe(baseConsumer.getNormalConsumer(), baseConsumer.getThrowableConsumer());
    }

    public void disposable(){
        if(mDisposable != null && !mDisposable.isDisposed()){
            mDisposable.dispose();
        }
    }
}
