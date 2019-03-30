package tw.com.pm.util.domain;

import tw.com.pm.util.model.ICollection;
import tw.com.pm.util.model.IIterator;
//
public class DictionaryIterator implements IIterator<String> {
	private ICollection pathDictonary;

	public DictionaryIterator() {

	}

	public DictionaryIterator(MyDictionary dic) {
		setPathDictonary(dic);
	}

	public boolean hasNext() {
		return true;
	};

	public String next() {
		return "";
	};

	public void setPathDictonary(ICollection dic) {
		this.pathDictonary = dic;

	}
}
