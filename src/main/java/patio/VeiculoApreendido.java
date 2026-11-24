package patio;

public class VeiculoApreendido {

    IPlaca placa;
    PlacaAdapter registro;

    public VeiculoApreendido() {
        placa = new PlacaAntiga();
        registro = new PlacaAdapter(placa);
    }

    public void setPlaca(String placa) {
        this.placa.setPlaca(placa);
        registro.salvarPlaca();
    }

    public String getPlaca() {
        if (registro.getPlaca() == null) {
            throw new NullPointerException("Veiculo sem placa");
        }
        return registro.recuperarPlaca();
    }

    public String getPlacaMercosul() {
        if (registro.getPlaca() == null) {
            throw new NullPointerException("Veiculo sem placa");
        }
        return registro.getPlaca();
    }
}
