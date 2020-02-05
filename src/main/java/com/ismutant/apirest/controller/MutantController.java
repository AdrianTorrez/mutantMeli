package com.ismutant.apirest.controller;

import com.ismutant.apirest.service.MutantService;
import com.ismutant.apirest.service.QueryServiceImpl;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.json.JSONObject;

public class MutantController {

    public MutantController() {

    }

    private MutantService mutantService = new MutantService();

    public ResponseEntity<?> proccessMutant(String body) throws JSONException {
        JSONObject jsonBody = new JSONObject(body);
        boolean result = mutantService.isMutant(jsonBody);
        if (result ){
            return new ResponseEntity<>("Sr. Magneto: Buenas noticias! Encontramos un mutante",null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Sr. Magneto: Malas noticias! El DNA procesado no es mutante.",null, HttpStatus.FORBIDDEN);
        }
    }
}
