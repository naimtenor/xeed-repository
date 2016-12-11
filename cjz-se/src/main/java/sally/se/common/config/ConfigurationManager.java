package sally.se.common.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@PropertySource("classpath:/config.properties")
public class ConfigurationManager {

	@Resource
	private Environment env;
	
	public String getString(String key) {
		return env.getProperty(key);
	}
	
	public String getString(String key, String defaultValue) {
		return StringUtils.isEmpty(env.getProperty(key)) ? defaultValue : env.getProperty(key);
	}
	
	public int getInt(String key) {		
		return StringUtils.isEmpty(env.getProperty(key)) ? -1 : Integer.parseInt(env.getProperty(key));
	}
	
	public int getInt(String key, int defaultValue) {
		return StringUtils.isEmpty(env.getProperty(key)) ? defaultValue : Integer.parseInt(env.getProperty(key));
	}
	
	public boolean isExist(String key) {
		return env.getProperty(key) == null ? false : true;
	}
}
