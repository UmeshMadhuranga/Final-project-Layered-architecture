package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.to.Customer;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {
    public static boolean addNewCustomer(String cId, String name, String address, String phone) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO customer VALUES(?,?,?,?);";
        return CrudUtil.execute(sql,cId,name,address,phone);
    }

    public static ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM customer");

        ArrayList<Customer> arrayList=new ArrayList<>();

        while (resultSet.next()){
            arrayList.add(new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
        }
        return arrayList;
    }

    public static Customer searchCustomer(String cId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM customer WHERE cId = ?",cId);
        while (resultSet.next()) {
            return new Customer(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4));
        }
        return null;
    }

    public static boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE customer SET name=?, address=?, phone=? WHERE cId = ?;",
                customer.getName(),
                customer.getAddress(),
                customer.getPhone(),
                customer.getCId()
        );
    }

    public static boolean deleteCustomer(String cId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM customer WHERE cId = ?",cId);
    }

    public static ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT cId FROM customer");

        ArrayList<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }

    public static ArrayList<String> loadMedicationCode() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT mCode FROM medication");

        ArrayList<String> codeList = new ArrayList<>();
        while (resultSet.next()) {
            codeList.add(resultSet.getString(1));
        }
        return codeList;
    }
}
