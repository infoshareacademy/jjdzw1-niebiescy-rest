package niebiescy.rest.repository;


import niebiescy.rest.domain.SearchString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.*;


@Stateless
public class Repository {


    private static final Logger LOGGER = LoggerFactory.getLogger(Repository.class);
    private EntityManager entityManager =
            Persistence.createEntityManagerFactory("primary").createEntityManager();


    public void saveSearchString(SearchString string) {

        LOGGER.debug("Repository przejeło obiekt");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("from searchstring where string like :custString");
        query.setParameter("custString", string);
        SearchString searchString = null;
        try {
            searchString = (SearchString) query.getSingleResult();
        } catch (NoResultException nre) {

            LOGGER.error(nre.toString());

        }

        if (searchString == null) {
            searchString = new SearchString();
            searchString.setString(string.getString());
            searchString.setCounter(1);
            entityManager.persist(searchString);
            LOGGER.debug("Repository dodało nowy string");
        } else {
            searchString.setCounter(searchString.getCounter() + 1);
            entityManager.persist(searchString);
            LOGGER.debug("Repository zwiększyło licznik o 1");
        }

        transaction.commit();


    }


}
