package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.Serializable;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();
        ProductInfo productInfo = (ProductInfo) intent.getSerializableExtra("productInfo");

        if (productInfo != null) {
            ImageView productImage = findViewById(R.id.product_image);
            TextView productName = findViewById(R.id.product_name);
            TextView productPrice = findViewById(R.id.product_price);
            TextView productDetails = findViewById(R.id.product_details);

            // 使用 Glide 加载图片
            Glide.with(this).load(productInfo.getImageUrl()).into(productImage);

            // 设置商品名称、价格和详情
            productName.setText(productInfo.getName());
            productPrice.setText(String.valueOf(productInfo.getPrice()));
            productDetails.setText(productInfo.getDetails());
        }
    }


}