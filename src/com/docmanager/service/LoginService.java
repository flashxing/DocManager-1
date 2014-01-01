package com.docmanager.service;

public interface LoginService {
	public boolean findUser(String name, String password);

	public int getUserId(String username);
}
