package com.ryan.testdemo.douban.network;

import com.google.gson.annotations.SerializedName;
import com.ryan.network.response.BaseResponse;
import com.ryan.testdemo.douban.bean.DouBanBean;

import java.util.List;

/**
 * author： sr on 2017/8/17.
 * e-mail：
 */

public class DouBanResponse extends BaseResponse {

    @SerializedName("subjects")
    public List<DouBanBean> data;

}
