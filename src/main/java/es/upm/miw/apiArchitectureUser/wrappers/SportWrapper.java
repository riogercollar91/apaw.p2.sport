package es.upm.miw.apiArchitectureUser.wrappers;

public class SportWrapper {
	private String userName;
	private String sportValue;

	public SportWrapper() {
	}

	public SportWrapper(String userName, String sportValue) {
		this.userName = userName;
		this.sportValue = sportValue;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSportValue() {
		return sportValue;
	}

	public void setSportValue(String sportValue) {
		this.sportValue = sportValue;
	}

	@Override
	public String toString() {
		return "{\"userName\":\"" + userName + ",\"sportValue\":" + sportValue + "}";
	}

}
