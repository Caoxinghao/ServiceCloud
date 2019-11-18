package com.xinghao.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xinghao.cloud.entities.Dept;
import com.xinghao.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 曹星皓
 * 2019/11/16 14:44
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService service;
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/dept/add",method= RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id)
    {
        Dept dept = service.get(id);
        if (dept == null){
            throw new RuntimeException("该ID"+id+"没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id){
        Dept d = new Dept();
        d.setDeptno(id).setDname("该id没有对应的信息+@HystrixCommand").setDb_source("don't have db_source");
        return d;
    }

    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public List<Dept> list()
    {
        return service.list();
    }


    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }
}

