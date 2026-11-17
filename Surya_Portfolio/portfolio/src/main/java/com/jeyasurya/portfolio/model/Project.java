package com.jeyasurya.portfolio.model;

import java.util.List;

public class Project {
    private final String title;
    private final String tech;
    private final List<String> points;

    public Project(String title, String tech, List<String> points) {
        this.title = title;
        this.tech = tech;
        this.points = points;
    }

    public String getTitle() { return title; }
    public String getTech() { return tech; }
    public List<String> getPoints() { return points; }
}
