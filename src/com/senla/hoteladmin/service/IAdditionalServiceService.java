package com.senla.hoteladmin.service;

import com.senla.hoteladmin.entity.AdditionalService;

import java.util.List;

public interface IAdditionalServiceService {
    List<AdditionalService> getListAdditionalServicesFromOrder(Integer orderID);
//
//    List<AdditionalService> getListAdditionalServicesSortedByPrice();
//
    void setAdditionalServicesToOrder(Integer orderID, Integer adserviceID);
//
//    void deleteAdditionalService(AdditionalService additionalService);
//
//    AdditionalService getAdditionalServiceByID(Integer serviceID);
}
