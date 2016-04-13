package com.gamesys.tanya.logic;

import com.gamesys.tanya.api.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO extends DbConnections{
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

        String createTable = "CREATE TABLE PLAYER(id BIGINT PRIMARY KEY AUTO_INCREMENT, firstName VARCHAR(100), lastName VARCHAR(100), numberOfTicketsAvailableToPlay INT, numberOfGamesPlayed INT, numberOfWins INT, numberOfLosses INT)";

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

    public void setTableIdToStartAt100() throws SQLException {
        PreparedStatement alterStatement = null;

        String alterQuery = "ALTER TABLE PLAYER ALTER COLUMN id RESTART WITH 100;";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            alterStatement = connection.prepareStatement(alterQuery);
            alterStatement.executeUpdate();
            alterStatement.close();

            connection.commit();
        }
        catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        }
        finally {
            getDBConnection().close();
        }
    }

    public void dropTable() throws SQLException {
        Statement dropStatement = null;

        String dropTable = "DROP TABLE PLAYER;";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            dropStatement = connection.createStatement();
            dropStatement.execute(dropTable);
            dropStatement.close();
            connection.commit();
            System.out.println("Player table has been dropped");
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }
    }

    public static String saveNewPlayer(Player player) throws SQLException {
        String saveNewPlayer = "";

        PreparedStatement insertStatement = null;
        String firstName = player.getFirstName();
        String lastName = player.getLastName();
        int numberOfTicketsAvailable = 0;
        int numberOfGamesPlayed = 0;
        int numberOfWins = 0;
        int numberOfLosses = 0;

        String insertQuery = "INSERT INTO PLAYER (firstName, lastName, numberOfTicketsAvailableToPlay, numberOfGamesPlayed, numberOfWins, numberOfLosses) VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, firstName);
            insertStatement.setString(2, lastName);
            insertStatement.setInt(3, numberOfTicketsAvailable);
            insertStatement.setInt(4, numberOfGamesPlayed);
            insertStatement.setInt(5, numberOfWins);
            insertStatement.setInt(6, numberOfLosses);

            insertStatement.executeUpdate();
            insertStatement.close();

            connection.commit();

            saveNewPlayer = "Player has been saved";
        }
        catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        }
        finally {
            getDBConnection().close();
        }

        return saveNewPlayer;
    }

    public Boolean isEmpty() throws SQLException {
        boolean isEmpty;
        int tableCounter = getTotalCount();

        if (tableCounter > 0) {
            isEmpty = false;
        } else {
            isEmpty = true;
        }

        return isEmpty;
    }

    private int getTotalCount() throws SQLException {
        Statement statement = null;
        int counter = 0;

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT COUNT(*) FROM PLAYER");

            for (; set.next(); ) {
                counter = Integer.parseInt(set.getString(1));
            }

        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }

        return counter;
    }

    public List<Player> getAll() throws SQLException {
        List<Player> players = new ArrayList<>();
        Statement statement = null;
        String query = "SELECT * FROM PLAYER";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                Player player = new Player(result.getString(2), result.getString(3), result.getInt(4), result.getInt(5), result.getInt(6), result.getInt(7));

                players.add(player);
            }

        }
        catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        }
        finally {
            getDBConnection().close();
        }

        return players;
    }

    public List<Player> getByPlayerId(long id) throws SQLException {
        List<Player> playerList = new ArrayList<>();
        PreparedStatement statement = null;

        String query = "SELECT * FROM PLAYER WHERE ID = ?";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                if(result.getLong(1) == id){
                    Player player = new Player(result.getString(2), result.getString(3), result.getInt(4), result.getInt(5), result.getInt(6), result.getInt(7));
                    playerList.add(player);
                }
            }

        }
        catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        }
        finally {
            getDBConnection().close();
        }

        return playerList;
    }
}
