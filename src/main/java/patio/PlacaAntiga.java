package patio;

public class PlacaAntiga implements IPlaca {

    private String placa;

    @Override
    public String getPlaca() {
        return this.placa;
    }

    @Override
    public void setPlaca(String placa) {
        if (!this.validar(placa)) {
            throw new IllegalArgumentException("Placa fora do formato antigo: " + placa);
        }
        this.placa = placa;
    }

    public boolean validar(String placa) {
        if (placa == null || placa.length() != 8) {
            return false;
        }
        if (placa.charAt(3) != '-') {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (placa.charAt(i) < 'A' || placa.charAt(i) > 'Z') {
                return false;
            }
        }
        for (int i = 4; i < 8; i++) {
            if (placa.charAt(i) < '0' || placa.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
