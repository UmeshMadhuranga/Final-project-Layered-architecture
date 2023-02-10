package lk.ijse.pharmacy.service.util;

import lk.ijse.pharmacy.dto.*;
import lk.ijse.pharmacy.entity.Supplier;
import lk.ijse.pharmacy.to.*;

public class Convertor {
    public AdminDTO fromAdmin(lk.ijse.pharmacy.entity.Admin admin){
        return new AdminDTO(admin.getUId(), admin.getName(), admin.getEmail(), admin.getAddress(), admin.getRole(), admin.getPassword());
    }

    public lk.ijse.pharmacy.entity.Admin toAdmin(AdminDTO adminDTO){
        return new lk.ijse.pharmacy.entity.Admin(adminDTO.getUId(), adminDTO.getName(), adminDTO.getEmail(), adminDTO.getAddress(), adminDTO.getRole(), adminDTO.getPassword());
    }

    public CustomerDTO fromCustomer(lk.ijse.pharmacy.entity.Customer customer){
        return new CustomerDTO(customer.getCId(), customer.getName(), customer.getAddress(), customer.getPhone());
    }

    public lk.ijse.pharmacy.entity.Customer toCustomer(CustomerDTO customer){
        return new lk.ijse.pharmacy.entity.Customer(customer.getCId(), customer.getName(), customer.getAddress(), customer.getPhone());
    }

//    public Customer fromTCustomer(lk.ijse.pharmacy.entity.Customer customer){
//        return new Customer(customer.getCId(), customer.getName(), customer.getAddress(), customer.getPhone());
//    }
//
//    public lk.ijse.pharmacy.entity.Customer fromECustomer(Customer customer){
//        return new lk.ijse.pharmacy.entity.Customer(customer.getCId(), customer.getName(), customer.getAddress(), customer.getPhone());
//    }

    public EmployeeDTO fromEmployee(lk.ijse.pharmacy.entity.Employee employee){
        return new EmployeeDTO(employee.getEmId(), employee.getName(), employee.getEmail(), employee.getPhone());
    }

    public lk.ijse.pharmacy.entity.Employee toEmployee(EmployeeDTO employee){
        return new lk.ijse.pharmacy.entity.Employee(employee.getEmID(), employee.getName(), employee.getEmail(), employee.getPhone());
    }

    public MedicationDTO fromMedication(lk.ijse.pharmacy.entity.Medication medication){
        return new MedicationDTO(medication.getMCode(), medication.getDescription(), medication.getExpiration_Date(), medication.getQty(), medication.getPrice());
    }

    public lk.ijse.pharmacy.entity.Medication toMedication(MedicationDTO medication){
        return new lk.ijse.pharmacy.entity.Medication(medication.getMCode(), medication.getDescription(), medication.getExpirationDate(), medication.getQty(), medication.getPrice());
    }

//    public Medication fromTMedication(lk.ijse.pharmacy.entity.Medication medication){
//        return new Medication(medication.getMCode(), medication.getDescription(), medication.getExpiration_Date(), medication.getQty(), medication.getPrice());
//    }
//
//    public lk.ijse.pharmacy.entity.Medication fromEMedication(Medication medication){
//        return new lk.ijse.pharmacy.entity.Medication(medication.getMCode(), medication.getDescription(), medication.getExpirationDate(), medication.getQty(), medication.getPrice());
//    }

    public SupplierDTO fromSupplier(lk.ijse.pharmacy.entity.Supplier supplier){
        return new SupplierDTO(supplier.getSId(), supplier.getName(), supplier.getEmail(), supplier.getAddress(), supplier.getPhone());
    }

    public Supplier toSupplier(SupplierDTO supplier){
        return new Supplier(supplier.getSId(), supplier.getName(), supplier.getEmail(), supplier.getAddress(), supplier.getPhone());
    }

//    public Supplier fromESupplier(lk.ijse.pharmacy.entity.Supplier supplier){
//        return new Supplier(supplier.getSId(), supplier.getName(), supplier.getEmail(), supplier.getAddress(), supplier.getPhone());
//    }
//
//    public lk.ijse.pharmacy.entity.Supplier fromTSupplier(Supplier supplier){
//        return new lk.ijse.pharmacy.entity.Supplier(supplier.getSId(), supplier.getName(), supplier.getEmail(), supplier.getAddress(), supplier.getPhone());
//    }
}
