package com.solvd.lawfirm.threads;

public class RuntimeCheck implements Runnable{

    private final String name;
    private final ConnectionPool connectionPool;

    public RuntimeCheck(String name, ConnectionPool connectionPool) {
        this.name = name;
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        Connection connection = connectionPool.getConnection();
        connection.createConnection();
        connection.readConnection();
        connection.updateConnection();
        connection.deleteConnection();
    }

    public String getName() {
        return name;
    }
}
