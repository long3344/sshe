package sy.service;

import java.util.List;

import sy.model.User;



public interface UserService {

	public void save(String username, String password);
	
	public List<User> getList();
}
