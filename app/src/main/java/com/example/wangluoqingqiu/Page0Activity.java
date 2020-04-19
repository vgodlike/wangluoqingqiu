package com.example.wangluoqingqiu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Page0Activity extends AppCompatActivity {

    private List<Page0> page0List =new ArrayList<>();
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page0);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
        recyclerView=findViewById(R.id.recycler_view0);
        sendRequestWithOkHttp();
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("https://www.wanandroid.com/friend/json").build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJSONWithGSON(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        Page0Data page0Data1 = gson.fromJson(jsonData, Page0Data.class);
        final List<Page0Data.DataBean> dataBeanList = page0Data1.getData();
        for (Page0Data.DataBean dataBean : dataBeanList) {
            String icon = dataBean.getIcon();
            int id = dataBean.getId();
            String link = dataBean.getLink();
            String name = dataBean.getName();
            int order = dataBean.getOrder();
            int visible = dataBean.getVisible();
            Page0 page0 =new Page0(icon,id,link,name,order,visible);
            page0List.add(page0);
        }
       Message msg=new Message();
        msg.what=1;
        handler.sendMessage(msg);
    }
    public Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case 1:
                    recyclerView.addItemDecoration(new DividerItemDecoration(Page0Activity.this,DividerItemDecoration.VERTICAL));
                    recyclerView.setLayoutManager(new LinearLayoutManager(Page0Activity.this));
                    Page0Adapter page0Adapter =new Page0Adapter(page0List, Page0Activity.this);
                    recyclerView.setAdapter(page0Adapter);
            }
        }
    };
}
