package tw.com.pm.fileIO.domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileRider {
	private String abPath;
	private File file;
	private ArrayList<String> note;
	private int totalSize = 0;
	private int rowNum = 0;

	public FileRider(String abPath) {
		setAbPath(abPath);
		setFile(new File(abPath));
		setNote(new ArrayList<String>());
	}

	public void excute() throws IOException {

		if (file == null || !file.exists()) {
			throw new IOException("頝臬�隤�");
		}
		run(file);
		note.add("====================================================================== " );
		note.add("size :" + String.format("%5d", totalSize)+ "MB   "+ "� " +rowNum + " 蝑�" );
	}

//	public void run(File f) {
//
//		if (f.isFile()) {
//			note.add(f.getAbsolutePath().replace(abPath, ""));
//		} else {
//			for (File newFile : f.listFiles()) {
//				run(newFile);
//			}
//		}
//	};
	
	public void run(File f) {

		if (f.isFile()) {
			Long space = f.length();
			double spaceMb = space/1000000;
		
			if(spaceMb > 50){
			note.add("size :" + String.format("%5d", (int) spaceMb)+ "MB   "+ f.getAbsolutePath() );
			totalSize += (int) spaceMb;
			rowNum++;
			}
			
			
		} else {
			for (File newFile : f.listFiles()) {
				run(newFile);
			}
		}
	};

	public String getAbPath() {
		return abPath;
	}

	public void setAbPath(String abPath) {
		this.abPath = abPath;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public ArrayList<String> getNote() {
		return note;
	}

	public void setNote(ArrayList<String> note) {
		this.note = note;
	}
}
