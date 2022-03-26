package service;

import lombok.NonNull;

import java.sql.SQLException;
import java.util.List;

public interface ServiceInterface<T> {
	T add(@NonNull T item) throws SQLException;
	void remove(@NonNull Long id) throws SQLException;
	void update(@NonNull T item) throws SQLException;
	T findById(@NonNull Long id) throws SQLException;
	List<T> findAll() throws SQLException;
}
