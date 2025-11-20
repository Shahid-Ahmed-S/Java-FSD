package MiniProjects.Project02;


import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.Callable;

    public class LogTask implements Callable<Map<String, Integer>> {

        private final Path filePath;

        public LogTask(Path filePath) {
            this.filePath = filePath;
        }

        @Override
        public Map<String, Integer> call() throws Exception {
            Map<String, Integer> keywordCount = new HashMap<>();
            List<String> keywords = List.of("error", "fail", "warning", "timeout");

            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                for (String key : keywords) {
                    if (line.toLowerCase().contains(key)) {
                        keywordCount.put(key, keywordCount.getOrDefault(key, 0) + 1);
                    }
                }
            }
            System.out.println("Processed by: " + Thread.currentThread().getName());
            return keywordCount;
        }
    }


