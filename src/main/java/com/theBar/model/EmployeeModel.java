package com.theBar.model;

import com.theBar.db.DbConnection;
import com.theBar.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeModel {
    public static boolean saveEmployee(EmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO employee VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getEmpID());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getContact());
        pstm.setString(5, dto.getJobRole());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public static boolean updateEmployee() {
        return false;
    }

    public static void SearchCus(String id) {

    }

    public static boolean deleteEmployee(String id) {
        return false;
    }


    public static EmployeeDto searchEmployee(String id) {
        return null;
    }
}
