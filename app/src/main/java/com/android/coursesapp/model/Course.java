package com.android.coursesapp.model;

public class Course {

    private int id, category;
    private String colorBg, img, title, date, level, text;

    public Course(int id, int category, String colorBg, String img, String title, String date, String level, String description ) {
        this.id = id;
        this.category = category;
        this.colorBg = colorBg;
        this.img = img;
        this.title = title;
        this.date = date;
        this.level = level;
        this.text= description;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getColorBg() {
        return colorBg;
    }

    public void setColorBg(String colorBg) {
        this.colorBg = colorBg;
    }
}
