package com.solvd.lawfirm.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConnectionPool {

    private volatile static ConnectionPool instance;

    private volatile static List<Connection> connections;
    private volatile static  List<Connection> activeConnections = new ArrayList<>();
    private static Integer numberOfConnections;

    private ConnectionPool(Integer numberOfConnections) {
    }

    public static ConnectionPool getInstance(Integer numberOfConnections) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(numberOfConnections);
                    ConnectionPool.numberOfConnections = numberOfConnections;
                    List<Connection> connections = new ArrayList<>();
                    IntStream.range(0,numberOfConnections)
                            .forEach(index -> connections.add(new Connection()));
                    ConnectionPool.connections = connections;
                }
            }
        }
        return instance;
    }

    public Connection getConnection(){
        synchronized (this) {
            Connection connection = connections
                    .remove(connections.size() - 1);
            activeConnections.add(connection);
            return connection;
        }
    }

    public void releaseConnection(Connection connection){
        synchronized (this) {
            connections.add(connection);
            activeConnections.remove(connection);
        }
    }
}