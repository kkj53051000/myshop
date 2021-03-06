package com.myshop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.myshop.domain.Orderinfo;

@Repository
public class OrderinfoRepository {
	@PersistenceContext
	private EntityManager em;
	
	
	public void insertOrderinfo(Orderinfo orderinfo) {
		em.persist(orderinfo);
	}
	
	// order 안에 orderinfoList
	public List<Orderinfo> selectOrderinfos(long order_id){
		List<Orderinfo> orderinfos = em.createQuery("select o From Orderinfo o where o.order.id = : id", Orderinfo.class)
				.setParameter("id", order_id)
				.getResultList();
		
		return orderinfos;
	}
}
