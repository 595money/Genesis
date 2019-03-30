package tw.com.pm.fileIO.model;
 
import java.io.IOException;
import java.util.ArrayList;


import tw.com.pm.fileIO.domain.FileRider;
import tw.com.pm.fileIO.model.IFileOutput;

public class RiderContrller {
	private IFileOutput<String> fileMaker;
	
	public RiderContrller(){
		this.fileMaker = new TxtFileMaker();
	}
	public RiderContrller(IFileOutput<String> out) {
		this.fileMaker = out;
	}

	public void run(String path1, String path2) {

		FileRider rider = new FileRider(path1);

		ArrayList<String> riderNote = new ArrayList<String>();

		try {
			//1.iterator 指定目錄並記錄下所有檔案絕對路徑
			rider.excute();
			//2.取回絕對路徑資料
			riderNote = rider.getNote();
			//3.輸出
			fileMaker.print(riderNote, path2);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}