package com.solvd.lawfirm.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        IntStream.range(0, 20)
                .boxed()
                .forEach(index -> {
                    ThreadCheck threadCheck = new ThreadCheck();
                    threadCheck.start();
                    sleep(500);
                });

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        RunnableCheck runnableCheck = new RunnableCheck();
        List<CompletableFuture<Void>> futureList = IntStream.range(0,10)
                .boxed()
                .map(integer -> CompletableFuture.runAsync(runnableCheck, executorService))
                .collect(Collectors.toList());

        CompletableFuture<Void> futureFutures =
                CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()]));
        futureFutures.get();

        LOGGER.info("All CompletableFutures executed");
        executorService.shutdown();

    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            LOGGER.info(e.getMessage(), e);
        }
    }
}
