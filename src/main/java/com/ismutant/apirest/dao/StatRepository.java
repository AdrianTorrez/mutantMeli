package com.ismutant.apirest.dao;

import com.ismutant.apirest.entity.TestDna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatRepository extends JpaRepository<TestDna, Long> {}
