package tri.test.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import tri.test.model.Country;

@ApplicationScoped
class CountryDaoImpl implements CountryDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Country> getCountries() {
        CriteriaQuery<Country> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Country.class);
        return entityManager.createQuery(criteriaQuery.select(criteriaQuery.from(Country.class))).getResultList();
    }

    @Override
    public Country getCountry(Long id) {
        return entityManager.find(Country.class, id);
    }

    @Override
    @Transactional
    public Long saveCountry(Country country) {
        entityManager.persist(country);
        return country.getId();
    }
}
