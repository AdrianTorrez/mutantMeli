package com.ismutant.apirest.service;

import com.ismutant.apirest.dao.StatRepository;
import com.ismutant.apirest.entity.TestDna;
import com.ismutant.apirest.logic.MutantLogic;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class MutantServiceImp implements MutantServices {

    @Autowired
    MutantLogic mutantLogic;

    @Autowired
    private StatRepository statRepository;

    public boolean isMutant(JSONObject body) throws JSONException {
        mutantLogic.resetCounter();
        boolean result = false;
        String[] arrayDna = mutantLogic.generateMutantArray(body);
        arrayDna = mutantLogic.fillIncompleteArray(arrayDna);
        mutantLogic.splitMatriz(arrayDna);
        mutantLogic.horizontalIsMutant(arrayDna);
        if (mutantLogic.getCountDna()<2)
            mutantLogic.verticalIsMutant();
        if (mutantLogic.getCountDna()<2)
            mutantLogic.diagonalIsMutant();
        if (mutantLogic.getCountDna()>1)
            result = true;
        TestDna testDna = new TestDna (0, body.toString(), result);
        statRepository.save(testDna);
        return result;
    }

    @Override
    public String stats() {
        JSONObject response = new JSONObject();
        response.put("count_mutant_dna", statRepository.findMutantCount());
        response.put("count_human_dna", statRepository.findHmanCount());
        if(statRepository.findHmanCount()!=0) {
            float ratio = (float) statRepository.findMutantCount() / (float) statRepository.findHmanCount();
            DecimalFormat formatTwoDecimal = new DecimalFormat("#.##");
            formatTwoDecimal.format(ratio);
            response.put("ratio", ratio);
        }
        else{
            String humanCero = "Santo Cielo! No ha venido ningún humano.";
            response.put("ratio",humanCero);
        }


        return response.toString();
    }

    @Override
    public void byeStat() {
        statRepository.deleteAll();
    }


}
