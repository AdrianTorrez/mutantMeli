package com.ismutant.apirest.controller;

import com.ismutant.apirest.service.MutantServices;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/") //raiz de la url http://127.0.0.1:8080/
public class MutantControllerImp{

    @Autowired
    private MutantServices mutantServices;

    //http://127.0.0.1:8080/mutant
    @PostMapping("/mutant")
    public ResponseEntity<?> processDna(@RequestBody String body) throws JSONException {
        JSONObject jsonBody = new JSONObject(body);
        boolean result = mutantServices.isMutant(jsonBody);
        String[] arrPrueba = new String[0];

        if (result ){
            return new ResponseEntity<>("Sr. Magneto: Buenas noticias! Encontramos un mutante",null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Sr. Magneto: Malas noticias! El DNA procesado no es mutante.",null, HttpStatus.FORBIDDEN);
        }
    }





}
