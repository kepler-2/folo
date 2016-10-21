package com.kepler.brandde.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kepler.brandde.FollowBrand;
import com.kepler.brandde.R;
import com.kepler.brandde.dao.Brand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12 on 9/27/2016.
 */
public class AdapterFollowBrand extends BaseAdapter {
    private final LayoutInflater inflater;
    private final FollowBrand activity;
    private ArrayList<Boolean> isSelected = new ArrayList<>();
    private int count = 0;

    public AdapterFollowBrand(FollowBrand activity) {
        inflater = activity.getLayoutInflater();
        this.activity = activity;
        for (int i = 0; i < 10; i++) {
            isSelected.add(false);
        }
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolderItems viewHolderItems;
        if (convertView == null) {
            viewHolderItems = new ViewHolderItems();
            convertView = inflater.inflate(R.layout.follow_brand_item, null);
            viewHolderItems.tv_follow_brand = (TextView) convertView.findViewById(R.id.tv_follow_brand);
            convertView.setTag(viewHolderItems);
        } else
            viewHolderItems = (ViewHolderItems) convertView.getTag();

        if (isSelected.get(position)) {
            viewHolderItems.tv_follow_brand.setBackgroundResource(R.drawable.black_bg_with_corner);
            viewHolderItems.tv_follow_brand.setTextColor(Color.WHITE);
            viewHolderItems.tv_follow_brand.setText(activity.getResources().getString(R.string.following));
        } else {
            viewHolderItems.tv_follow_brand.setBackgroundResource(R.drawable.follow_btn_selector);
            viewHolderItems.tv_follow_brand.setTextColor(Color.BLACK);
            viewHolderItems.tv_follow_brand.setText(activity.getResources().getString(R.string.follow));

        }
        viewHolderItems.tv_follow_brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelected.get(position))
                    count = count - 1;
                else
                    count = count + 1;
                if (count > 4) {
                    activity.b_proceed.setEnabled(true);
                    activity.b_proceed.setText(activity.getResources().getString(R.string.done));
                } else {
                    activity.b_proceed.setEnabled(false);
                    activity.b_proceed.setText(activity.getResources().getString(R.string.have_to_follow));
                }
                isSelected.set(position, !isSelected.get(position));
                notifyDataSetChanged();
            }
        });
        return convertView;
    }


    private class ViewHolderItems {
        TextView tv_follow_brand;
    }
}