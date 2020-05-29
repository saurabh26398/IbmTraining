package org.example.Factory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class StudentFactory {
    private DataSource dataSource;

    public StudentFactory(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }
    private  DataSource getMyDataSource()

    {
        return dataSource;
    }
    public Connection getMyConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

