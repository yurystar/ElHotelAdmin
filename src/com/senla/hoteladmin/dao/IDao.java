package com.senla.hoteladmin.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDao<T> {
    Optional<T> get(Integer id);

    List<T> getAll();

    void save(T t) throws SQLException;

    void update(T t);

    void delete(T t) throws SQLException;
}
