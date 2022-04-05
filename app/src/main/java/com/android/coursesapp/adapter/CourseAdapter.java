package com.android.coursesapp.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.coursesapp.CoursePage;
import com.android.coursesapp.R;
import com.android.coursesapp.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseAdapter.CourseViewHolder(courseItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.courseBg.setCardBackgroundColor(Color.parseColor(courses.get(position).getColorBg()));

        int imageId = context.getResources().getIdentifier("ic_" + courses.get(position).getImg(), "drawable", context.getPackageName());
        // обработчики  событий
        // установление изображения
        holder.courseImage.setImageResource(imageId);

        // Название курса, дата и уровень
        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.courseDate.setText(courses.get(position).getDate());
        holder.courseLevel.setText(courses.get(position).getLevel());

        // обработчик нажатие на заданный курс
        holder.itemView.setOnClickListener(view -> {
            Intent coursePageIntent = new Intent(context, CoursePage.class);
            // создание анамации для изображения
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<View, String>(holder.courseImage, "courseImageAnimate")
            );

            // передача данных для вывода окна с информацией курса
            coursePageIntent.putExtra("courseBg", Color.parseColor(courses.get(position).getColorBg()));
            coursePageIntent.putExtra("courseImage", imageId);
            coursePageIntent.putExtra("courseTitle", courses.get(position).getTitle());
            coursePageIntent.putExtra("courseDate", courses.get(position).getDate());
            coursePageIntent.putExtra("courseLevel", courses.get(position).getLevel());
            coursePageIntent.putExtra("courseText", courses.get(position).getText());
            coursePageIntent.putExtra("courseId", courses.get(position).getId());

            // выполняем переход на страницу
            context.startActivity(coursePageIntent, options.toBundle());
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder {

        CardView courseBg;
        ImageView courseImage;
        TextView courseTitle, courseDate, courseLevel;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBg = itemView.findViewById(R.id.courseBg);
            courseImage = itemView.findViewById(R.id.courseImage);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            courseDate = itemView.findViewById(R.id.courseData);
            courseLevel = itemView.findViewById(R.id.courseLevel);


        }
    }
}
