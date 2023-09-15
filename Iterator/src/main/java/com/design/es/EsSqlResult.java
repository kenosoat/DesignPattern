package com.design.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsSqlResult {
    private List<Map<String,String>> columns;
    private List<List<Object>> rows;
    private String cursor;
}
