package tri.test.dao;

import java.util.List;

import tri.test.model.Country;

public interface CountryDao {

    List<Country> getCountries();

    Country getCountry(Long id);

    Long saveCountry(Country country);
}
