package com.tensquare.article.service;

import com.tensquare.article.dao.CommentDao;
import com.tensquare.article.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @author 豆丁
 * @since 2019/1/11
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    IdWorker idWorker;

    public void add(Comment comment) {
        comment.set_id(idWorker.nextId() + "");
        commentDao.save(comment);
    }
    public List<Comment> findByArticleid(String articleid){
        return commentDao.findByArticleid(articleid);
    }

}
