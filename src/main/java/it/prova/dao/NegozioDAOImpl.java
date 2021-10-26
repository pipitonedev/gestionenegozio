package it.prova.dao;

import java.util.List;

import javax.persistence.EntityManager;


import it.prova.model.Negozio;

public class NegozioDAOImpl implements NegozioDAO{
	
	private EntityManager entityManager;

	@Override
	public List<Negozio> list() throws Exception {
		return entityManager.createQuery("from Negozio", Negozio.class).getResultList();
	}

	@Override
	public Negozio findOne(Long id) throws Exception {
		return entityManager.find(Negozio.class, id);
	}

	@Override
	public void update(Negozio input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Negozio input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}


	@Override
	public void delete(Negozio input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		}

}
