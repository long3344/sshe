package sy.dao;

import java.io.Serializable;
import java.util.List;

import sy.model.User;

public interface UserDao {
	
	public Serializable save(User t);

	public List<User> getList();
}
