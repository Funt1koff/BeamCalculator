package ru.TechStud.BeamCalculator.domain.load;

import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public abstract class LoadDistributed implements Load {

    @NonNull
    private Double coordinateStart;

    @NonNull
    private Double coordinateEnd;

    @NonNull
    private Double valueOnUnitLength;


}
