package com.ryan.child1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChildActivity extends AppCompatActivity {

//    @BindView(R.id.btn_choose_operation)
    public Button mBtnChooseOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
//        ButterKnife.bind(this);

    }
}
