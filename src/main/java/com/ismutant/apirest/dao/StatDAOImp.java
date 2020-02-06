package com.ismutant.apirest.dao;

import com.ismutant.apirest.entity.TestDna;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;




public interface StatDAOImp  {
/*

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TestDna> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<TestDna> theQuery = currentSession.createQuery("from User", TestDna.class);

        List<TestDna> queries = theQuery.getResultList();

        return queries;

    }

    @Override
    public TestDna findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        TestDna testDna = currentSession.get(TestDna.class, id);

        return testDna;
    }

    @Override
    public void save(TestDna testDna) {

        Session currentSession = entityManager.unwrap(Session.class);


        currentSession.saveOrUpdate(testDna);

    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<TestDna> theQuery = currentSession.createQuery("delete from User where id=:idUser");

        theQuery.setParameter("idQueryDNA", id);
        theQuery.executeUpdate();

    }
    */

}
