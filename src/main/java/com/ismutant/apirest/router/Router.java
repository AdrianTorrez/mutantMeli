package com.ismutant.apirest.router;

import com.ismutant.apirest.entity.QueryDNA;
import com.ismutant.apirest.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/") //raiz de la url http://127.0.0.1:8080/

public class Router {

    @Autowired
    private QueryService queryService;


    //http://127.0.0.1:8080/mutant
    @PostMapping("/mutant")
    public ResponseEntity<?> processDna(@RequestBody String body){



        return new ResponseEntity<>("chupavergas",null, HttpStatus.FORBIDDEN);

    }

    //http://127.0.0.1:8080/api/stats/
    @GetMapping("/stats")
    public List<QueryDNA> findAll(){
        return queryService.findAll();

    }
   // http://127.0.0.1:8080/api/stats/
    @PostMapping("/stats")
    public QueryDNA addStats(@RequestBody QueryDNA queryDNA) {
        queryDNA.setQuery_id(0);

        //Este metodo guardará al usuario enviado
        queryService.save(queryDNA);

        return queryDNA;

    }
}
