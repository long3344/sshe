package sy.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.ListModel;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import antlr.collections.List;

import com.alibaba.fastjson.JSON;

import sy.model.User;
import sy.service.UserService;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value="userAction")
public class UserAction {
                                 
	private static final Logger logger=Logger.getLogger(UserAction.class);
	
	
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Resource
	private UserService userService;

	/**
	 * 注册用户
	 * @param t
	 * @return
	 */
	public void reg() {
		logger.info("注册用户！");
		Map< String, Object> map=new HashMap<String, Object>();
		String username=ServletActionContext.getRequest().getParameter("username");
		String password=ServletActionContext.getRequest().getParameter("password");
		
		try {
			userService.save(username,password);
			map.put("success", true);
			map.put("msg", "注册成功！");
		} catch (Exception e) {
			map.put("msg", "注册失败！");
			map.put("success", true);
			logger.error("注册失败，错误信息：",e);
		}
		
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");;
			ServletActionContext.getResponse().getWriter().write(JSON.toJSONString(map));
		} catch (IOException e) {
			logger.error("json转换失败，原因：",e);
		}
		
	}
	
	
	public java.util.List<User> getOrderList(){
		
		java.util.List<User> users=null;
		
		for (int i=1;i<10;i++) {
			User user=new User();
			user.setUsername("姓名"+i);
			user.setPassword("密码"+i);
			users.add(user);
		}
		
		return users;
	}
}
