package com.solvd.lawfirm.threads;

public class ThreadCheck extends Thread {

    private final ConnectionPool connectionPool;
    private final Connection connection;

    public ThreadCheck(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        connection = connectionPool.getConnection();
    }

    @Override
    public void run() {
        connection.createConnection();
        connection.readConnection();
        connection.updateConnection();
        connection.deleteConnection();
        connectionPool.releaseConnection(connection);
    }

    public Connection getConnection() {
        return connection;
    }
}
