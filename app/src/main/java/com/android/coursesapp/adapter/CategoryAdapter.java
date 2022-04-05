package com.android.coursesapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.coursesapp.MainActivity;
import com.android.coursesapp.R;
import com.android.coursesapp.model.Category;

import java.util.List;

// класс адапатер для работы с классом Category,
// необходим чтобы указывать какой дизайн будет отображать каждый объект и что будет хранится в объекте
// класс наследуем от RecyclerView, так как работаю с этим отображением дизайнав xml
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context; // хранится страница, где будет отображатся список
    List<Category> categories; // список всех возможных категорий

    // конструктор класса
    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categories = categoryList;
    }

    // создание отображение, которое показывается в итоге для категорий
    // используя вложеный класс CategoryViewHolder
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                                                                 //id блока категории    родитель   указатель что не привязыван к родителю
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(categoryItems);
    }

    // в методе указываем что конкретно буду подставлять
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.categoryTitle.setText(categories.get(position).getTitle());

        holder.itemView.setOnClickListener(view -> {
            MainActivity.showCourseByCategory(categories.get(position).getId());
        });
    }

    // гетор класса
    @Override
    public int getItemCount() {
        return categories.size();
    }

    // вложеный класс адаптера для работы с типом данных, описывающий характеристики списка
    // final установлен для запрета НАСЛЕДОВАНИЯ
    public static final class CategoryViewHolder extends RecyclerView.ViewHolder {

        // текстовое поле в категории
        TextView categoryTitle;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            // нахожу текстовое поле по id
            categoryTitle = itemView.findViewById(R.id.categoryTitle);
        }
    }
}
