package com.andersen_trainee.travel_agency_servlet.dao.cp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public final class ConnectionPool {
	private static HikariConfig config = new HikariConfig();
	private static HikariDataSource ds;

	static {
		config.setJdbcUrl(ConnectionPoolTool.URL);
		config.setUsername(ConnectionPoolTool.USER);
		config.setPassword(ConnectionPoolTool.PASSWORD);
		config.setDriverClassName(ConnectionPoolTool.DRIVER);

		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		ds = new HikariDataSource(config);

	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static void close(Connection connection) {
		if (Objects.isNull(connection)) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private ConnectionPool() {
	}

}
