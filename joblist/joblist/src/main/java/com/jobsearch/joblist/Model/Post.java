package com.jobsearch.joblist.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
@Document(collection = "jobpost")
public class Post {
    private Integer id;
    private String desc;
    private Integer exp;
    private String profile;
    private String[] techs;

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", profile='" + profile + '\'' +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
