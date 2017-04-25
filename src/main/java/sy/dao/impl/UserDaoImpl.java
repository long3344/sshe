package sy.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import sy.dao.UserDao;
import sy.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public Serializable save(User t) {
		return sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public List<User> getList() {
		/*sessionFactory.*/
		return null;
	}

}
