package com.design.controller;

import com.design.es.EsSqlQuery;
import com.design.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsController {

    @Autowired
    private EsService esService;

    @RequestMapping("/getSql")
    public Object getSqlResult(@RequestBody EsSqlQuery esSqlQuery){
        return esService.getSqlResult(esSqlQuery);
    }
}
