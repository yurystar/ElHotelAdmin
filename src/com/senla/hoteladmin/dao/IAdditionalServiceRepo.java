package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.AdditionalService;
import com.senla.hoteladmin.entity.Guest;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IAdditionalServiceRepo {
    Optional<AdditionalService> getAdditionalService(Integer serviceID) throws SQLException;

    List<AdditionalService> getAllAdditionalServices() throws SQLException;

    void saveAdditionalService(AdditionalService service) throws SQLException;

    void updateAdditionalService(AdditionalService service) throws SQLException;

    void deleteAdditionalService(AdditionalService service) throws SQLException;

    List<AdditionalService> getListAdditionalServicesFromOrder(Integer orderID);

    void setAdditionalServicesToOrder(Integer orderID, Integer adserviceID);

//    List<AdditionalService> getListAdditionalServicesSortedByPrice();
}
