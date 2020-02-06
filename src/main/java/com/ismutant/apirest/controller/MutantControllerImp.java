package com.ismutant.apirest.controller;

import com.ismutant.apirest.service.MutantServices;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/") //raiz de la url
public class MutantControllerImp{

    @Autowired
    private MutantServices mutantServices;
    HttpHeaders headers = new HttpHeaders();



    // https://meli-267103.appspot.com//mutant
    // -> El valor esperado es una matriz de NxN conteniendo 4 caracteres 'A','G','C' y 'T' en un objeto JSON ;
    // -> Se retorna HTTP 200-OK si se encuentran consecutivamente de forma diagonal, horizontal o vertical 4 caracteres iguales;
    @PostMapping("/mutant")
    public ResponseEntity<?> processDna(@RequestBody String body) throws JSONException {
        JSONObject jsonBody = new JSONObject(body);
        boolean result = mutantServices.isMutant(jsonBody);
        headers.setContentType(MediaType.TEXT_PLAIN);
        if (result ){
            return new ResponseEntity<>("Sr. Magneto: Buenas noticias! Encontramos un mutante",headers, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Sr. Magneto: Malas noticias! El DNA procesado no es mutante.",headers, HttpStatus.FORBIDDEN);
        }
    }


    // https://meli-267103.appspot.com//status
    // -> Se retorna un JSON con: count_mutant_dna = total ADN humanos evaluados, count_human_dna = total de ADN mutantes evaluados, ratio = ratio entre las dos evaluaciones
    @GetMapping("/stats")
    public ResponseEntity<?> status(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(mutantServices.stats(),headers, HttpStatus.OK);

    }





}
