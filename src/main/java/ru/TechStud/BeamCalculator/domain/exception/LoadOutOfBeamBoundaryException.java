package ru.TechStud.BeamCalculator.domain.exception;

public class LoadOutOfBeamBoundaryException extends ElementOutOfBeamBoundaryException {

    public LoadOutOfBeamBoundaryException() {
        super("Load concentrated coordinate or Load distributed coordinates go beyond the beam coordinates");
    }

    public LoadOutOfBeamBoundaryException(String message) {
        super(message);
    }
}
