package com.ryan.testdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.orhanobut.logger.Logger;
import com.ryan.child1.ChildActivity;
import com.ryan.testdemo.canvas.TestCanvasActivity;
import com.ryan.testdemo.douban.DoubanTopMovieActivity;
import com.ryan.testdemo.tinker.TestTinkerActivity;

import java.util.HashMap;

import static com.daimajia.slider.library.SliderLayout.*;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener
                                                                ,ViewPagerEx.OnPageChangeListener{
    private SliderLayout mSliderLayout;
    private Button btnTop;
    private Button btnCanvas;//定义画布
    private Button btnTinker;//测试tinker入口按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSliderLayout = (SliderLayout) findViewById(R.id.slayout_slider);
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        for (String name:url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra",name);
            mSliderLayout.addSlider(textSliderView);
        }
        mSliderLayout.setPresetTransformer(Transformer.Accordion);
        mSliderLayout.setPresetIndicator(PresetIndicators.Center_Bottom);
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setDuration(3000);
        mSliderLayout.addOnPageChangeListener(this);

        btnTop = (Button) findViewById(R.id.btn_top250);
        btnTop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DoubanTopMovieActivity.class));
            }
        });

        btnCanvas = (Button) findViewById(R.id.btn_canvas);
        btnCanvas.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestCanvasActivity.class));
            }
        });

        btnTinker = findViewById(R.id.btn_tinker);
        btnTinker.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TestTinkerActivity.class));
            }
        });
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
//        Toast.makeText(this,slider.getBundle().getString("extra"),Toast.LENGTH_SHORT).show();
//        mSliderLayout.startAutoCycle();
        startActivity(new Intent(MainActivity.this, ChildActivity.class));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Logger.d("Page Changed: "+position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mSliderLayout.startAutoCycle();
    }

    @Override
    protected void onStop() {
        mSliderLayout.stopAutoCycle();
        super.onStop();
    }
}
