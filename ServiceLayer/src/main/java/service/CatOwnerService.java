package service;

import dao.CatOwnerDAO;
import entity.CatOwner;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

import java.sql.SQLException;
import java.util.List;

@Log4j2
@NoArgsConstructor
@AllArgsConstructor
public class CatOwnerService implements ServiceInterface<CatOwner> {
	CatOwnerDAO catOwnerDAO = new CatOwnerDAO();

	@Override
	public CatOwner add(@NonNull CatOwner catOwner) throws SQLException {
		catOwnerDAO.add(catOwner);
		log.info("SUCCESS - catOwner adding to database, table catowner: " + catOwner);
		return catOwner;
	}

	@Override
	public void remove(@NonNull Long catOwnerId) throws SQLException {
		catOwnerDAO.remove(catOwnerId);
		log.info("SUCCESS - catOwner removing from database, table catowner: catOwnerId" + catOwnerId);
	}

	@Override
	public void update(@NonNull CatOwner catOwner) throws SQLException {
		catOwnerDAO.update(catOwner);
		log.info("SUCCESS - catOwner updating in table catowner: " + catOwner);
	}

	@Override
	public CatOwner findById(@NonNull Long catOwnerId) throws SQLException {
		return catOwnerDAO.findById(catOwnerId);
	}

	@Override
	public List<CatOwner> findAll() throws SQLException {
		return catOwnerDAO.findAll();
	}
}
