package tri.test.manager;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import tri.test.dao.CountryDao;
import tri.test.dto.CountryDto;

@ApplicationScoped
class CountryManagerImpl implements CountryManager {

    @Inject
    CountryDao countryDao;

    @Override
    public List<CountryDto> getAll() {
        return countryDao.getCountries().stream()
                .map(CountryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CountryDto get(Long id) {
        return CountryDto.fromEntity(countryDao.getCountry(id));
    }

    @Override
    public Long save(CountryDto countryDto) {
        return countryDao.saveCountry(CountryDto.fromDto(countryDto));
    }
}
