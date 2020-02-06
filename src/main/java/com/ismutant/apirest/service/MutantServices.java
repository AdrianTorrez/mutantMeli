package com.ismutant.apirest.service;

import org.json.JSONException;
import org.json.JSONObject;

public interface MutantServices {

    public boolean isMutant(JSONObject body) throws JSONException;
}
