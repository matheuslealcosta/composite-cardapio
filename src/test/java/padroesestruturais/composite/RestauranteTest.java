package padroesestruturais.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteTest {

    @Test
    void deveRetornarCardapioRestaurante() {
        Secao entradas = new Secao("Entradas");
        Prato prato11 = new Prato("Bruschetta", 22.0f);
        entradas.addItem(prato11);

        Secao massas = new Secao("Massas");
        Prato prato21 = new Prato("Lasanha", 45.0f);
        Prato prato22 = new Prato("Espaguete", 38.0f);
        massas.addItem(prato21);
        massas.addItem(prato22);

        Secao sobremesas = new Secao("Sobremesas");

        Secao cardapio = new Secao("Cardápio");
        cardapio.addItem(entradas);
        cardapio.addItem(massas);
        cardapio.addItem(sobremesas);

        Restaurante restaurante = new Restaurante();
        restaurante.setCardapio(cardapio);

        assertEquals("Seção: Cardápio\n" +
                "Seção: Entradas\n" +
                "Prato: Bruschetta - preço: 22.0\n" +
                "Seção: Massas\n" +
                "Prato: Lasanha - preço: 45.0\n" +
                "Prato: Espaguete - preço: 38.0\n" +
                "Seção: Sobremesas\n", restaurante.getCardapio());
    }

    @Test
    void deveRetornarExcecaoRestauranteSemCardapio() {
        try {
            Restaurante restaurante = new Restaurante();
            restaurante.getCardapio();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Restaurante sem cardápio", e.getMessage());
        }
    }
}
