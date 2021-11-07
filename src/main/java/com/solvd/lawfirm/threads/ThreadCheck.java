package com.solvd.lawfirm.threads;

public class ThreadCheck extends Thread {

    @Override
    public void run() {
        ConnectionPool connectionPool = ConnectionPool.getInstance(5);
        Connection connection = connectionPool.getConnection();
        connection.createConnection();
        connection.readConnection();
        connectionPool.releaseConnection(connection);
    }
}
