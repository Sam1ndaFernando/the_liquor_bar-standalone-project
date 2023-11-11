package com.theBar.controller;

import animatefx.animation.Pulse;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.lang.annotation.Inherited;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderFoamController implements Initializable {

    @FXML
    private JFXComboBox<?> cmbCode;

    @FXML
    private JFXComboBox<?> cmbCusId;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private Label lblVolume;

    @FXML
    private AnchorPane rootOrder;

    @FXML
    private TableView<?> tblOrder;

    @FXML
    private Label txtCusName;

    @FXML
    private TextField txtQty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        new Pulse(rootOrder).play();
    }

    @FXML
    void btnAddCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddNewCusOnAction(ActionEvent event) {

    }

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

}
