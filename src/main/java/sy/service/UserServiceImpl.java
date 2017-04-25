package sy.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import sy.dao.UserDao;
import sy.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	public static final Logger LOGGER=Logger.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserDao userDao;
	
	public void save(String username,String password) {
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setCreatedTime(new Date());
		user.setUpdatedTime(new Date());
		userDao.save(user);
	}

	@Override
	public List<User> getList() {

		return userDao.getList();
	}
}
