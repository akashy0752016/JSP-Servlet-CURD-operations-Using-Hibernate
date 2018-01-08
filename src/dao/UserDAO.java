package dao;

import java.util.List;

import bean.Users;

public interface UserDAO {
	public List<Users> gerUsers();
	public Users getUser(int id);
	public boolean deleteUser(int id);
	public boolean updateUser(Users u);
	public Integer createUse(Users u);
}
