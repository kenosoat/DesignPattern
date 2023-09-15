package com.design.service;

import com.design.es.EsQueryProcessor;
import com.design.es.EsSqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EsService {
    @Autowired
    private EsQueryProcessor esQueryProcessor;
    public Object getSqlResult(EsSqlQuery esSqlQuery) {
        return esQueryProcessor.scrollEsStream(esSqlQuery.getQuery(), esSqlQuery.getFetchSize());
    }
}
