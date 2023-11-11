package com.theBar.model;

import com.theBar.db.DbConnection;
import com.theBar.dto.CustomerDto;
import com.theBar.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {
    public static boolean saveCustomer(CustomerDto dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO customer VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getCusId());
        pstm.setString(2, dto.getCusName());
        pstm.setString(3, dto.getCusAddress());
        pstm.setString(4, dto.getCusContactNumber());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public static boolean updateCustomer(CustomerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE customer SET cusName=?, cusAddress=?, cusContactNumber=? WHERE id=?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getCusId());
        pstm.setString(2, dto.getCusName());
        pstm.setString(3,dto.getCusAddress());
        pstm.setString(4, dto.getCusContactNumber());

        boolean isUpdated = pstm.executeUpdate() > 0 ;

        return isUpdated;
    }

    public static CustomerDto searchCustomer(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection ();

        String sql = "SELECT * FROM customer WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        CustomerDto dto = null;

        if(resultSet.next()) {
            String cuId = resultSet.getString(1);
            String cusName = resultSet.getString(2);
            String cusAddress = resultSet.getString(3);
            String cusTel = resultSet.getString(4);

            dto = new CustomerDto(cuId, cusName, cusAddress, cusTel);
        }
        return dto;
    }

    public boolean deleteCustomer(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM customer WHERE id=?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;

    }

    public List<CustomerDto> getAllCustomers() throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql =   "SELECT * FROM customer";

        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        ArrayList<CustomerDto> dtoList = new ArrayList<>();

        while(resultSet.next()){
            dtoList.add(
                    new CustomerDto(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    )
            );
        }
        return dtoList;
    }

    public List<EmployeeDto> getAllEmployees() {
        return null;
    }
}
