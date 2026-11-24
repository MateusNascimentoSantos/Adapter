package patio;

public class PlacaMercosul {

    private String placa;

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        if (!this.validar(placa)) {
            throw new IllegalArgumentException("Placa fora do formato Mercosul: " + placa);
        }
        this.placa = placa;
    }

    public boolean validar(String placa) {
        if (placa == null || placa.length() != 7) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (placa.charAt(i) < 'A' || placa.charAt(i) > 'Z') {
                return false;
            }
        }
        if (placa.charAt(3) < '0' || placa.charAt(3) > '9') {
            return false;
        }
        if (placa.charAt(4) < 'A' || placa.charAt(4) > 'Z') {
            return false;
        }
        for (int i = 5; i < 7; i++) {
            if (placa.charAt(i) < '0' || placa.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
