package lk.ijse.pharmacy.dao;

import lk.ijse.pharmacy.entity.SuperEntity;

import java.io.Serializable;

public interface CrudDAO<T extends SuperEntity, ID extends Serializable> extends SuperDAO{
}
