package com.theBar.controller;

import animatefx.animation.Pulse;
import com.theBar.dto.CustomerDto;
import com.theBar.dto.EmployeeDto;
import com.theBar.dto.tm.EmployeeTm;
import com.theBar.model.CustomerModel;
import com.theBar.model.EmployeeModel;
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

public class EmployeeFoamController implements Initializable {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContactNo;

    @FXML
    private TableColumn<?, ?> colEmpId;

    @FXML
    private TableColumn<?, ?> colJobRole;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private AnchorPane rootEmp;

    @FXML
    private TableView<?> tblEmployees;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtEmpID;

    @FXML
    private TextField txtJobRole;

    @FXML
    private TextField txtName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        loadAllEmployees();
        new Pulse(rootEmp).play();
    }

    private ObservableList<EmployeeTm> loadAllEmployees() {
        CustomerModel model = new CustomerModel();
        ObservableList<EmployeeTm> obList = FXCollections.observableArrayList();

        try {
            List<EmployeeDto> dtoList = model.getAllEmployees();
            for (EmployeeDto dto : dtoList) {
                obList.add(new EmployeeTm(
                        dto.getEmpID(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getContact(),
                        dto.getJobRole()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obList;
    }

    private void setCellValueFactory() {

        colEmpId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colJobRole.setCellValueFactory(new PropertyValueFactory<>("jobRole"));

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String id = txtEmpID.getText();

        try{
            boolean isDeleted = EmployeeModel.deleteEmployee(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee deleted successfully").show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, "An error occurred: " + e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtEmpID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String jobRole = txtJobRole.getText();

        try {
            var dto = new EmployeeDto(id, name, address, contact, jobRole);

            boolean isSaved = EmployeeModel.saveEmployee(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee saved successfully").show();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to save Employee").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "An error occurred: " + e.getMessage()).show();
        }


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtEmpID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String jobRole = txtJobRole.getText();

        try{
            var dto = new EmployeeDto(id, name, address, contact, jobRole);
            boolean isUpdated = EmployeeModel.updateEmployee();

            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee updated successfully").show();
                clearFields();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, "An error occurred: " + e.getMessage()).show();
        }
    }

    private void clearFields() {
        txtEmpID.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtContact.setText("");
        txtJobRole.setText("");
    }

    @FXML
    void txtEmpIDOnAction(ActionEvent event) {
        String id = txtEmpID.getText();

        try {
            EmployeeDto employeeDto = EmployeeModel.searchEmployee(id);
            if (employeeDto != null) {
                txtEmpID.setText(employeeDto.getEmpID());
                txtName.setText(employeeDto.getName());
                txtAddress.setText(employeeDto.getAddress());
                txtContact.setText(employeeDto.getContact());
                txtJobRole.setText(employeeDto.getJobRole());
            } else {
                new Alert(Alert.AlertType.INFORMATION, "customer not found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    }

}
