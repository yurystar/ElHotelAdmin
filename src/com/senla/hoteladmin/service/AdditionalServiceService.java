package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.IAdditionalServiceRepo;
import com.senla.hoteladmin.entity.AdditionalService;
import com.senla.hoteladmin.util.DbConnect;
import com.senla.hoteladmin.util.IDbConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdditionalServiceService implements IAdditionalServiceService {
    private IAdditionalServiceRepo additionalServiceRepo;

    public AdditionalServiceService(IAdditionalServiceRepo additionalServiceRepo) {
        this.additionalServiceRepo = additionalServiceRepo;
    }

    @Override
    public List<AdditionalService> getListAdditionalServicesFromOrder(Integer orderID) {
        return additionalServiceRepo.getListAdditionalServicesFromOrder(orderID);
    }
}
