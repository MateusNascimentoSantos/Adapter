package patio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VeiculoApreendidoTest {

    @Test
    void deveRegistrarPlacaAntigaNoFormatoMercosul() {
        VeiculoApreendido veiculo = new VeiculoApreendido();
        veiculo.setPlaca("ABC-1234");

        assertEquals("ABC1C34", veiculo.getPlacaMercosul());
    }

    @Test
    void deveRecuperarPlacaAntigaAPartirDoRegistro() {
        VeiculoApreendido veiculo = new VeiculoApreendido();
        veiculo.setPlaca("ABC-1234");

        assertEquals("ABC-1234", veiculo.getPlaca());
    }

    @Test
    void deveConverterODigitoZeroParaALetraA() {
        VeiculoApreendido veiculo = new VeiculoApreendido();
        veiculo.setPlaca("XYZ-0089");

        assertEquals("XYZ0A89", veiculo.getPlacaMercosul());
    }

    @Test
    void deveConverterODigitoNoveParaALetraJ() {
        VeiculoApreendido veiculo = new VeiculoApreendido();
        veiculo.setPlaca("XYZ-0989");

        assertEquals("XYZ0J89", veiculo.getPlacaMercosul());
    }

    @Test
    void deveManterAPlacaAposIdaEVolta() {
        VeiculoApreendido veiculo = new VeiculoApreendido();
        veiculo.setPlaca("JKL-9876");

        assertEquals("JKL9I76", veiculo.getPlacaMercosul());
        assertEquals("JKL-9876", veiculo.getPlaca());
    }

    @Test
    void deveUsarOAdaptadorComoPlacaMercosul() {
        PlacaAntiga antiga = new PlacaAntiga();
        antiga.setPlaca("JKL-9876");

        PlacaAdapter adaptador = new PlacaAdapter(antiga);
        adaptador.salvarPlaca();

        PlacaMercosul placa = adaptador;

        assertEquals("JKL9I76", placa.getPlaca());
    }

    @Test
    void naoDeveRecuperarPlacaMercosulSemEquivalente() {
        try {
            PlacaAdapter adaptador = new PlacaAdapter(new PlacaAntiga());
            adaptador.setPlaca("ABC1K23");
            adaptador.recuperarPlaca();
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Placa sem equivalente no formato antigo: ABC1K23", e.getMessage());
        }
    }

    @Test
    void naoDeveAceitarPlacaForaDoFormatoAntigo() {
        try {
            new PlacaAntiga().setPlaca("ABC1234");
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Placa fora do formato antigo: ABC1234", e.getMessage());
        }
    }

    @Test
    void naoDeveAceitarPlacaForaDoFormatoMercosul() {
        try {
            new PlacaMercosul().setPlaca("ABC-1234");
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Placa fora do formato Mercosul: ABC-1234", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoVeiculoSemPlaca() {
        try {
            new VeiculoApreendido().getPlaca();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Veiculo sem placa", e.getMessage());
        }
    }
}
