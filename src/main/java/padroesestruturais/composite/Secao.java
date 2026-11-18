package padroesestruturais.composite;

import java.util.ArrayList;
import java.util.List;

public class Secao extends ItemCardapio {

    private List<ItemCardapio> itens;

    public Secao(String descricao) {
        super(descricao);
        this.itens = new ArrayList<ItemCardapio>();
    }

    public void addItem(ItemCardapio item) {
        this.itens.add(item);
    }

    public String getConteudo() {
        String saida = "";
        saida = "Seção: " + this.getDescricao() + "\n";
        for (ItemCardapio item : itens) {
            saida += item.getConteudo();
        }
        return saida;
    }
}
