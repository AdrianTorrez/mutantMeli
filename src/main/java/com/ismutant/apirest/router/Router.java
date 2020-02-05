package com.ismutant.apirest.router;

import com.ismutant.apirest.controller.MutantController;
import com.ismutant.apirest.entity.QueryDNA;
import com.ismutant.apirest.service.QueryService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/") //raiz de la url http://127.0.0.1:8080/

public class Router {

    private MutantController mutantController = new MutantController();


    //http://127.0.0.1:8080/mutant
    @PostMapping("/mutant")
    public ResponseEntity<?> processDna(@RequestBody String body) throws JSONException {
        return mutantController.proccessMutant(body);
    }

    //http://127.0.0.1:8080/api/stats/
    /*@GetMapping("/stats")
    public List<QueryDNA> findAll(){
        return queryService.findAll();

    }
    */

}
