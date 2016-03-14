package com.gamesys.tanya.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerDB extends DbConnections{
    public void removeAllPlayers() throws SQLException {
        PreparedStatement truncateStatement = null;

        String removeAll = "TRUNCATE TABLE PLAYER";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            truncateStatement = connection.prepareStatement(removeAll);
        }
        catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        }
    }

    public void createTable() {
        Statement createStatement = null;

        String createTable = "CREATE TABLE player(id BIGINT PRIMARY KEY AUTO_INCREMENT, firstName VARCHAR(100), lastName VARCHAR(100));";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            createStatement = connection.createStatement();
            createStatement.execute(createTable);
            System.out.println("Player table has been created");
        }
        catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        }
    }

}
