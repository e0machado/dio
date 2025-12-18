package org.dio;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, String> allEnvVars = new HashMap<>(System.getenv());

        //System.out.println(allEnvVars);

        for(Map.Entry<String, String> envVar: allEnvVars.entrySet()) {
            System.out.println(envVar.getKey() + " - " + envVar.getValue());
        }
    }

}
