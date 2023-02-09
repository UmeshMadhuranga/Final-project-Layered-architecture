package lk.ijse.pharmacy.service.util;

import lk.ijse.pharmacy.to.*;

public class Convertor {
    public Admin fromTAdmin(lk.ijse.pharmacy.entity.Admin admin){
        return new Admin(admin.getUId(),admin.getName(), admin.getEmail(), admin.getAddress(), admin.getRole(), admin.getPassword());
    }

    public lk.ijse.pharmacy.entity.Admin fromEAdmin(Admin admin){
        return new lk.ijse.pharmacy.entity.Admin(admin.getUId(),admin.getName(), admin.getEmail(), admin.getAddress(), admin.getRole(), admin.getPassword());
    }

    public Customer fromTCustomer(lk.ijse.pharmacy.entity.Customer customer){
        return new Customer(customer.getCId(), customer.getName(), customer.getAddress(), customer.getPhone());
    }

    public lk.ijse.pharmacy.entity.Customer fromECustomer(Customer customer){
        return new lk.ijse.pharmacy.entity.Customer(customer.getCId(), customer.getName(), customer.getAddress(), customer.getPhone());
    }

    public Employee fromTEmployee(lk.ijse.pharmacy.entity.Employee employee){
        return new Employee(employee.getEmId(), employee.getName(), employee.getEmail(), employee.getPhone());
    }

    public lk.ijse.pharmacy.entity.Employee fromEEmployee(Employee employee){
        return new lk.ijse.pharmacy.entity.Employee(employee.getEmID(), employee.getName(), employee.getEmail(), employee.getPhone());
    }

    public Medication fromTMedication(lk.ijse.pharmacy.entity.Medication medication){
        return new Medication(medication.getMCode(), medication.getDescription(), medication.getExpiration_Date(), medication.getQty(), medication.getPrice());
    }

    public lk.ijse.pharmacy.entity.Medication fromEMedication(Medication medication){
        return new lk.ijse.pharmacy.entity.Medication(medication.getMCode(), medication.getDescription(), medication.getExpirationDate(), medication.getQty(), medication.getPrice());
    }

    public Supplier fromESupplier(lk.ijse.pharmacy.entity.Supplier supplier){
        return new Supplier(supplier.getSId(), supplier.getName(), supplier.getEmail(), supplier.getAddress(), supplier.getPhone());
    }

    public lk.ijse.pharmacy.entity.Supplier fromTSupplier(Supplier supplier){
        return new lk.ijse.pharmacy.entity.Supplier(supplier.getSId(), supplier.getName(), supplier.getEmail(), supplier.getAddress(), supplier.getPhone());
    }
}
