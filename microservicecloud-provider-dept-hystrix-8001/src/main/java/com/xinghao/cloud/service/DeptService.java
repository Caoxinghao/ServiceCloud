package com.xinghao.cloud.service;


import com.xinghao.cloud.entities.Dept;

import java.util.List;

/**
 * @author 曹星皓
 * 2019/11/16 14:40
 */
public interface DeptService {
    public boolean add(Dept dept);
    public Dept get(Long id);
    public List<Dept> list();
}
