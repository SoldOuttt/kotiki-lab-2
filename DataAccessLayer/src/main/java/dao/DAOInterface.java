package dao;

import lombok.NonNull;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T> {
	void add(@NonNull T item) throws SQLException;
	void remove(@NonNull Long id) throws SQLException;
	void update(@NonNull T item) throws SQLException;
	T findById(@NonNull Long id) throws SQLException;
	List<T> findAll() throws SQLException;
}
