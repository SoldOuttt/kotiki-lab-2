package service;

import dao.CatDAO;
import entity.Cat;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

import java.sql.SQLException;
import java.util.List;

@Log4j2
public class CatService implements ServiceInterface<Cat> {
	CatDAO catDAO = new CatDAO();

	@Override
	public Cat add(@NonNull Cat cat) throws SQLException {
		catDAO.add(cat);
		log.info("SUCCESS - cat adding to database, table cat: " + cat);
		return cat;
	}

	@Override
	public void remove(@NonNull Long catId) throws SQLException {
		catDAO.remove(catId);
		log.info("SUCCESS cat removing from database, table cat: catId" + catId);
	}

	@Override
	public void update(@NonNull Cat cat) throws SQLException {
		catDAO.update(cat);
		log.info("SUCCESS - cat updating in table cat: " + cat);
	}

	@Override
	public Cat findById(@NonNull Long catId) throws SQLException {
		return catDAO.findById(catId);
	}

	@Override
	public List<Cat> findAll() throws SQLException {
		return catDAO.findAll();
	}
}
