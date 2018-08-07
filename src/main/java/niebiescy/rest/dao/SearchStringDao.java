package niebiescy.rest.dao;

import javax.ejb.Local;

@Local
public interface SearchStringDao {

    void saveEvent(String string);


}
