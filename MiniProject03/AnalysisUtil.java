package MiniProject03;

public class AnalysisUtil {

    public static void benchmark(Runnable algorithm){
        long start = System.nanoTime();
        algorithm.run();
        long end = System.nanoTime();
        System.out.println("Execution Time: "+(end-start)/1_000_000.0+" ms");
    }
}

