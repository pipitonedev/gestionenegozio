package it.prova.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.dao.NegozioDAO;
import it.prova.web.listener.LocalEntityManagerFactoryListener;
import it.prova.model.Negozio;

public class NegozioServiceImpl implements NegozioService {

	private NegozioDAO negozioDao;

	@Override
	public void setNegozioDao(NegozioDAO negozioDao) {
		this.negozioDao = negozioDao;

	}

	@Override
	public List<Negozio> listAll() throws Exception {

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			negozioDao.setEntityManager(entityManager);

			return negozioDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public Negozio caricaSingoloElemento(Long idInput) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			negozioDao.setEntityManager(entityManager);

			return negozioDao.findOne(idInput);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void aggiorna(Negozio input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			negozioDao.setEntityManager(entityManager);

			negozioDao.update(input);
			entityManager.getTransaction().commit();
		} catch (Exception e) {

			entityManager.getTransaction().rollback();

			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void inserisciNuovo(Negozio input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			negozioDao.setEntityManager(entityManager);

			negozioDao.insert(input);
			entityManager.getTransaction().commit();
		} catch (Exception e) {

			entityManager.getTransaction().rollback();

			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Negozio input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			negozioDao.setEntityManager(entityManager);

			negozioDao.delete(input);
			entityManager.getTransaction().commit();
		} catch (Exception e) {

			entityManager.getTransaction().rollback();

			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}
}
