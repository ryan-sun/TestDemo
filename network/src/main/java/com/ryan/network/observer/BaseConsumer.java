package com.ryan.network.observer;

import io.reactivex.functions.Consumer;

/**
 * Observable订阅的 consumer对象
 * 观察者
 * author： sr on 2017/8/18.
 * e-mail：
 */

public class BaseConsumer<T> {
    private Consumer<T> normalConsumer;
    private Consumer<Throwable> throwableConsumer;

    public Consumer<T> getNormalConsumer() {
        return normalConsumer;
    }

    public void setNormalConsumer(Consumer<T> normalConsumer) {
        this.normalConsumer = normalConsumer;
    }

    public Consumer<Throwable> getThrowableConsumer() {
        return throwableConsumer;
    }

    public void setThrowableConsumer(Consumer<Throwable> throwableConsumer) {
        this.throwableConsumer = throwableConsumer;
    }
}
