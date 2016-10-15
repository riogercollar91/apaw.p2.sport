package es.upm.miw.apiArchitectureUser.wrappers;

public class SportWrapper {
	private String userName;
	private int sportValue;

	public SportWrapper() {
	}

	public SportWrapper(String userName, int sportValue) {
		this.userName = userName;
		this.sportValue = sportValue;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSportValue() {
		return sportValue;
	}

	public void setSportValue(int sportValue) {
		this.sportValue = sportValue;
	}

	@Override
	public String toString() {
		return "{\"userName\":\"" + userName + ",\"sportValue\":" + sportValue + "}";
	}

}
