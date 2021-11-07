package com.solvd.lawfirm.threads;

import java.util.stream.IntStream;

public class RunnableCheck implements Runnable {

    @Override
    public void run() {
        IntStream.range(0, 5)
                .forEach(index -> {
                    Connection connection = new Connection();
                    connection.updateConnection();
                    connection.deleteConnection();
                });
    }
}

