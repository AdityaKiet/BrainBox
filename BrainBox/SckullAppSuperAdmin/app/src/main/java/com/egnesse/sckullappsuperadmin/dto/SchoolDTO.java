package com.egnesse.sckullappsuperadmin.dto;

/**
 * Created by adityaagrawal on 16/02/16.
 */
public class SchoolDTO {
    private String id;
    private String name;
    private Boolean activated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "SchoolDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", activated=" + activated +
                '}';
    }
}
