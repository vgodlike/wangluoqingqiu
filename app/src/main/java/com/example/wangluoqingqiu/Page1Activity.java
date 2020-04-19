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

public class Page1Activity extends AppCompatActivity {

    private List<Page1> page1List =new ArrayList<>();
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
        recyclerView=findViewById(R.id.recycler_view1);
        sendRequestWithOkHttp();
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("https://www.wanandroid.com//hotkey/json").build();
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
        Page1Data page1Data1 = gson.fromJson(jsonData, Page1Data.class);
        final List<Page1Data.DataBean> dataBeanList = page1Data1.getData();
        for (Page1Data.DataBean dataBean : dataBeanList) {
            int id = dataBean.getId();
            String link = dataBean.getLink();
            String name = dataBean.getName();
            int order = dataBean.getOrder();
            int visible = dataBean.getVisible();
            Page1 page1 =new Page1(id,link,name,order,visible);
            page1List.add(page1);
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
                    recyclerView.addItemDecoration(new DividerItemDecoration(Page1Activity.this,DividerItemDecoration.VERTICAL));
                    recyclerView.setLayoutManager(new LinearLayoutManager(Page1Activity.this));
                    Page1Adapter page1Adapter =new Page1Adapter(page1List, Page1Activity.this);
                    recyclerView.setAdapter(page1Adapter);
            }
        }
    };
}