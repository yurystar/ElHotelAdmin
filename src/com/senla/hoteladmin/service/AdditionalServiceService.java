package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.IAdditionalServiceRepo;
import com.senla.hoteladmin.entity.AdditionalService;

import java.util.List;

public class AdditionalServiceService /*implements IAdditionalServiceService*/ {
    private IAdditionalServiceRepo additionalServiceRepo;

//    public AdditionalServiceService(IAdditionalServiceRepo additionalServiceRepo) {
//        this.additionalServiceRepo = additionalServiceRepo;
//    }
//
//    @Override
//    public List<AdditionalService> getListAdditionalServices() {
//        return additionalServiceRepo.getAll();
//    }
//
//    @Override
//    public List<AdditionalService> getListAdditionalServicesSortedByPrice() {
//        return additionalServiceRepo.getListAdditionalServicesSortedByPrice();
//    }
//
//    @Override
//    public void setNewAdditionalService(AdditionalService additionalService) {
//        additionalServiceRepo.save(additionalService);
//    }
//
//    @Override
//    public void deleteAdditionalService(AdditionalService additionalService) {
//        additionalServiceRepo.delete(additionalService);
//    }
//
//    @Override
//    public AdditionalService getAdditionalServiceByID(Integer serviceID) {
//        return additionalServiceRepo.getAll().stream()
//                .filter(additionalService -> additionalService.getServiceID().equals(serviceID))
//                .findFirst()
//                .orElse(null);
//    }
}
