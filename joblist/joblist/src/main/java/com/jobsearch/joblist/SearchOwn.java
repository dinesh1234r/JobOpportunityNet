package com.jobsearch.joblist;

import com.jobsearch.joblist.Model.Post;
import com.jobsearch.joblist.Repository.OwnRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class SearchOwn implements OwnRepo {
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;
    @Override
    public List<Post> findbyText(String text) {
        final List<Post> posts=new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("database");
        MongoCollection<Document> collection = database.getCollection("jobpost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default")
                                .append("text", new Document("query",text)
                                                .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));
        for (Document document : result) {
            posts.add(mongoConverter.read(Post.class,document));
        }
        return posts;
    }
}
