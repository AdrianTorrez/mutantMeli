package com.ismutant.apirest.dao;

import com.ismutant.apirest.entity.QueryDNA;

import java.util.List;

public interface QueryDAO {

    public List<QueryDNA> findAll();

    public QueryDNA findById(int id);

    public void save(QueryDNA user);

    public void deleteById(int id);
}
