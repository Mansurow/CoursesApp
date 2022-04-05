package com.android.coursesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.coursesapp.adapter.CategoryAdapter;
import com.android.coursesapp.adapter.CourseAdapter;
import com.android.coursesapp.model.Category;
import com.android.coursesapp.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // создаю блок где буду хранить категории
    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;

    @SuppressLint("StaticFieldLeak")
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCourseList = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // заполняю сови категории КУРСОВ
        List<Category> categoryList = new ArrayList<>();
        ImageView imgMainMenu = findViewById(R.id.mainMenu);


        categoryList.add(new Category(1, "Языки"));
        categoryList.add(new Category(2, "Cайты"));
        categoryList.add(new Category(3, "Игры"));
        categoryList.add(new Category(4, "Дизайн"));
        categoryList.add(new Category(5, "Прочее"));

        setCategoryRecycler(categoryList);

        courseList.clear();
        courseList.add(new Course(1, 1,
                "#424345",
                "java",
                "Профессия Java\nразработчик",
                "20 февраля", "начальный",
                "Программа обучения Java – рассчитана на новичков в данной сфере.\n\nЗа программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Java!"));
        courseList.add(new Course(2, 1,
                "#9FA52D",
                "python",
                "Профессия Python\nразработчик",
                "10 марта", "начальный",
                "Программа рассчитана на новичков, которые хотят изучить язык Python.\n\nЗа программу вы изучите разработку консольных, а также графических программ на Python, научитесь создавать простые программы с искусственным интеллектом, изучите работу с базами данных, а также будете работать на Django."));
        courseList.add(new Course(3, 1,
                "#F16A51",
                "nodejs",
                "Профессия Node JS\nразработчик",
                "25 апреля", "начальный",
                "Программа рассчитана на новичков, которые хотят изучить веб программирование и за короткий промежуток времени стать Full Stack разработчиками на Node JS. В ходе программы вы изучите множество технологий. Вы изучите теорию и на практике научитесь строить полноценные веб сайты, применяя все современные технологии и навыки."));
        courseList.add(new Course(4, 1,
                "#ffaa55",
                "js",
                "Профессия JS\nразработчик",
                "25 апреля", "начальный",
                "Современный мир веба очень сложно представить без JS. JavaScript – это душа веб-сайта, так как все интерактивные действия выполняет JS. JavaScript является встроенным компонентом в веб-программировании, поэтому его не нужно устанавливать или настраивать."));

        courseList.add(new Course(5, 2,
                "#211F1D",
                "fullstack",
                "Профессия Fullstack\nразработчик",
                "22 мая", "начальный",
                "Программа рассчитана на новичков, которые хотят изучить веб программирование и за короткий промежуток времени начать создавать веб сайты. За время программы вы научитесь верстать веб сайты, создавать серверные решения и программировать веб сайты различных жанров и сложностей. Вы изучите множество новых понятий, языков программирования и технологий."));
        courseList.add(new Course(6, 2,
                "#B14935",
                "frontend",
                "Профессия Frontend\nразработчик",
                "5 апреля", "начальный",
                "Программа рассчитана на новичков, которые хотят изучить веб программирование и за короткий промежуток времени начать создавать веб сайты. За время программы вы узнаете множество новых понятий, изучите теорию, а также на практике научитесь строить полноценные веб сайты, применяя все современные технологии и навыки."));
        courseList.add(new Course(7, 2,
                "#2C55A6",
                "backend",
                "Профессия Backend\nразработчик",
                "10 апреля", "начальный",
                "Программа Back-end разработчик рассчитана на новичков, которые хотят изучить язык PHP, а также построение веб сайтов на стороне сервера. За время программы вы изучите язык PHP, научитесь работать с его библиотеками, создадите несколько веб сайтов, рассмотрите MVC, ООП, Cron, Curl, принципы и паттерны программирования и множество других терминов и понятий."));
//        courseList.add(new Course(7, 1,"#9FA52D","js", "Профессия Python\nразработчик", "10 января", "начальный", "Test"));
//        courseList.add(new Course(8, 2,"#211F1D","cpp", "Профессия fullstack\nразработчик", "6 января", "продвинутый", "Test"));
//        courseList.add(new Course(9, 3,"#9FA52D", "csharp", "Профессия Python\nразработчик", "10 января", "начальный", "Test"));
//        courseList.add(new Course(10, 1,"#9FA52D", "php", "Профессия Python\nразработчик", "10 января", "начальный", "Test"));

        fullCourseList.addAll(courseList);
        setCourseRecycler(courseList);


        imgMainMenu.setOnClickListener(v -> {
            courseList.clear();
            courseList.addAll(fullCourseList);
            courseAdapter.notifyDataSetChanged();
        });
    }

    public void openShoppingCard(View view) {
        Intent orderPageIntent = new Intent (this, OrderPage.class);
        startActivity(orderPageIntent);
    }

    private void setCourseRecycler(List<Course> courseList) {
        // настройка горизонтального вывода
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        // нахожу по ссылке и устанавливаю layoutManager
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        // создаю адаптер и его устанавливаю
        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    // метод вывод информации
    private void setCategoryRecycler(List<Category> categoryList) {

        // настройка горизонтального вывода
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        // нахожу по ссылке и устанавливаю layoutManager
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        // создаю адаптер и его устанавливаю
        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    public static void showCourseByCategory(int category) {
          courseList.clear();

        for (Course c : fullCourseList) {
            if (c.getCategory() == category)
                courseList.add(c);
        }

        courseAdapter.notifyDataSetChanged();
    }

}