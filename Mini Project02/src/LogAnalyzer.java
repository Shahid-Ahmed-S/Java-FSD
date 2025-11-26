import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class LogAnalyzer {

    private static final ConcurrentHashMap<String, Integer> keywordCount = new ConcurrentHashMap<>();
    private static final List<String> keywords = Arrays.asList("ERROR", "WARNING", "INFO", "DEBUG");

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter folder path containing log files:");
        String folderPath = sc.nextLine();

        File folder = new File(folderPath);
        File[] logFiles = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (logFiles == null || logFiles.length == 0) {
            System.out.println("No log files found!");
            return;
        }

        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(4); // N threads
        List<Future<Map<String, Integer>>> futures = new ArrayList<>();

        for (File file : logFiles) {
            Callable<Map<String, Integer>> task = new LogWorker(file);
            futures.add(executor.submit(task));
        }

        for (Future<Map<String, Integer>> future : futures) {
            Map<String, Integer> result = future.get();
            result.forEach((key, value) ->
                    keywordCount.merge(key, value, Integer::sum)); // thread-safe merging
        }

        executor.shutdown();
        long endTime = System.currentTimeMillis();

        System.out.println("\n===== FINAL KEYWORD COUNT =====");
        keywordCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry ->
                        System.out.println(entry.getKey() + " -> " + entry.getValue()));

        String resultFile = "Result.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
            writer.write("===== FINAL KEYWORD COUNT =====\n");
            for (Map.Entry<String, Integer> entry : keywordCount.entrySet()) {
                writer.write(entry.getKey() + " -> " + entry.getValue() + "\n");
            }
            writer.write("\nTotal Execution Time: " + (endTime - startTime) + " ms\n");
        }

        System.out.println("\nExecution Time: " + (endTime - startTime) + " ms");
        System.out.println("Summary stored in Result.txt");
    }

    static class LogWorker implements Callable<Map<String, Integer>> {
        private final File file;

        LogWorker(File file) {
            this.file = file;
        }

        @Override
        public Map<String, Integer> call() throws Exception {
            Map<String, Integer> localCount = new HashMap<>();
            for (String key : keywords) localCount.put(key, 0);

            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines) {
                for (String key : keywords) {
                    if (line.contains(key)) {
                        localCount.put(key, localCount.get(key) + 1);
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + " analyzed: " + file.getName());
            return localCount;
        }
    }
}
