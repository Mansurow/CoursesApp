package com.android.coursesapp.model;

// Класс созданый для категорий, чтобы упростить и визуализация всех категорий
// в меню была идентична (public так нам не надо ничего скрывать класс и его функции)
public class Category {

    // private чтобы не работали только с конструкторами и гетерами и сетерами
    private int id; //индентификатор категории
    private String title; // название категории

    // конструктор создания
    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // гетеры и сетеры класса
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
