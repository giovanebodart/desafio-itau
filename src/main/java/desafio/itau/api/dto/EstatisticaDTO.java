package desafio.itau.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.DoubleSummaryStatistics;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstatisticaDTO {

    private long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

    public EstatisticaDTO(DoubleSummaryStatistics statistics){
        this.count = statistics.getCount();
        this.sum =  statistics.getSum();
        this.avg = statistics.getAverage();
        this.min = statistics.getMin();
        this.max = statistics.getMax();
    }
}
