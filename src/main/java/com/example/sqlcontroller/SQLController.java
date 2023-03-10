package com.example.sqlcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SQLController {
    @FXML
    private Button apply;
    @FXML
    private Button searchGood;
    @FXML
    private Button updateQuantity;
    @FXML
    private Button updatePrice;
    @FXML
    private TextField searchField;
    @FXML
    private TextField updateQuantityField;
    @FXML
    private TextField updatePriceField;
    @FXML
    private Label XV;
    @FXML
    private Label messageLabel;
    @FXML
    private TextField linkField;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextArea resultField;
    @FXML
    private Button clearButton;
    @FXML

    List<Good> results = new ArrayList<>();

    public DBWorker connectToDb(){
        String URL = "jdbc:jtds:sqlserver://localhost;instance=mssqlserver;databaseName=iCS;" +
                "User=" + loginField.getText() +
                ";Password=" + passwordField.getText();
        DBWorker dbWorker = new DBWorker(URL);
        return dbWorker;
    }



    public void testConnection() throws SQLException {

        if(!connectToDb().getConnection().isClosed()) XV.setText("V");
        connectToDb().getConnection().close();

    }

    public void searchGood() throws SQLException {
        messageLabel.setText("");
        if(!Objects.equals(searchField.getText(), "")) {
            String query = String.format("SELECT Artikul, Name, Quantity, CurrentPrice FROM dbo.RGGoodsInventory WHERE Artikul='%s'", searchField.getText());
            Statement statement = connectToDb().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Good good = new Good();
                good.setName(resultSet.getString("Name"));
                good.setArtikul(resultSet.getString("Artikul"));
                good.setQuantity(resultSet.getString("Quantity"));
                good.setCurrentPrice(resultSet.getFloat("CurrentPrice"));
                results.add(good);
                showResults();
            }
        } else {
            messageLabel.setText("Введите Артикул");
        }
       connectToDb().getConnection().close();
    }

    public void updateQuantityGood() throws SQLException {
        String query = String.format("UPDATE dbo.RGGoodsInventory SET Quantity=%s WHERE Artikul='%s'",updateQuantityField.getText(),searchField.getText());
        Statement statement = connectToDb().getConnection().createStatement();
        statement.executeUpdate(query);
        results.clear();
        searchGood();

        connectToDb().getConnection().close();

    }
    public void updatePriceGood() throws SQLException {
        String query = String.format("UPDATE dbo.RGGoodsInventory SET CurrentPrice=%s WHERE Artikul='%s'",updatePriceField.getText(),searchField.getText());
        Statement statement = connectToDb().getConnection().createStatement();
        statement.executeUpdate(query);
        results.clear();
        searchGood();

        connectToDb().getConnection().close();

    }

    public void showResults(){
        for (int i = 0; i < results.size(); i++) {
            resultField.appendText(results.get(i).toString()+"\n");

        }
    }
    public void clearResults(){
        results.clear();
        resultField.clear();
    }
}

