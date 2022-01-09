package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.AdditionalService;
import com.senla.hoteladmin.entity.Guest;
import com.senla.hoteladmin.util.IDbConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdditionalServiceDaoImpl implements IAdditionalServiceRepo {
    IDbConnect dbConnect;

    public AdditionalServiceDaoImpl(IDbConnect dbConnect) {
        this.dbConnect = dbConnect;
    }

    @Override
    public Optional<AdditionalService> getAdditionalService(Integer serviceID) throws SQLException {
        String sql = "SELECT serviceID, serviceName, servicePrice FROM AdditionalService WHERE serviceID=?";

        AdditionalService additionalService = new AdditionalService();

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, serviceID);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                additionalService.setServiceID(resultSet.getInt("serviceID"));
                additionalService.setServiceName(resultSet.getString("serviceName"));
                additionalService.setServicePrice(resultSet.getInt("servicePrice"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(additionalService);
    }

    @Override
    public List<AdditionalService> getAllAdditionalServices() throws SQLException {
        List<AdditionalService> additionalServices = new ArrayList<>();

        String sql = "SELECT serviceID, serviceName, servicePrice FROM AdditionalService";

        try (Connection connection = dbConnect.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                AdditionalService additionalService = new AdditionalService();

                additionalService.setServiceID(resultSet.getInt("serviceID"));
                additionalService.setServiceName(resultSet.getString("serviceName"));
                additionalService.setServicePrice(resultSet.getInt("servicePrice"));

                additionalServices.add(additionalService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return additionalServices;
    }

    @Override
    public void saveAdditionalService(AdditionalService service) throws SQLException {
        String sql = "INSERT INTO AdditionalService (serviceName, servicePrice) VALUES(?, ?)";

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setInt(2, service.getServicePrice());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAdditionalService(AdditionalService service) throws SQLException {
        String sql = "UPDATE AdditionalService SET serviceName=?, servicePrice=? " +
                "WHERE serviceID=?";

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setInt(2, service.getServicePrice());
            preparedStatement.setInt(3, service.getServiceID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAdditionalService(AdditionalService service) throws SQLException {
        String sql = "DELETE FROM AdditionalService WHERE serviceID=?";

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, service.getServiceID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//    private final List<AdditionalService> additionalServices = new ArrayList<>();
//
//
//    @Override
//    public Optional<AdditionalService> get(Integer additionalServiceID) {
//        return Optional.ofNullable(additionalServices.get(additionalServiceID));
//    }
//
//    @Override
//    public List<AdditionalService> getAll() {
//        return additionalServices;
//    }
//
//    @Override
//    public void save(AdditionalService additionalService) {
//        additionalServices.add(additionalService);
//    }
//
//    @Override
//    public void update(AdditionalService additionalService) {
//        if (!additionalServices.contains(additionalService)) {
//            additionalServices.add(additionalService);
//        } else {
//            System.out.println("Such an object already exists!");
//        }
//    }
//
//    @Override
//    public void delete(AdditionalService additionalService) {
//        additionalServices.remove(additionalService);
//    }
//
//    @Override
//    public List<AdditionalService> getListAdditionalServicesSortedByPrice() {
//        return additionalServices.stream()
//                .sorted(Comparator.comparingInt(AdditionalService::getServicePrice))
//                .collect(Collectors.toList());
//    }
//}
