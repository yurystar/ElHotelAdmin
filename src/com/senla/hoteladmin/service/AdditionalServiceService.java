package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.IAdditionalServiceRepo;
import com.senla.hoteladmin.entity.AdditionalService;
import com.senla.hoteladmin.util.DbConnect;
import com.senla.hoteladmin.util.IDbConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdditionalServiceService implements IAdditionalServiceService {
    private IDbConnect dbConnect;

    public AdditionalServiceService(IDbConnect dbConnect) {
        this.dbConnect = dbConnect;
    }

    @Override
    public List<AdditionalService> getListAdditionalServicesFromOrder(Integer orderID) {
        List<AdditionalService> additionalServices = new ArrayList<>();

        String sql = "select c.serviceID, c.serviceName, c.servicePrice from Order_adservice as a\n" +
                "inner join AdditionalService as c on a.adserviceID = c.serviceID\n" +
                "where a.orderID = ?";

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, orderID);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                AdditionalService service = new AdditionalService();

                service.setServiceID(resultSet.getInt("serviceID"));
                service.setServiceName(resultSet.getString("serviceName"));
                service.setServicePrice(resultSet.getInt("servicePrice"));

                additionalServices.add(service);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return additionalServices;
    }

    @Override
    public void setAdditionalServicesToOrder(Integer orderID, Integer adserviceID) {
        String sql = "INSERT INTO Order_adservice (orderID, adserviceID) VALUES(?, ?)";

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, orderID);
            preparedStatement.setInt(2, adserviceID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



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
