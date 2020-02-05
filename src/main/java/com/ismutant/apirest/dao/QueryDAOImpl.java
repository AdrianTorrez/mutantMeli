package com.ismutant.apirest.dao;

import com.ismutant.apirest.entity.QueryDNA;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;





@Repository
public class QueryDAOImpl implements QueryDAO {

    @PersistenceUnit
    private EntityManager entityManager;

    @Override
    public List<QueryDNA> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<QueryDNA> theQuery = currentSession.createQuery("from User", QueryDNA.class);

        List<QueryDNA> queries = theQuery.getResultList();

        return queries;

    }

    @Override
    public QueryDNA findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        QueryDNA queryDNA = currentSession.get(QueryDNA.class, id);

        return queryDNA;
    }

    @Override
    public void save(QueryDNA queryDNA) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(queryDNA);

    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<QueryDNA> theQuery = currentSession.createQuery("delete from User where id=:idUser");

        theQuery.setParameter("idQueryDNA", id);
        theQuery.executeUpdate();

    }
}
