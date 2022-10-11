package com.beckytech.Kitaabaherregakutaa8ffaa.model;

import java.io.Serializable;

public class Model implements Serializable {
    private String title, subtitle;
    private int image, pageStart, pageEnd;

    public Model(String title, String subtitle, int image, int start, int end) {
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
        this.pageStart = start;
        this.pageEnd = end;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }


    public int getImage() {
        return image;
    }

    public int getPageStart() {
        return pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }
}
