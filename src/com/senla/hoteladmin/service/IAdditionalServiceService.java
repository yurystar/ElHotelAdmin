package com.senla.hoteladmin.service;

import com.senla.hoteladmin.entity.AdditionalService;

import java.util.List;

public interface IAdditionalServiceService {
    List<AdditionalService> getListAdditionalServicesFromOrder(Integer orderID);
}
