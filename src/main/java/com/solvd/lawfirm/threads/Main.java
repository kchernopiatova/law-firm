package com.solvd.lawfirm.threads;

import com.solvd.lawfirm.people.Lawyer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        IntStream.range(0,20)
                .boxed()
                .forEach(index -> {
                    Thread thread = new Thread(() -> {
                        ConnectionPool connectionPool = ConnectionPool.getInstance(5);
                        Connection connection = connectionPool.getConnection();
                        connection.createConnection();
                        connection.readConnection();
                        connectionPool.releaseConnection(connection);
                    });
                    thread.start();
                    sleep(500);
                });

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() ->
                {
                    IntStream.range(0, 5)
                            .forEach(index -> {
                                Connection connection = new Connection();
                                connection.createConnection();
                                connection.updateConnection();
                            });
                },executorService);
        executorService.shutdown();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
