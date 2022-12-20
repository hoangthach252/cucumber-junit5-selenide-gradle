package com.unsplash.cucumber.utils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private Map<String, Object> scenarioContext;

    public ScenarioContext() {
        this.scenarioContext = new HashMap<>();
    }

    public void setContext(DataItem key, Object value) {
        this.scenarioContext.put(key.toString(), value);
    }

    public Object getContext(DataItem key) {
        return this.scenarioContext.get(key.toString());
    }

    public Boolean isContains(DataItem key) {
        return this.scenarioContext.containsKey(key.toString());
    }
}
