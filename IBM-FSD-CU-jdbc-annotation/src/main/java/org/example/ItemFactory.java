package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class ItemFactory {
    private DataSource dataSource;
    private Connection connection;

    public ItemFactory(DataSource dataSource) {
       this.dataSource=dataSource;

    }
    private  DataSource getMyDataSource()

    {
        return dataSource;
    }
    public Connection getMyConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
