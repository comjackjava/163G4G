package com.qhit.zxks.common.dao;

import com.qhit.zxks.common.bean.Teacher;
import com.qhit.zxks.user.bean.Account;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Teacher entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.qhit.zxks.common.bean.Teacher
 * @author MyEclipse Persistence Tools
 */
public class TeacherDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TeacherDAO.class);
	// property constants
	public static final String TNAME = "tname";
	public static final String SEX = "sex";
	public static final String AGE = "age";
	public static final String MID = "mid";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";

	/**
	 * µÇÂ½²éÑ¯
	 * @param username
	 * @param password
	 * @return
	 */
    public Account selAccountForLogin(String username,String password){
    	String hql = "from Teacher a where a.username=:username and a.password=:password ";
    	Query query = getSession().createQuery(hql);
    	query.setString("username", username);
    	query.setString("password", password);
    	Account account = (Account) query.uniqueResult();
    	return account;
    }
	public void save(Teacher transientInstance) {
		log.debug("saving Teacher instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Teacher persistentInstance) {
		log.debug("deleting Teacher instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Teacher findById(java.lang.Integer id) {
		log.debug("getting Teacher instance with id: " + id);
		try {
			Teacher instance = (Teacher) getSession().get(
					"com.qhit.zxks.common.bean.Teacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Teacher instance) {
		log.debug("finding Teacher instance by example");
		try {
			List results = getSession()
					.createCriteria("com.qhit.zxks.common.bean.Teacher")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Teacher instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Teacher as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTname(Object tname) {
		return findByProperty(TNAME, tname);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List findByMid(Object mid) {
		return findByProperty(MID, mid);
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findAll() {
		log.debug("finding all Teacher instances");
		try {
			String queryString = "from Teacher";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Teacher merge(Teacher detachedInstance) {
		log.debug("merging Teacher instance");
		try {
			Teacher result = (Teacher) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Teacher instance) {
		log.debug("attaching dirty Teacher instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Teacher instance) {
		log.debug("attaching clean Teacher instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}