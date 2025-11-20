package MiniProjects.Project02;

import java.util.*;
import java.util.concurrent.*;

public class Aggregator {
    public static Map<String, Integer> combineResults(List<Future<Map<String, Integer>>> futures) {
        Map<String, Integer> finalResult = new HashMap<>();

        for (Future<Map<String, Integer>> future : futures) {
            try {
                Map<String, Integer> result = future.get(); // wait for thread
                for (String key : result.keySet()) {finalResult.put(key, finalResult.getOrDefault(key, 0) + result.get(key));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return finalResult;
    }
}


