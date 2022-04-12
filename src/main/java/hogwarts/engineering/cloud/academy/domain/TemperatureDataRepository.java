package hogwarts.engineering.cloud.academy.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TemperatureDataRepository extends CrudRepository<TemperatureData,Long> {
    public List<TemperatureData> findByTimestamp(Long timestamp);
}
