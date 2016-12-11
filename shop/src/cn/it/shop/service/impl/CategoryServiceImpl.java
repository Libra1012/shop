package cn.it.shop.service.impl;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.util.HibernateSessionFactory;

/**
 * @Title:CategoryServiceImpl
 * @Package:cn.it.shop.service.impl
 * @Description: TODO(目前service与 Dao整合在一起的)
 * @author venus
 * @version:V1.0
 */
public class CategoryServiceImpl implements CategoryService {
	
	//有侵入性
	//private HibernateTemplate hibernateTemplate;
	
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		//从当前线程获取Session， 如果没有则创建一个新Session
		return sessionFactory.getCurrentSession();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Category category) {
		//通过工具类获取session
		Session session = HibernateSessionFactory.getSession();
		
		try {
			//手动事务
			session.getTransaction().begin();
			//执行业务逻辑
			session.save(category);
			//手动提交
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new RuntimeException();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public void update(Category category) {
		getSession().update(category);
//		System.out.println("===========");
//		Integer.parseInt("xyz");
		

	}
}
