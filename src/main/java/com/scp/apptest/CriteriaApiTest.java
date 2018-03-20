package com.scp.apptest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.scp.entity.Passenger;
import com.scp.utility.DBSessionFactory;

public class CriteriaApiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CriteriaApiTest().normalCriteria();
		new CriteriaApiTest().criteriaLogical();
		new CriteriaApiTest().criteriaSorting();
		new CriteriaApiTest().criteriaPagination();
		new CriteriaApiTest().criteriaProjection();
	}

	public void normalCriteria() {
		Session session = DBSessionFactory.sf.openSession();

		Criteria criteria = session.createCriteria(Passenger.class);
		criteria.add(Restrictions.idEq(1));
		System.out.println("!!..Normal Criteria..!!");
		System.out.println(criteria.list());
		session.close();

	}

	public void criteriaLogical() {
		Session session = DBSessionFactory.sf.openSession();
		Criteria criteria = session.createCriteria(Passenger.class);
		
		Criterion criterion = Restrictions.eq("arrival", "Pune");
		Criterion criterion1 = Restrictions.eq("departure", "Beed");

		org.hibernate.criterion.LogicalExpression exp = Restrictions.or(criterion, criterion1);
		//criteria.add(Restrictions.and(Restrictions.eq("arrival", "Pune"), Restrictions.eq("departure", "Beed")));
		criteria.add(exp);
		System.out.println("!!,,Logical Expression..!!");
		System.out.println(criteria.list().toString());
		session.close();

	}

	public void criteriaSorting() {
		Session session = DBSessionFactory.sf.openSession();
		Criteria criteria = session.createCriteria(Passenger.class);
		criteria.addOrder(org.hibernate.criterion.Order.desc("departure"));
		System.out.println("!!,,Criteria Sorting..!!");
		System.out.println(criteria.list().toString());
	}

	public void criteriaPagination() {
		Session session = DBSessionFactory.sf.openSession();
		Criteria criteria = session.createCriteria(Passenger.class);
		criteria.setFirstResult(1);
		criteria.setMaxResults(3);
		System.out.println("!!,,Criteria Sorting..!!");
		System.out.println(criteria.list());
	}

	public void criteriaProjection() {
		Session session = DBSessionFactory.sf.openSession();
		Criteria criteria = session.createCriteria(Passenger.class);
		criteria.setProjection(Projections.rowCount());
		System.out.println("Projection Rowcount");
		System.out.println(criteria.list());
	}
}
