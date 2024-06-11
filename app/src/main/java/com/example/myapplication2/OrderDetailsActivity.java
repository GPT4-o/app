package com.example.myapplication2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class OrderDetailsActivity extends AppCompatActivity {

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Intent intent = getIntent();
        ProductInfo productInfo = (ProductInfo) intent.getSerializableExtra("productInfo");

        if (productInfo != null) {
            TextView productName = findViewById(R.id.product_name);
            TextView productQuantity = findViewById(R.id.product_quantity);
            TextView productPrice = findViewById(R.id.product_price);
            TextView productTotalPrice = findViewById(R.id.product_total_price);
            ImageView productImage = findViewById(R.id.product_image);
            Glide.with(this).load(productInfo.getImageUrl()).into(productImage);

            // 设置商品名称、数量和价格
            productName.setText(productInfo.getName());
            productQuantity.setText(String.valueOf(productInfo.getQuantity()));
            productPrice.setText(String.format("单价: %.2f", productInfo.getPrice()));

            // 计算并设置商品总价
            double totalPrice = productInfo.getQuantity() * productInfo.getPrice();
            productTotalPrice.setText(String.format("总价: %.2f", totalPrice));
        }

        // 实现返回按钮的功能
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 关闭当前Activity返回上一页面
            }
        });

        // 实现购买按钮的功能
        Button buyButton = findViewById(R.id.buy_button);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 执行购买逻辑
                // 这里可以添加购买逻辑代码，例如提交订单到服务器等

                // 提示购买成功，返回上一页面
                Intent intent = new Intent();
                intent.putExtra("buyResult", "购买成功");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}