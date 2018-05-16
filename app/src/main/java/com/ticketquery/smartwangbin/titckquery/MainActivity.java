package com.ticketquery.smartwangbin.titckquery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }

    public void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect("https://bdkqyy.zwjk.com/hospital/leftno.htm?phID=16").get();
                    Elements elements = document.select("div.reporttable");
                    Log.e("测试", elements.select("div").attr("rbk-subtitle"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
