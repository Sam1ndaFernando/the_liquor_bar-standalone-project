package com.theBar.controller;

import animatefx.animation.Pulse;
import com.google.protobuf.StringValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DashboardFoamCOntroller implements Initializable {

    @FXML
    private AnchorPane mainPaneContext;

    @FXML
    private AnchorPane naviPaneContext;

    @FXML
    private AnchorPane subPaneContext;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDate();
        setTime();
        new Pulse(mainPaneContext).play();


        try {
            homeButton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void homeButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/dashboardPane.fxml"));
        subPaneContext.getChildren().setAll(root);
    }

    private void setTime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        lblTime.setText(formattedTime);
   }

    private void setDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/customerFoam.fxml"));
        subPaneContext.getChildren().setAll(root);
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/employeeFoam.fxml"));
        subPaneContext.getChildren().setAll(root);

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/dashboardPane.fxml"));
        subPaneContext.getChildren().setAll(root);

    }

    @FXML
    void btnOrdesOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/orderFoam.fxml"));
        subPaneContext.getChildren().setAll(root);

    }

    @FXML
    void btnPaymentOnACtion(ActionEvent event) {

    }

    @FXML
    void btnProductOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/productFoam.fxml"));
        subPaneContext.getChildren().setAll(root);
    }

    @FXML
    void btnSuppliesOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/suppliesFoam.fxml"));
        subPaneContext.getChildren().setAll(root);
    }


}
