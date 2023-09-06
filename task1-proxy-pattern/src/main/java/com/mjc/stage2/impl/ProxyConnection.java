package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        if(realConnection != null) {
            realConnection.close();
            realConnection = null;
        }
        // Write your code here!
    }

    @Override
    public void close() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        connectionPool.releaseConnection(this);
    }

    @Override
    public boolean isClosed() {
        return realConnection == null || realConnection.isClosed();
    }
    // Implement methods here!
}
