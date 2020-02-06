package com.ismutant.apirest.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name="test_dna2")
public class TestDna {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="test_id")
    private int test_id;

    @Column(name="test_dna")
    private String test_dna;

    @Column(name="test_result")
    private boolean test_result;



    public TestDna(){};

    public TestDna(int test_id, String test_dna, boolean test_result) {
        this.test_id = test_id;
        this.test_dna = test_dna;
        this.test_result = test_result;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public String getTest_dna() {
        return test_dna;
    }

    public void setTest_dna(String test_dna) {
        this.test_dna = test_dna;
    }

    public boolean isTest_result() {
        return test_result;
    }

    public void setTest_result(boolean test_result) {
        this.test_result = test_result;
    }



    @Override
    public String toString() {
        return "ID Query [query_id=" + test_id + ", query_dna=" + test_dna + ", query_result=" + test_result + "]";
    }
}
