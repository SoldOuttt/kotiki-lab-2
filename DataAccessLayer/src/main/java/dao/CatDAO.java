package dao;

import business_logic.SessionUtil;
import entity.Cat;
import lombok.NonNull;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class CatDAO extends SessionUtil implements DAOInterface<Cat> {
	@Override
	public void add(@NonNull Cat cat) throws SQLException {
		Session session = openTransactionSession();
		session.persist(cat);
		closeTransactionSession();
	}

	@Override
	public void remove(@NonNull Long catId) throws SQLException {
		Session session = openTransactionSession();
		session.remove(findById(catId));
		closeTransactionSession();
	}

	@Override
	public void update(@NonNull Cat cat) throws SQLException {
		Session session = openTransactionSession();
		session.update(cat);
		closeTransactionSession();
	}

	@Override
	public Cat findById(@NonNull Long catId) throws SQLException {
		Session session = openSession();
		Cat cat = session.get(Cat.class, catId);
		session.close();
		return cat;
	}

	@Override
	public List<Cat> findAll() throws SQLException {
		Session session = openSession();
		List<Cat> cats = session.createQuery("from entity.Cat", Cat.class).getResultList();
		session.close();
		return cats;
	}
}
