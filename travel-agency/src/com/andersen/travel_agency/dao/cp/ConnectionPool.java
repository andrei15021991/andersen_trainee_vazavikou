package com.andersen.travel_agency.dao.cp;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static com.andersen.travel_agency.dao.cp.ConnectionPoolTool.*;

public class ConnectionPool {

    private static Properties properties = null;
    private static ComboPooledDataSource dataSource;

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/db.properties"));

            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(properties.getProperty(DRIVER));

            dataSource.setJdbcUrl(properties.getProperty(URL));
            dataSource.setUser(properties.getProperty(USER));
            dataSource.setPassword(properties.getProperty(PASSWORD));

            dataSource.setMinPoolSize(3);
            dataSource.setMaxPoolSize(1000);
            dataSource.setAcquireIncrement(5);

        } catch (IOException | PropertyVetoException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement1, PreparedStatement preparedStatement2) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement1 != null) {
            try {
                preparedStatement1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement2 != null) {
            try {
                preparedStatement2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
