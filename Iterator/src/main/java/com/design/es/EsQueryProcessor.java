package com.design.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class EsQueryProcessor {

    private RestTemplate restTemplate = new RestTemplate();

    public Stream<Map<String,Object>> scrollEsStream(String query,Long fetchSize){
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new ScrollIterator(query,fetchSize),0),false);
    }

    private class ScrollIterator implements Iterator<Map<String,Object>> {

        private List<String> columns;
        private String scrollId;
        Iterator<Map<String,Object>> iterator;

        public ScrollIterator(String query, Long fetchSize) {
            EsSqlResult esSqlResult = restTemplate.postForObject("http://192.168.31.163:9200/_sql?format=json", new EsSqlQuery(query, fetchSize), EsSqlResult.class);
            this.columns = esSqlResult.getColumns().stream().map(val -> val.get("name")).collect(Collectors.toList());
            this.scrollId = esSqlResult.getCursor();
            this.iterator = convert(this.columns,esSqlResult).iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext() || hasMap();
        }

        private boolean hasMap() {
            if(iterator == null || scrollId == null){
                return false;
            }

            EsSqlResult esSqlResult = restTemplate.postForObject("http://192.168.31.163:9200/_sql?format=json", new EsSqlQuery(this.scrollId), EsSqlResult.class);
            this.scrollId = esSqlResult.getCursor();
            this.iterator = convert(this.columns,esSqlResult).iterator();
            return true;
        }

        @Override
        public Map<String,Object> next() {
            return iterator.next();
        }
    }

    public List<Map<String,Object>> convert(List<String> columns,EsSqlResult esSqlResult){
        List<Map<String,Object>> results = new ArrayList<>();
        for(List<Object> row:esSqlResult.getRows()){
            Map<String,Object> map = new HashMap<>();
            for(int i = 0; i < row.size(); i++){
                map.put(columns.get(i),row.get(i));
            }
            results.add(map);
        }
        return results;
    }


}
