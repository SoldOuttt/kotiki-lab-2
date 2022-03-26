package dao;

import business_logic.SessionUtil;
import entity.CatOwner;
import lombok.NonNull;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class CatOwnerDAO extends SessionUtil implements DAOInterface<CatOwner> {
	@Override
	public void add(@NonNull CatOwner catOwner) throws SQLException {
		Session session = openTransactionSession();
		session.persist(catOwner);
		closeTransactionSession();
	}

	@Override
	public void remove(@NonNull Long catOwnerId) throws SQLException {
		Session session = openTransactionSession();
		session.remove(findById(catOwnerId));
		closeTransactionSession();
	}

	@Override
	public void update(@NonNull CatOwner catOwner) throws SQLException {
		Session session = openTransactionSession();
		session.update(catOwner);
		closeTransactionSession();
	}

	@Override
	public CatOwner findById(@NonNull Long catOwnerId) throws SQLException {
		Session session = openSession();
		CatOwner catOwner = session.get(CatOwner.class, catOwnerId);
		session.close();
		return catOwner;
	}

	@Override
	public List<CatOwner> findAll() throws SQLException {
		Session session = openSession();
		List<CatOwner> catOwners = session.createQuery("from entity.CatOwner", CatOwner.class).getResultList();
		session.close();
		return catOwners;
	}
}
