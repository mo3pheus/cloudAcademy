package hogwarts.engineering.cloud.academy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "temperature_data")
public class TemperatureData {
    @Id
    @Getter
    @Setter
    private Long timestamp;

    @Getter
    @Setter
    private float temperature;

    public TemperatureData() {
    }

    public TemperatureData(Long timestamp, float temperature) {
        this.temperature = temperature;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Timestamp = " + timestamp + " temperature = " + temperature;
    }
}
