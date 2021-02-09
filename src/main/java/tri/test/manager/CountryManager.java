package tri.test.manager;

import java.util.List;

import tri.test.dto.CountryDto;

public interface CountryManager {

    List<CountryDto> getAll();

    CountryDto get(Long id);

    Long save(CountryDto countryDto);
}
