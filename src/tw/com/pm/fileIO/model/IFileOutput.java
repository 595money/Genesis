package tw.com.pm.fileIO.model;

import java.util.ArrayList;

public interface IFileOutput<T> {
	public boolean print(ArrayList<T> fileCollection,T path);
}
