package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author 豆丁
 * @since 2019/1/14
 */
public interface ArticleSearchDao  extends ElasticsearchRepository<Article, String> {

    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
