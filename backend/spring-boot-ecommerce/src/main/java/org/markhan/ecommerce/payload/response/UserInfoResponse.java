package org.markhan.ecommerce.payload.response;

import java.util.List;

import lombok.Data;

@Data
public class UserInfoResponse {
	private Integer id;
	private String username;
	private List<String> roles;
	
	public UserInfoResponse(Integer id, String username, List<String> roles) {
		this.id = id;
		this.username = username;
		this.roles = roles;
	}
}
