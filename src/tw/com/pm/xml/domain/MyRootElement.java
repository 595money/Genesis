package tw.com.pm.xml.domain;

import java.lang.reflect.Field;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "beans")
public class MyRootElement {
	List<Bean> beans;
	
	@XmlElement(name = "bean")

	public List<Bean> getBeans() {
		return beans;
	}

	public void setBeans(List<Bean> beans) {
		this.beans = beans;
	}

	public String toString() {
		Field[] fields = this.getClass().getDeclaredFields();
		String res = "";
		try {
			for (Field field : fields) {	
				res += field.getName() + ":\n" + field.get(this);
			}
		} catch (IllegalArgumentException e) {
	
			e.printStackTrace();
		} catch (IllegalAccessException e) {
	
			e.printStackTrace();
		}

		return res;
	}

}
