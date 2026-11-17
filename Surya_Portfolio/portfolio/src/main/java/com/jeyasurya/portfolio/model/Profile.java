package com.jeyasurya.portfolio.model;

public class Profile {
    private final String name;
    private final String title;
    private final String location;
    private final String email;
    private final String phone;
    private final String linkedin;
    private final String about;

    public Profile(String name, String title, String location, String email,
                   String phone, String linkedin, String about) {
        this.name = name;
        this.title = title;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.linkedin = linkedin;
        this.about = about;
    }

    public String getName() { return name; }
    public String getTitle() { return title; }
    public String getLocation() { return location; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getLinkedin() { return linkedin; }
    public String getAbout() { return about; }
}
