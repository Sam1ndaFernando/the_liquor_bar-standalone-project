package com.theBar.controller;

import animatefx.animation.Pulse;
import com.theBar.dto.CustomerDto;
import com.theBar.dto.tm.CustomerTm;
import com.theBar.model.CustomerModel;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerFoamController implements Initializable {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContactNo;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colUser;

    @FXML
    private MFXComboBox<?> comUserID;

    @FXML
    private AnchorPane rootCustomer;

    @FXML
    private TableView<CustomerTm> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtCusID;

    @FXML
    private TextField txtName;

    CustomerModel customerModel = new CustomerModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        loadAllCustomer();
        new Pulse(rootCustomer).play();

    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        //colUser.setCellValueFactory(new PropertyValueFactory<>("userId"));
    }

    private void loadAllCustomer() {
        var model = new CustomerModel();

        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

        try {
            List<CustomerDto> dtoList = model.getAllCustomers();

            for (CustomerDto dto : dtoList) {
                obList.add(
                        new CustomerTm(
                                dto.getCusId(),
                                dto.getCusName(),
                                dto.getCusAddress(),
                                dto.getCusContactNumber()
                        )
                );
            }

            tblCustomer.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtCusID.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtContact.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException {

        String id = txtCusID.getText();
        try{
        boolean isDeleted = customerModel.deleteCustomer(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer deleted successfully").show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, "An error occurred: " + e.getMessage()).show();
        }


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

            String id = txtCusID.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String contact = txtContact.getText();

        try {
            var dto = new CustomerDto(id, name, address, contact);

            boolean isSaved = CustomerModel.saveCustomer(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer saved successfully").show();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to save customer").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "An error occurred: " + e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtCusID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();

        try{
            var dto = new CustomerDto(id, name, address, contact);
            boolean isUpdated = CustomerModel.updateCustomer(dto);

            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer updated successfully").show();
                clearFields();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, "An error occurred: " + e.getMessage()).show();
        }
    }

    @FXML
    void comUserIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtCusIDOnAction(ActionEvent event) {

        String id = txtCusID.getText();

        try {
            CustomerDto customerDto = CustomerModel.searchCustomer(id);
            if (customerDto != null) {
                txtCusID.setText(customerDto.getCusId());
                txtName.setText(customerDto.getCusName());
                txtAddress.setText(customerDto.getCusAddress());
                txtContact.setText(customerDto.getCusContactNumber());
            } else {
                new Alert(Alert.AlertType.INFORMATION, "customer not found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


}
