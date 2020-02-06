package com.ismutant.apirest.logic;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component("MutantLogic")
public class MutantLogic {

    public static int countDna = 0;

    public static  char matrizCodigoDNA[][] = null; //Matriz tendrá el codigo ADN provisto.

    public void resetCounter(){
        countDna = 0;
    }

    public String[] generateMutantArray(JSONObject body) throws JSONException {
        JSONArray arr = body.getJSONArray("dna");
        return toStringArray(arr);
    }

    public String[] fillIncompleteArray(String[] array){
        int size = array.length;
        for (int i = 0; i < size; i++){
            if(array[i].length() < size) array[i]=StringUtils.rightPad(array[i], size);
            if(array[i].length() > size) array[i]=array[i].substring(0, size);
        }
        return array;
    }

    public boolean horizontalIsMutant(String[] arrayHorizontalDna) {
        int count=0;
        for (int x=0; x < arrayHorizontalDna.length; x++){
            countDna += countMutantDna(arrayHorizontalDna[x], count);
            if (countDna>1)
                return true;
        }
        return false;
    }

    public boolean verticalIsMutant() {
        String result;
        int count=0;
        for (int columna = 0; columna < matrizCodigoDNA.length; columna++){
            result = "";
            for (int fila = 0; fila < matrizCodigoDNA.length; fila++){
                result += matrizCodigoDNA[fila][columna];
            }
            countDna += countMutantDna(result, count);
            if (countDna>1)
                return true;
        }
        return false;
    }


    public boolean diagonalIsMutant() {
        String result;
        int count = 0;

        //Diagonal (0,0) -> (n, n) Superior
        for(int columna = 0; columna < matrizCodigoDNA.length; columna++){
            result = "";
            for (int fila = 0; fila < (matrizCodigoDNA.length - columna); fila++){
                result += matrizCodigoDNA[fila][fila+columna];
            }

            if (result.length()<4 )
                break;

            countDna += countMutantDna(result, count);
        }

        if (countDna>1)
            return true;

        //Diagonal (1,0) -> (n, n-1) Inferior
        for(int fila = 1; fila < matrizCodigoDNA.length; fila++){
            result = "";
            for (int columna = 0; columna < (matrizCodigoDNA.length - fila); columna++){
                result+=matrizCodigoDNA[fila+columna][columna];
            }

            if (result.length()<4 )
                break;

            countDna = countMutantDna(result, count);
        }

        if (countDna>1)
            return true;

        //Diagonal (n, 0) -> (0, n) Superior
        for(int fila = matrizCodigoDNA.length-1; fila > 0 ; fila--){
            result = "";
            for (int columna = 0; columna <= (matrizCodigoDNA.length- (matrizCodigoDNA.length - fila)); columna++){
                result+=matrizCodigoDNA[fila-columna][columna];
            }

            if (result.length()<4 )
                break;

            countDna = countMutantDna(result, count);
        }

        if (countDna>1)
            return true;

        //Diagonal (n, 1) -> (1, n) Inferior
        for(int columna = 1; columna < matrizCodigoDNA.length ; columna++){
            result = "";
            int sum = 0;
            for (int fila = matrizCodigoDNA.length-1; fila >= columna; fila--, sum++){
                result+=matrizCodigoDNA[fila][columna+sum];
            }

            if (result.length()<4 )
                break;

            countDna = countMutantDna(result, count);
        }

        if (countDna>1)
            return true;

        return false;
    }

    public static String[] toStringArray(JSONArray array) {
        if(array==null)
            return null;

        String[] arr=new String[array.length()];
        for(int i=0; i<arr.length; i++) {
            arr[i]=array.optString(i);
        }
        return arr;
    }

    public void splitMatriz(String[] dna) {
        this.matrizCodigoDNA = new char[dna.length][dna.length];
        for (int x=0; x<dna.length; x++){
            for(int y=0; y<dna.length; y++) {
                this.matrizCodigoDNA[x][y]= dna[x].charAt(y);
            }
        }
    }
    private int countMutantDna(String dna, int count){
        count += StringUtils.countMatches(dna, "AAAA");
        count += StringUtils.countMatches(dna, "TTTT");
        count += StringUtils.countMatches(dna, "CCCC");
        count += StringUtils.countMatches(dna, "GGGG");

        return count;
    }
}
