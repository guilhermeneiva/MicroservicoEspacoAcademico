package br.ucsal.espacoFisico_ms.model.exception;

public class NaoExisteException extends RuntimeException {
    public NaoExisteException(String message) {
        super(message);
    }

}
