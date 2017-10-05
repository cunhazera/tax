package com.tax.operation;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class QueryObject<T> {asdasdasdasdasdasdasdasdasdasdasdasdasd

	@PersistenceContext(name = "exampleDS")
	private EntityManager manager;

	public T save(T object) {
		manager.persist(object);
		return object;
	}

	public List<T> listAll(EntityPath<T> qEntity) {
		return createQuery().from(qEntity).fetch();
	}

	public T findById(EntityPath<?> qEntity, Predicate predicate) {
		return createQuery().from(qEntity).where(predicate).fetchOne();
	}

	public T editEntity(T object) {
		return manager.merge(object);
	}

	public void delete(EntityPath<?> entity, Predicate predicate) {
		new JPADeleteClause(manager, entity).where(predicate).execute();
	}

	public JPAQuery<T> createQuery() {
		return new JPAQuery<T>(manager, HQLTemplates.DEFAULT);
	}

}
