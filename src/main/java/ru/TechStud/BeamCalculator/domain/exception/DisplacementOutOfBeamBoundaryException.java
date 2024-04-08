package ru.TechStud.BeamCalculator.domain.exception;

public class DisplacementOutOfBeamBoundaryException extends ElementOutOfBeamBoundaryException {

    public DisplacementOutOfBeamBoundaryException() {
        super("Displacement coordinates go beyond the beam coordinates");
    }

    public DisplacementOutOfBeamBoundaryException(String message) {
        super(message);
    }
}
