package lk.ijse.pharmacy.service.custom;

import lk.ijse.pharmacy.service.SuperService;
import lk.ijse.pharmacy.to.Admin;

public interface AdminService extends SuperService {
    boolean addAdmin(Admin admin);
}
