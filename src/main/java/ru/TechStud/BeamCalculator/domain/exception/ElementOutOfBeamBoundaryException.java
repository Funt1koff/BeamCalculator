package ru.TechStud.BeamCalculator.domain.exception;

public class ElementOutOfBeamBoundaryException extends Exception {

    public ElementOutOfBeamBoundaryException() {
        super("Element coordinates go beyond the beam coordinates");
    }

    public ElementOutOfBeamBoundaryException(String message) {
        super(message);
    }
}
