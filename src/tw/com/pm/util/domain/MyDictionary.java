package tw.com.pm.util.domain;

import tw.com.pm.util.model.ICollection;
import tw.com.pm.util.model.IIterator;

public class MyDictionary implements ICollection {
	
	public MyDictionary(){
		pathArr = new String[10];
	}
	private String[] pathArr ;
	private boolean isEmpty(){
	
		return 	pathArr.length == 0;
	}
	

	public void add(String path){
		
	}
	@Override
	public IIterator IIterator() {

		return new DictionaryIterator(this);
	}

}
