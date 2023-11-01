package exampleMocks;

public class Banco {
    private Asfi asfiService;

    public Asfi getAsfiService() {
        return asfiService;
    }

    public void setAsfiService(Asfi asfiService) {
        this.asfiService = asfiService;
    }

    public int getMaximoPrestamo(String ci){
        String categoria = asfiService.getCategoria(ci);

        return switch (categoria) {
            case "A" -> 200000;
            case "B" -> 100000;
            case "C" -> 0;
            default -> -1;
        };
    }

    public int getMaximoPrestamoStatic(String ci){
        String categoria = AsfiStatic.getCategoria(ci);

        return switch (categoria) {
            case "A" -> 200000;
            case "B" -> 100000;
            case "C" -> 0;
            default -> -1;
        };
    }
}
