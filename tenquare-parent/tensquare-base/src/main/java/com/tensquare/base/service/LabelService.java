package com.tensquare.base.service;

import com.tensquare.base.pojo.Label;
import util.IdWorker;
import com.tensquare.base.dao.LabelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LabelService
{
    @Autowired
    LabelDao labelDao;

    @Autowired
    IdWorker idWorker;

    public List<Label> findAll()
    {
        return labelDao.findAll();
    }

    public Label findById(String id)
    {
        return labelDao.findById(id).get();
    }

    public void add(Label label)
    {
        label.setId(idWorker.nextId() + "");//设置ID
        labelDao.save(label);
    }

    /**
     * 修改标签
     *
     * @param label
     */
    public void update(Label label)
    {
        labelDao.save(label);
    }

    /**
     * 删除标签
     *
     * @param id
     */
    public void deleteById(String id)
    {
        labelDao.deleteById(id);
    }

    public List<Label> findSearch(Map searchMap){

        Specification<Label> sprcification = createSprcification(searchMap);

        return labelDao.findAll(sprcification);
    }

    public Page<Label> findSearch(Map search,int page,int size){
        Specification<Label> sprcification = createSprcification(search);
        PageRequest pageRequest = PageRequest.of(page, size);

        return labelDao.findAll(sprcification,pageRequest);
    }

    //构建查询条件
    private Specification<Label> createSprcification(Map searchMap)
    {
        return new Specification<Label>()
        {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder)
            {
                List<Predicate> predicateList = new ArrayList<>();
                Object labelname = searchMap.get("labelname");
                if (labelname != null && !"".equals(labelname))
                {
                    predicateList.add(criteriaBuilder.like(root.get("labelname").as(String.class), "%" + labelname + "%"));
                }

                if (searchMap.get("state") != null &&
                        !"".equals(searchMap.get("state")))
                {
                    predicateList.add(criteriaBuilder.equal(
                            root.get("state").as(String.class), (String) searchMap.get("state")));
                }

                if (searchMap.get("recommend") != null &&
                        !"".equals(searchMap.get("recommend")))
                {
                    predicateList.add(criteriaBuilder.equal(
                            root.get("recommend").as(String.class),
                            (String) searchMap.get("recommend")));
                }

                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }
}
