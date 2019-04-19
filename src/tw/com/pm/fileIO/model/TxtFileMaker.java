package tw.com.pm.fileIO.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class TxtFileMaker implements IFileOutput<String> {
	
	public boolean print(ArrayList<String> strCollection,String outputPath) {

		PrintWriter writer;

		File tempFile = new File(outputPath);

		try {
			if (!tempFile.exists()) {
				tempFile = new File("C:\\temp\\test.txt");
				tempFile.createNewFile();
			}
			writer = new PrintWriter(tempFile);
	
			for (String str : strCollection) {
				writer.write(str + "\r\n");

			}
			writer.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
	
			e.printStackTrace();
			return false;
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
		return true;
		
	}

}
