package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author 豆丁
 * @since 2019/1/11
 */
public interface SpitDao extends MongoRepository<Spit,String> {


    Page<Spit> findByParentid(String parentid, Pageable pageable);
}

