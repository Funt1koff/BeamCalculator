package ru.TechStud.BeamCalculator.domain.load;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class DistributedRectangle extends LoadDistributed {

    public DistributedRectangle(@NonNull Double coordinateStart, @NonNull Double coordinateEnd, @NonNull Double valueOnUnitLength) {
        super(coordinateStart, coordinateEnd, valueOnUnitLength);
    }
}
