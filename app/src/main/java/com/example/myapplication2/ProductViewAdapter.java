package com.example.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductViewAdapter extends BaseAdapter {
    private List<ProductInfo> productInfoList;
    private Context context;

    public ProductViewAdapter(List<ProductInfo> productInfoList, Context context) {
        this.productInfoList = productInfoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return productInfoList.size();
    }

    @Override
    public Object getItem(int i) {
        return productInfoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.productImage = convertView.findViewById(R.id.product_image);
            holder.productName = convertView.findViewById(R.id.product_name);
            holder.productPrice = convertView.findViewById(R.id.product_price);
            holder.submitButton = convertView.findViewById(R.id.submit_button);
            holder.productDetails = convertView.findViewById(R.id.product_details);
            holder.productQuantity = convertView.findViewById(R.id.product_quantity);
            holder.decreaseButton = convertView.findViewById(R.id.decrease_button);
            holder.increaseButton = convertView.findViewById(R.id.increase_button);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ProductInfo productInfo = productInfoList.get(i);
        holder.productImage.setImageResource(productInfo.getImgID());
        holder.productName.setText(productInfo.getName());
        holder.productPrice.setText(String.valueOf(productInfo.getPrice()));
        holder.productQuantity.setText(String.valueOf(productInfo.getQuantity()));
        holder.productDetails.setText(productInfo.getDetails());
        // 使用 Glide 加载图片
        Glide.with(context)
                .load(productInfo.getImageUrl()) // 假设您已经在 ProductInfo 类中添加了一个获取图片 URL 的方法
                .into(holder.productImage);

        holder.productDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("productInfo", productInfo);
                context.startActivity(intent);
            }
        });

        holder.decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(holder.productQuantity.getText().toString());
                if (quantity > 1) {
                    quantity--;
                    holder.productQuantity.setText(String.valueOf(quantity));
                }
            }
        });

        holder.increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(holder.productQuantity.getText().toString());
                quantity++;
                holder.productQuantity.setText(String.valueOf(quantity));
            }
        });

        holder.productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("productInfo", productInfo);
                context.startActivity(intent);
            }
        });

        holder.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 更新 productInfo 中的数量
                int quantity = Integer.parseInt(holder.productQuantity.getText().toString());
                productInfo.setQuantity(quantity);

                Intent intent = new Intent(context, OrderDetailsActivity.class);
                intent.putExtra("productInfo", productInfo);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        ImageView productImage;
        TextView productName;
        EditText productQuantity;
        Button decreaseButton;
        Button increaseButton;
        TextView productPrice;
        TextView productDetails;
        Button submitButton;
    }

    // 添加这个方法以获取产品列表
    public List<ProductInfo> getProductInfoList() {
        return productInfoList;
    }
}