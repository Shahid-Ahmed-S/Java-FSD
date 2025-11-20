package MiniProjects.Project02;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.nio.file.*;
import java.util.concurrent.ConcurrentHashMap;

public class LogUtils {

    public static List<Path> getLogFiles(Path folder) {
        List<Path> files = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder)) {
            for (Path file : stream) {
                if (Files.isRegularFile(file)) {
                    files.add(file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return files;
    }

    public static void mergeCounts(ConcurrentHashMap<String, Integer> finalMap,
                                   Map<String, Integer> partialMap) {
        partialMap.forEach((k, v) -> {
            finalMap.merge(k, v, Integer::sum);
        });
    }

    public static void writeResultToFile(ConcurrentHashMap<String, Integer> data, long time)
            throws IOException {

        FileWriter writer = new FileWriter("output/result.txt");

        writer.write("======== LOG ANALYZER RESULT ========\n");
        writer.write("Total Execution Time: " + time + " ms\n");
        writer.write("-------------------------------------\n");
        writer.write("Keyword Counts:\n");

        data.forEach((k, v) -> {
            try {
                writer.write(k + " → " + v + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writer.write("=====================================\n");
        writer.close();
    }
}
