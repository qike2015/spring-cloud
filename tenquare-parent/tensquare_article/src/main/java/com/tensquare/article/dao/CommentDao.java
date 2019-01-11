package com.tensquare.article.dao;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author 豆丁
 * @since 2019/1/11
 */
public interface CommentDao extends MongoRepository<Comment,String> {

    public List<Comment> findByArticleid(String articleid);
}
