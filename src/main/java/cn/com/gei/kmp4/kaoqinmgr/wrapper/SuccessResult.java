package cn.com.gei.kmp4.kaoqinmgr.wrapper;

public class SuccessResult extends CommonResult	 {

	private static final long serialVersionUID = -3057606388352057334L;

	private String result = "success";

	private Object resultObject;

	public SuccessResult(Object resultObject) {
		this.resultObject = resultObject;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Object getResultObject() {
		return resultObject;
	}

	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}

}
