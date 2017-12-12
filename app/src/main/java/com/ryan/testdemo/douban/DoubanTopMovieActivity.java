package com.ryan.testdemo.douban;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ryan.network.observer.BaseObserver;
import com.ryan.testdemo.R;
import com.ryan.testdemo.douban.bean.DouBanBean;
import com.ryan.testdemo.douban.network.DouBanResponse;
import com.ryan.testdemo.douban.network.observable.DoubanUseObservable;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class DoubanTopMovieActivity extends AppCompatActivity {
    private static final String TAG = "DoubanTopMovieActivity";
    private TextView tvMovieTitles;//电影标题
    private DoubanUseObservable mDoubanUseObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douban_top_movie);
        tvMovieTitles = (TextView) findViewById(com.ryan.network.R.id.tv_movie_title);

        mDoubanUseObservable = new DoubanUseObservable();
        mDoubanUseObservable.setParams(1,10);
        mDoubanUseObservable.subscribe(new DoubanObserver(this));

    }


    private StringBuffer mStringBuffer = new StringBuffer();
    private class DoubanObserver extends BaseObserver<DouBanResponse> {

        public DoubanObserver(Context context) {
            super(context);
        }

        @Override
        public void onNext(@NonNull DouBanResponse result) {
            super.onNext(result);
            List<DouBanBean> list = result.data;
            if(list != null){
                mStringBuffer = new StringBuffer();
                Log.d(TAG,"list size is "+list.size());
                for (int i = 0;i<list.size();i++){
                    mStringBuffer.append(String.valueOf(i)+"、").append(list.get(i).getTitle())
                            .append("; \n");
                }
                tvMovieTitles.setText(mStringBuffer.toString());
            }
        }
    }
}
