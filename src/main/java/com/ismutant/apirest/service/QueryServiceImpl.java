package com.ismutant.apirest.service;

import com.ismutant.apirest.dao.QueryDAO;
import com.ismutant.apirest.entity.QueryDNA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryDAO queryDAO;

    @Override
    public List<QueryDNA> findAll() {
        List<QueryDNA> listQueries= queryDAO.findAll();
        return listQueries;
    }

    @Override
    public QueryDNA findById(int id) {
        QueryDNA query = queryDAO.findById(id);
        return query;
    }

    @Override
    public void save(QueryDNA query) {
        queryDAO.save(query);

    }

    @Override
    public void deleteById(int id) {
        queryDAO.deleteById(id);
    }

    @Override
    public String prueba() {
        return "Hola Enanillo";
    }
}
