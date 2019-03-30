package tw.com.pm.xml.domain;

import java.lang.reflect.Field;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Bean {
	String id;

	List<Property> property;

	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "property")
	public List<Property> getProperty() {
		return property;
	}

	public void setProperty(List<Property> property) {
		this.property = property;
	}

	@Override
	public String toString() {
		Field[] fields = this.getClass().getDeclaredFields();
		String res = "\n";
		try {
			for (Field field : fields) {
				res += field.getName() + ":\n" + field.get(this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
