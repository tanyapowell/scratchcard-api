package com.gamesys.tanya.logic;

import com.gamesys.tanya.api.Purchase;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PurchaseDAO extends DbConnections {
    public void removeAll() throws SQLException {
        PreparedStatement truncateStatement = null;

        String removeAll = "TRUNCATE TABLE PURCHASE";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            truncateStatement = connection.prepareStatement(removeAll);
            truncateStatement.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }
    }

    public void createTable() throws SQLException {
        Statement createStatement = null;

//        TODO update once foreign keys can be added
//        String createTable = "CREATE TABLE purchase(id BIGINT PRIMARY KEY AUTO_INCREMENT, FOREIGN KEY(id) REFERENCES player(id), numberOfPurchases INT);";
        String createTable = "CREATE TABLE PURCHASE(id BIGINT PRIMARY KEY AUTO_INCREMENT, playerID BIGINT, numberOfPurchases INT);";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            createStatement = connection.createStatement();
            createStatement.execute(createTable);
            createStatement.close();
            connection.commit();
            System.out.println("Purchase table has been created\n");
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }
    }

    public void dropTable() throws SQLException {
        Statement dropStatement = null;

        String dropTable = "DROP TABLE PURCHASE;";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            dropStatement = connection.createStatement();
            dropStatement.execute(dropTable);
            dropStatement.close();
            connection.commit();
            System.out.println("Purchase table has been dropped");
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }
    }

    public static String save(Purchase purchase) throws SQLException {
        String purchaseString = "";
        PreparedStatement insertStatement = null;
//        long id = purchase.getPurchaseId();
        long player = purchase.getPlayerId();
        int noOfTickets = purchase.getNumberOfTicketsPurchased();

        String insertQuery = "INSERT INTO PURCHASE(playerID, numberOfPurchases) VALUES(?, ?)";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            insertStatement = connection.prepareStatement(insertQuery);
//            insertStatement.setLong(1, id);
            insertStatement.setLong(1, player);
            insertStatement.setInt(2, noOfTickets);
            insertStatement.executeUpdate();
            insertStatement.close();

            connection.commit();

            purchaseString = "Purchase has been saved";
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }

        return purchaseString;
    }

    public boolean isEmpty() throws SQLException {
        boolean isEmpty;
        int tableCounter = getTotalCount();

        if (tableCounter > 0) {
            isEmpty = false;
        } else {
            isEmpty = true;
        }

        return isEmpty;
    }

    public static List<Purchase> getByPlayer(long player) throws SQLException {
        List<Purchase> list = new ArrayList<>();
        PreparedStatement statement = null;

        String query = "SELECT * FROM PURCHASE WHERE playerID = ?";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            statement.setLong(1, player);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Purchase purchase = new Purchase(result.getLong(2), result.getInt(3));
                if (result.getLong(2) == player) {
                    list.add(purchase);
                }
            }


        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }

        return list;
    }

    public static List<Purchase> getAll() throws SQLException {
        List<Purchase> list = new ArrayList<>();
        Statement statement = null;
        String query = "SELECT * FROM PURCHASE";

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                Purchase purchase = new Purchase(result.getLong(2), result.getInt(3));
                list.add(purchase);
            }

        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }
        return list;
    }

    public static int getTotalCount() throws SQLException {
        Statement statement = null;
        String query = "SELECT COUNT(*) FROM PURCHASE";
        int counter = 0;

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet set = statement.executeQuery(query);

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

    public static List<Purchase> getById(long purchaseId) throws SQLException {
        List<Purchase> list = new ArrayList<>();
        PreparedStatement statement = null;

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("SELECT * FROM PURCHASE WHERE id = ?");

            statement.setLong(1, purchaseId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Purchase purchase = new Purchase(result.getLong(2), result.getInt(3));
                if (result.getLong(1) == purchaseId) {
                    list.add(purchase);
                }
            }

        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }

        return list;
    }

    public static String removeSinglePurchase(long purchaseId) throws SQLException {
        String removedPurchase = "";
        PreparedStatement statement = null;

        String deleteQuery = "DELETE FROM PURCHASE WHERE id = ?";

        try (Connection connection = getDBConnection()) {

            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteQuery);
            statement.setLong(1, purchaseId);
            statement.executeUpdate();
            statement.close();

            connection.commit();

            removedPurchase = String.format("Purchase %d has been removed", purchaseId);

        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            getDBConnection().close();
        }

        return removedPurchase;
    }
}