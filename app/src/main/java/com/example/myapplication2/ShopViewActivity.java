package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ShopViewActivity extends AppCompatActivity {
    ListView listView;
    Button buttonSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopview);
        listView = findViewById(R.id.list_view);

        List<ProductInfo> productInfoList = new ArrayList<>();
        ProductInfo productInfo = new ProductInfo("IPad Pro 2024", R.mipmap.ming_app, 1, 19999.99, "简介 地表最强平板", "https://www.apple.com.cn/newsroom/images/2024/05/apple-unveils-stunning-new-ipad-pro-with-m4-chip-and-apple-pencil-pro/article/Apple-iPad-Pro-Ultra-Retina-XDR-display-2-up-240507_inline.jpg.large.jpg");
        productInfoList.add(productInfo);
        ProductViewAdapter productViewAdapter = new ProductViewAdapter(productInfoList, this);
        listView.setAdapter(productViewAdapter);


    }
        public void openProductDetailsActivity(View view) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        startActivity(intent);
    }

}