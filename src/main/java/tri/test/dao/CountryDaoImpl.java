package tri.test.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;

import tri.test.model.Country;

@ApplicationScoped
class CountryDaoImpl implements CountryDao {

    @Inject
    private JpaService jpaService;

    @Override
    public List<Country> getCountries() {
        EntityManager entityManager = jpaService.getEntityManager();
        CriteriaQuery<Country> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Country.class);
        return entityManager.createQuery(criteriaQuery.select(criteriaQuery.from(Country.class))).getResultList();
    }

    @Override
    public Country getCountry(Long id) {
        return jpaService.getEntityManager().find(Country.class, id);
    }

    @Override
    public Long saveCountry(Country country) {
        EntityManager entityManager = jpaService.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            jpaService.begin();
            transaction.begin();
            entityManager.persist(country);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            jpaService.end();
        }

        return country.getId();
    }
}
