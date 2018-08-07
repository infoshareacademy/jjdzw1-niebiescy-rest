package niebiescy.rest.dao;

import niebiescy.rest.domain.SearchString;
import niebiescy.rest.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class SearchStringDaoBean implements SearchStringDao {


    private static final Logger LOGGER = LoggerFactory.getLogger(Repository.class);


    @Override
    public void saveEvent(String string) {

        LOGGER.debug("SearchStringDaoBean przejeło string");

        Repository repository = new Repository();
        SearchString searchString = new SearchString();

        searchString.setString(string);


        repository.saveSearchString(searchString);

        LOGGER.debug("SearchStringDaoBean zapisało string");




    }
}
