package com.ismutant.apirest.service;

import com.ismutant.apirest.dao.StatDAOImp;
import com.ismutant.apirest.dao.StatRepository;
import com.ismutant.apirest.entity.TestDna;
import com.ismutant.apirest.logic.MutantLogic;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImp implements MutantServices {

    @Autowired
    MutantLogic mutantLogic;

    @Autowired
    private StatRepository statRepository;

    public boolean isMutant(JSONObject body) throws JSONException {
        mutantLogic.resetCounter();
        String[] arrayDna = mutantLogic.generateMutantArray(body);
        arrayDna = mutantLogic.fillIncompleteArray(arrayDna);
        mutantLogic.splitMatriz(arrayDna);
        TestDna testDna = new TestDna (0, "hola", true);
        statRepository.save(testDna);
        return ( mutantLogic.horizontalIsMutant(arrayDna)
                || mutantLogic.verticalIsMutant()
                || mutantLogic.diagonalIsMutant() );
    }




}
