package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Utility.SessionUtility;
import bean.Users;

public class UserDAOIMP implements UserDAO {

	@Override
	public List<Users> gerUsers() {
		// TODO Auto-generated method stub
		List<Users> list = new ArrayList<Users>();
		Session s = SessionUtility.getSession();
		Query q = s.createQuery("From Users");
		list = (List<Users>) q.list();
		//s.close();
		return list;
	}

	@Override
	public Users getUser(int id) {
		// TODO Auto-generated method stub
		Session s = SessionUtility.getSession();
		Users u = (Users) s.get(Users.class, id);
		//s.close();
		return u;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		Session s = SessionUtility.getSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from Users where id = :id");
		q.setInteger("id", id);
		Users u = (Users) q.uniqueResult();
		s.delete(u);
		tx.commit();
		s.flush();
		//s.close();
		//System.out.println("Updated");
		return true;
	}

	@Override
	public boolean updateUser(Users u) {System.out.println(u.getPassword());
		// TODO Auto-generated method stub
		Session s = SessionUtility.getSession();
		Query q = s.createQuery("from Users where id = :id");
		q.setInteger("id", u.getId());
		Users us = (Users) q.uniqueResult();System.out.println(us.getPassword());
		us.setName(u.getName());
		us.setEmail(u.getEmail());
		us.setPassword(u.getPassword());
		System.out.println(us.getPassword());
		s.update(us);
		s.flush();
		//s.close();
		//System.out.println("Deleted");
		return true;
	}

	@Override
	public Integer createUse(Users u) {
		// TODO Auto-generated method stub
		Session s = SessionUtility.getSession();
		Transaction tx = s.beginTransaction();
		Integer i = (Integer) s.save(u);
		tx.commit();
		//s.close();
		return i;
	}

}
