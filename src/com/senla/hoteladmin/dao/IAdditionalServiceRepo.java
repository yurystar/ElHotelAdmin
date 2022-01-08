package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.AdditionalService;

import java.util.List;

public interface IAdditionalServiceRepo extends IDao<AdditionalService> {
    List<AdditionalService> getListAdditionalServicesSortedByPrice();
}
