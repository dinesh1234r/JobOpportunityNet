package com.jobsearch.joblist.Repository;

import com.jobsearch.joblist.Model.Post;

import java.util.List;

public interface OwnRepo {
    List<Post> findbyText(String text);
}
