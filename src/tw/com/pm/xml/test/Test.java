package tw.com.pm.xml.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


import tw.com.pm.fileIO.model.IFileOutput;
import tw.com.pm.fileIO.model.TxtFileMaker;
import tw.com.pm.xml.domain.Bean;
import tw.com.pm.xml.domain.MyRootElement;
import tw.com.pm.xml.domain.Property;
import tw.com.pm.xml.model.EncryptionAndDecryptionUtils;

public class Test {
	public static void main(String[] args) throws IOException {
		EncryptionAndDecryptionUtils e1 = new EncryptionAndDecryptionUtils();
//		try {
//			File file = new File("C:\\Work\\dcd\\SimonTools\\TheUser.xml");
//			JAXBContext jaxbContext = JAXBContext.newInstance(MyRootElement.class);
//
//			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//			MyRootElement b = (MyRootElement) jaxbUnmarshaller.unmarshal(file);
//
//			ArrayList<String> strList = new ArrayList<String>();
//			
//			for (Bean b1 : b.getBeans()) {
//				Stack<String> stack = new Stack<String>();
//				int i = 0;
//				for (Property p : b1.getProperty()) {
//					stack.push("USERID: " + p.getName() + "\n"
//							+ "USERID_VALUE: " + p.getValue());
//					if (p.getValue().matches("\\w+==$")) {
//						strList.add("Setting ID: " + b1.getId());
//						strList.add(stack.get(i - 1));
//						strList.add("PWD_NAME: " + p.getName() + "\n" + "ePWD_VALUE: " + p.getValue());
//						strList.add("dPWD_VALUE: " + e1.decryptPassWord(p.getValue()) + "\n\n");
//					}
//					i++;
//				}
//			}
//			IFileOutput<String> mk = new TxtFileMaker();//txt  output
//			System.out.println(mk.print(strList, "")?"成功":"失敗");
//
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		}
//		
		/*
		String path = "F:\\PM\\Users\\pm070\\Desktop\\test.txt";
		File file = new File(path);
		String str = "";
		String msg = "";
		String fileName = file.getName();
		BufferedReader in = new BufferedReader(new FileReader(file));	

	        while ((str = in.readLine()) != null) {
	        	
	        	msg = msg + str;
	        	
	        	//if(str.indexOf(vo.getCityID()) == -1){
	        		//continue;
	        	//}
	        	if(str.trim().length() == 0 || str.indexOf("M_NB")!= -1 ||  str.indexOf("-")!= -1){
	        		continue;
	        	}
		    	str = str.substring(str.indexOf('|')+1);
	        	String M_XGRTE = str.substring(0, str.indexOf('|')).trim();
	    		System.out.println(M_XGRTE);
	        	str = str.substring(str.indexOf('|')+1);
	        	String M_EXRFLAG = str.substring(0,str.indexOf('|')).trim();
	        	System.out.println(M_EXRFLAG);
	        	str = str.substring(str.indexOf('|')+1);
	        	String murexSpotID = str.trim();
	        	System.out.println(murexSpotID);
	        }
	        
	      

			String str1 = "1";
			str1.indexOf("M_NB");
			System.out.println(str1.indexOf("M_NB"));
			*/
		
	int x = 0;	
		if(true) {
			x++;
			
			
			
		}
	
		
			
		
		
		
		
		
		
		
	}
}
