package ru.TechStud.BeamCalculator.domain.exception;

public class NegativeLengthException extends Exception {

    public NegativeLengthException() {
        super("Negative length element");
    }

    public NegativeLengthException(String message) {
        super(message);
    }
}
