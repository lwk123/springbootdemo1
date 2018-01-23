package cn.com.gei.kmp4.kaoqinmgr.wrapper;

public class ErrorResult extends CommonResult {
	private static final long serialVersionUID = 9058593674170740832L;

	private String result = "error";

	private String resultMessage;

	public ErrorResult(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

}
