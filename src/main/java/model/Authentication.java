
package model;

import java.io.Serializable;

public class Authentication implements Serializable
{
	private static final long serialVersionUID = 1L;

	private long userId;

	private String userLogin;

	private String userPassword;

	public Authentication()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Authentication(long userId, String userLogin, String userPassword)
	{
		super();
		this.userId = userId;
		this.userLogin = userLogin;
		this.userPassword = userPassword;
	}

	public long getUserId()
	{
		return userId;
	}

	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	public String getUserLogin()
	{
		return userLogin;
	}

	public void setUserLogin(String userLogin)
	{
		this.userLogin = userLogin;
	}

	public String getUserPassword()
	{
		return userPassword;
	}

	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

}
