package Utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtility {
	public static ThreadLocal<Session> ses = new ThreadLocal<Session>();
	static SessionFactory sf = null;
	
	static {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
	}
	
	public static Session getSession() {
		Session s = ses.get();
		if(s == null) {
			s = sf.openSession();
			ses.set(s);
		}
		return s;
	}
	
	public static void closeSession() {
		Session s = ses.get();
		if(s != null) {
			ses.set(null);
		}
	}
}
