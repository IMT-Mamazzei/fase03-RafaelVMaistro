package br.maua.cic303;

import java.util.HashMap;
import java.util.Map;

public class Environment {

    private Map<String, Double> variables;

    public Environment() {
        variables = new HashMap<>();
    }

    public void setVariable(String name, Double value) {
        variables.put(name, value);
    }

    public Double getVariable(String name) {
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Vari\u00e1vel n\u00e3o declarada: " + name);
        }
        return variables.get(name);
    }
}