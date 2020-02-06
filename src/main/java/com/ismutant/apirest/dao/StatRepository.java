package com.ismutant.apirest.dao;

import com.ismutant.apirest.entity.TestDna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatRepository extends JpaRepository<TestDna, Long> {
    @Query(value = "select count(t.test_result) from TestDna t where t.test_result=1")
    public Long findMutantCount();
    @Query(value = "select count(t.test_result) from TestDna t where t.test_result=0")
    public Long findHmanCount();
}
