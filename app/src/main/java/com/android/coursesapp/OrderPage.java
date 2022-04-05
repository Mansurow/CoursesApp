package com.android.coursesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.coursesapp.model.Course;
import com.android.coursesapp.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView ordersList =findViewById(R.id.ordersList);

        List<String> coursesTitle = new ArrayList<>();
        for (Course c : MainActivity.fullCourseList) {
            if (Order.itemsId.contains(c.getId()))
                coursesTitle.add(c.getTitle());
        }

        ordersList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle.toArray()));

    }
}