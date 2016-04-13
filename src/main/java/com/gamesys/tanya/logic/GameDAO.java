package com.gamesys.tanya.logic;

import com.gamesys.tanya.api.Game;

import java.sql.*;
import java.util.*;

public class GameDAO extends DbConnections {
    public void createTable() throws SQLException {
        Statement createStatement = null;

        String createTable = "CREATE TABLE GAME(id BIGINT PRIMARY KEY AUTO_INCREMENT, player_id BIGINT NOT NULL, FOREIGN KEY(player_id) REFERENCES PLAYER(id), result BOOLEAN)";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            createStatement = connection.createStatement();
            createStatement.execute(createTable);
            createStatement.close();
            connection.commit();
            System.out.println("Game table has been created\n");
        }
        catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        }
        finally {
            getDBConnection().close();
        }
    }

    public void setTableIdToStartAt100() throws SQLException {
        PreparedStatement statement = null;

        String alterQuery = "ALTER TABLE GAME ALTER COLUMN id RESTART WITH 1000;";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(alterQuery);
            statement.executeUpdate();
            statement.close();

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

        String dropTable = "DROP TABLE GAME;";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            dropStatement = connection.createStatement();
            dropStatement.execute(dropTable);
            dropStatement.close();
            connection.commit();
            System.out.println("Game table has been dropped");
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }
    }

    public static String saveGameResults(Game game) throws SQLException {
        String saveGame = "";
        PreparedStatement insertStatement = null;
        long player = game.getPlayerId();
        boolean result = game.getResult();

//        String insertQuery = "INSERT INTO GAME(player_id, result) VALUES ((SELECT id FROM PLAYER WHERE id = ?), ?)";
        String insertQuery = "INSERT INTO GAME(player_id, result) VALUES ((SELECT id FROM PLAYER WHERE id = 100), ?)";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            insertStatement = connection.prepareStatement(insertQuery);
//            insertStatement.setLong(1, player);
//            insertStatement.setBoolean(2, result);
            insertStatement.setBoolean(1, result);
            insertStatement.executeUpdate();
            insertStatement.close();

            connection.commit();

            saveGame = "Game has been saved";
        }
        catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        }
        finally {
            getDBConnection().close();
        }

        return saveGame;
    }

    public int getTotalNumberOfGamesPlayed() throws SQLException {
        Statement statement = null;
        String query = "SELECT COUNT(*) FROM GAME";
        int counter = 0;

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            for (; resultSet.next(); ) {
                counter = (resultSet.getInt(1));
            }

            System.out.println(counter);
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }
        return counter;
    }

    public static List<Game> getByPlayerId(long player) throws SQLException {
        List<Game> list = new ArrayList<>();
        PreparedStatement statement = null;
        String query = "SELECT * FROM GAME WHERE player_id = ?";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            statement.setLong(1, player);
            ResultSet result = statement.executeQuery();

            for (Game g : getAll()) {
                while (result.next()) {
                    Game game1 = new Game();
                    if(result.getLong(1) == player) {
                        list.add(game1);
                    }
                }
            }

        }
        catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        }
        finally {
            getDBConnection().close();
        }
        return list;
    }

    public static List<Game> getAll() throws SQLException {
        List<Game> list = new ArrayList<>();
        Statement statement = null;
        String query = "SELECT * FROM GAME";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                Game game = new Game();
                list.add(game);
            }

        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }
        return list;
    }

    public static List<Game> getById(int id) throws SQLException {
        List<Game> list = new ArrayList<>();
        PreparedStatement statement = null;
        String query = "SELECT * FROM GAME WHERE id = ?";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            for (Game g : getAll()) {
                while (result.next()) {
                    if(result.getLong(1) == id){
                        Game game = new Game();
                        list.add(game);
                    }
                }

            }

        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }
        return list;
    }

    public static String removeSingleGame(long gameId) throws SQLException {
        String removedGame = "";
        PreparedStatement statement = null;

        String deleteQuery = "DELETE FROM GAME WHERE id = ?";

        try (Connection connection = getDBConnection()) {

            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteQuery);
            statement.setLong(1, gameId);
            statement.executeUpdate();
            statement.close();

            connection.commit();

            removedGame = String.format("Game %d has been removed", gameId);

        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }

        return removedGame;
    }
}
