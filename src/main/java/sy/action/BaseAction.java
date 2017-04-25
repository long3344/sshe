package sy.action;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.alibaba.fastjson.JSON;

@ParentPackage("basePackage")
@Namespace("/")
public class BaseAction {
	public static final Logger LOGGER=Logger.getLogger(BaseAction.class);
	public void writeJson(Object object) {
		try {
			String json=JSON.toJSONStringWithDateFormat(object,"yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("test/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}
}
