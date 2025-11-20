package MiniProjects.Project02;

import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class MainApp {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Path folderPath = Paths.get("logs");
        List<Path> files = LogUtils.getLogFiles(folderPath); // ← NOW IT WILL WORK

        ExecutorService executor = Executors.newFixedThreadPool(4); // 4 threads only
        List<Future<Map<String, Integer>>> futures = new ArrayList<>();

        for (Path file : files) {
            futures.add(executor.submit(new LogTask(file)));
        }

        ConcurrentHashMap<String, Integer> finalResult = new ConcurrentHashMap<>();

        for (Future<Map<String, Integer>> f : futures) {
            try {
                Map<String, Integer> partial = f.get();  // get from each thread
                LogUtils.mergeCounts(finalResult, partial);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("\n===== FINAL RESULT =====");
        finalResult.forEach((k, v) -> System.out.println(k + " → " + v));
        System.out.println("Total Execution Time: " + totalTime + " ms");

        try {
            LogUtils.writeResultToFile(finalResult, totalTime);
            System.out.println("\nResult saved to output/result.txt 📁");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
