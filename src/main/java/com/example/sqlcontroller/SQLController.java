package com.example.sqlcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    private TextField linkField;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField resultField;





    public void testConnection(ActionEvent event) throws SQLException {
        String URL = "jdbc:sqlserver://" + linkField.getText()
                + ";database=iCS"
                + ";user=" + loginField.getText()
                + ";password=" + passwordField.getText();
        DBWorker dbWorker = new DBWorker(URL);
        if (!dbWorker.getConnection().isClosed()) XV.setText("V");
        dbWorker.getConnection().close();
    }

    public void getQuery(ActionEvent event) throws SQLException {
        DBWorker dbWorker = new DBWorker("");
        Statement statement = dbWorker.getConnection().createStatement();

    }
    public void searchGood(ActionEvent event) throws SQLException {
        String query = "SELECT Artikul, Name, Quantity, BeginPrice, CurrentPrice FROM dbo.RGGoodsInventory WHERE Artikul=";
        DBWorker dbWorker = new DBWorker("");
        Statement statement = dbWorker.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query + searchField.getText());
    }
}

