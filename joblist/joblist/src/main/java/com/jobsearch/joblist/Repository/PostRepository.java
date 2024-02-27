package com.jobsearch.joblist.Repository;

import com.jobsearch.joblist.Model.Post;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {

}
