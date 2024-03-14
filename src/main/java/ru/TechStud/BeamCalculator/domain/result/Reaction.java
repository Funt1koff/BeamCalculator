package ru.TechStud.BeamCalculator.domain.result;

import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Reaction {

    private Double coordinate;
    private Double value;

}
