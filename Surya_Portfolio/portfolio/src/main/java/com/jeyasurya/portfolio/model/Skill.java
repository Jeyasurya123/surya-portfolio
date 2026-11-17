package com.jeyasurya.portfolio.model;

/** A single skill. {@code icon} is either a devicon CSS class (starts with "devicon") or an emoji. */
public class Skill {
    public final String name;
    public final String icon;

    public Skill(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public boolean isDevicon() {
        return icon != null && icon.startsWith("devicon");
    }

    public String getName() { return name; }
    public String getIcon() { return icon; }
}
