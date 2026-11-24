package patio;

public class PlacaAdapter extends PlacaMercosul {

    private IPlaca placaAntiga;

    public PlacaAdapter(IPlaca placaAntiga) {
        this.placaAntiga = placaAntiga;
    }

    public void salvarPlaca() {
        String antiga = placaAntiga.getPlaca();
        char letra = (char) ('A' + (antiga.charAt(5) - '0'));
        this.setPlaca(antiga.substring(0, 3) + antiga.charAt(4) + letra + antiga.substring(6, 8));
    }

    public String recuperarPlaca() {
        String mercosul = this.getPlaca();
        if (mercosul.charAt(4) > 'J') {
            throw new IllegalArgumentException("Placa sem equivalente no formato antigo: " + mercosul);
        }
        char digito = (char) ('0' + (mercosul.charAt(4) - 'A'));
        placaAntiga.setPlaca(mercosul.substring(0, 3) + "-" + mercosul.charAt(3) + digito + mercosul.substring(5, 7));
        return placaAntiga.getPlaca();
    }
}
