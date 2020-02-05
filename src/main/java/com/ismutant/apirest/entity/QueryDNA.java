package com.ismutant.apirest.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name="queries_dna")
public class QueryDNA {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="query_id")
    private int query_id;

    @Column(name="query_dna")
    private String query_dna;

    @Column(name="query_result")
    private String query_result;

    @Column(name="query_date")
    @CreationTimestamp
    private Date query_date;

    public QueryDNA(){};

    public QueryDNA(int query_id, String query_dna, String query_result) {
        this.query_id = query_id;
        this.query_dna = query_dna;
        this.query_result = query_result;
    }

    public int getQuery_id() {
        return query_id;
    }

    public void setQuery_id(int query_id) {
        this.query_id = query_id;
    }

    public String getQuery_dna() {
        return query_dna;
    }

    public void setQuery_dna(String query_dna) {
        this.query_dna = query_dna;
    }

    public String getQuery_result() {
        return query_result;
    }

    public void setQuery_result(String query_result) {
        this.query_result = query_result;
    }

    public Date getQuery_date() {
        return query_date;
    }

    @Override
    public String toString() {
        return "ID Query [query_id=" + query_id + ", query_dna=" + query_dna + ", query_result=" + query_result + ", query_date=" + query_date + "]";
    }
}
