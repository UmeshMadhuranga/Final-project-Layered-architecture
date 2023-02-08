package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.Employee;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {
    public static boolean addNewEmployee(String emId, String name, String email, String address, String phone) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employee VALUES(?,?,?,?,?);";
        return CrudUtil.execute(sql,emId,name,email,address,phone);
    }

    public static ArrayList<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM employee");

        ArrayList<Employee> list=new ArrayList<>();

        while (resultSet.next()){
            list.add(new Employee(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
        }
        return list;
    }

    public static Employee searchEmployee(String emId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM employee WHERE emId = ? ",emId);

        while (resultSet.next()){
            return new Employee(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(5));

        }
        return null;
    }

    public static boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE employee SET name=?, email=?, address=?, phone=? WHERE emId = ?;",
                employee.getName(),
                employee.getEmail(),
                employee.getAddress(),
                employee.getPhone(),
                employee.getEmID()
        );
    }

    public static boolean deleteEmployee(String emId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM employee WHERE emId = ?",emId);
    }

    public static ArrayList<String> loadEmployeeIDs() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT emId FROM employee");

        ArrayList<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }
}
