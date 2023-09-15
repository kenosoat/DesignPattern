package com.design.es;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EsSqlQuery {
    private String query;
    @JsonProperty("fetch_size")

    private Long fetchSize;
    private String cursor;

    public EsSqlQuery(String query, Long fetchSize) {
        this.query = query;
        this.fetchSize = fetchSize;
    }

    public EsSqlQuery(String cursor) {
        this.cursor = cursor;
    }
}