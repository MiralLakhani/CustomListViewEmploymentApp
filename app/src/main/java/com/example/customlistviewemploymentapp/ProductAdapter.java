package com.example.customlistviewemploymentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ProductAdapter extends BaseAdapter {
    private ArrayList<Product> products;
    private LayoutInflater inflater;//we need this to link with the row_list.xml

    //constructor
    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.products = products;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView==null){
            convertView=inflater.inflate(R.layout.list_row,null);
            holder=new ViewHolder();
            holder.name=convertView.findViewById(R.id.txvProdName);
            holder.price=convertView.findViewById(R.id.txvProdPrice);
            holder.flag=convertView.findViewById(R.id.imgProd);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(products.get(position).getProdName());
        holder.price.setText(String.valueOf(products.get(position).getPrice()));
        holder.flag.setImageResource(products.get(position).getImage());

        return convertView;
    }
    static class ViewHolder{
        //create attributes that match the components of list_row.xml
        private TextView name,price;
        private ImageView flag;

    }
}

