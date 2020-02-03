/**
 * 
 */
package com.beerrun.dto;

import java.io.Serializable;

/**
 * @author 
 *
 */
public class UserLoginDto  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String userName;

	private String password;

	private Integer isDelete;

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
