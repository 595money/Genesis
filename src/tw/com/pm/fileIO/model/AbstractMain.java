package tw.com.pm.fileIO.model;

public abstract class AbstractMain {

	boolean inputProcessHook;
	boolean outputProcessHook;
	boolean needSuccessHook;

	public AbstractMain(boolean needIn, boolean needOut, boolean needSuccess) {

		setNeedSuccessHook(needIn);
		setInputProcessHook(needOut);
		setOutputProcessHook(needSuccess);
	}

	public final void worflow() throws STException {

			if (inputProcessHook)
				inputProcessHook();
			if (outputProcessHook)
				outputProcessHook();
			if (needSuccessHook)
				successHook();

	}

	public abstract boolean inputProcessHook() throws STException;

	public abstract boolean outputProcessHook() throws STException;

	public abstract void successHook();

	public boolean isNeedSuccessHook() {
		return needSuccessHook;
	}

	public void setNeedSuccessHook(boolean needSuccessHook) {
		this.needSuccessHook = needSuccessHook;
	}

	public boolean isInputProcessHook() {
		return inputProcessHook;
	}

	public void setInputProcessHook(boolean inputProcessHook) {
		this.inputProcessHook = inputProcessHook;
	}

	public boolean isOutputProcessHook() {
		return outputProcessHook;
	}

	public void setOutputProcessHook(boolean outputProcessHook) {
		this.outputProcessHook = outputProcessHook;
	}

}
