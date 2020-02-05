package com.ismutant.apirest.service;

import com.ismutant.apirest.entity.QueryDNA;

import java.util.List;

public interface QueryService {

    public List<QueryDNA> findAll();

    public String prueba();

    public QueryDNA findById(int id);

    public void save(QueryDNA query);

    public void deleteById(int id);
}
