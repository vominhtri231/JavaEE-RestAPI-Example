package tri.test.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
class JpaService {
    private final EntityManagerFactory emFactory;
    private final ThreadLocal<EntityManager> entityManager = new ThreadLocal<>();

    JpaService() {
        emFactory = Persistence.createEntityManagerFactory("SH");
    }

    public EntityManager getEntityManager() {
        begin();
        return entityManager.get();
    }

    public void begin() {
        if (entityManager.get() == null) {
            entityManager.set(emFactory.createEntityManager());
        }
    }

    public void end() {
        EntityManager em = entityManager.get();

        if (null == em) {
            return;
        }

        try {
            em.close();
        } finally {
            entityManager.remove();
        }
    }
}
