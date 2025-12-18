package PetCareAPI.Exceptions;

public class NaoEncontrado extends RuntimeException {
    public NaoEncontrado(String message) {
        super(message);
    }
}
