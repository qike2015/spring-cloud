package com.tensquare.base.service;

import com.qike.tensquare.util.IdWorker;
import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
