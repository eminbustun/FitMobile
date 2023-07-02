package com.example.fitmobile;

import java.io.Serializable;

public class Exercise implements Serializable {



    private String name, explanation, videoUrl, imagePath, group, level;



    public Exercise() {
    }

    public Exercise(String name, String explanation, String videoUrl, String imagePath, String group, String level) {

        this.name = name;
        this.explanation = explanation;
        this.videoUrl = videoUrl;
        this.imagePath = imagePath;
        this.group = group;
        this.level = level;


    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
