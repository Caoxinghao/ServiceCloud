package com.xinghao.cloud.service.impl;

import com.xinghao.cloud.dao.DeptDao;
import com.xinghao.cloud.entities.Dept;
import com.xinghao.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 曹星皓
 * 2019/11/16 14:40
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao dao ;

    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    public Dept get(Long id) {
        return dao.findById(id);
    }

    public List<Dept> list() {
        return dao.findAll();
    }
}
