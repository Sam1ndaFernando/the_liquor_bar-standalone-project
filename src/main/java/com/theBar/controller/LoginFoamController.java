package com.theBar.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFoamController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    void btnLogin(ActionEvent event) throws IOException {




        Parent root = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setFullScreen(true);
        stage.show();


//        String Username = "admin";
//        String Password = "1234";
//
//        if (txtUsername.getText().equals(Username) && txtPassword.getText().equals(Password)) {
//            Parent root = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.setFullScreen(true);
//            stage.show();
//
//        }else {
//            new Alert(Alert.AlertType.ERROR,"Try again").show();
//        }

    }

}
