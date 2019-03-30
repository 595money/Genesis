package tw.com.pm.xml.domain;

import java.lang.reflect.Field;
import javax.xml.bind.annotation.XmlAttribute;

public class Property {

	String value;
	String name;

	public String getValue() {
		return value;
	}

	@XmlAttribute
	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		String res = "";
		Field[] fields = this.getClass().getDeclaredFields();
		try {
			for (Field field : fields) {
					res += field.getName() + ":\n" + field.get(this);
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}
}