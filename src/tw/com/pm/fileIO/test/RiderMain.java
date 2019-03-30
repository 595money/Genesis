package tw.com.pm.fileIO.test;
import java.util.Scanner;

import tw.com.pm.fileIO.model.AbstractMain;
import tw.com.pm.fileIO.model.RiderContrller;
import tw.com.pm.fileIO.model.STException;

public class RiderMain extends AbstractMain {
	public RiderMain(boolean needIn, boolean needOut, boolean needSuccess) {
		super(needIn, needOut, needSuccess);
	}

	private String resource;
	private String target;

	@Override
	public boolean inputProcessHook() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("輸入路徑：");
		resource = scanner.nextLine().trim();
		System.out.println("紀錄存放路徑：");
		target = scanner.nextLine().trim();
		return true;
	}

	@Override
	public boolean outputProcessHook() throws STException {
		RiderContrller r = new RiderContrller();
		r.run(resource, target);
		return true;

	}

	@Override
	public void successHook() {
		System.out.println("成功");

	}

	public static void main(String[] args) {
		AbstractMain rm = new RiderMain(true, true, true);

		try {
			rm.worflow();
		} catch (STException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
