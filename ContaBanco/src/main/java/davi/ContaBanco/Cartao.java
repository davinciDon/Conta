package davi.ContaBanco;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Slf4j
public class Cartao {
    private double limit;
    private double saldo;
    private double valorCompra;
    List<Compra> Listcompras;

    public Cartao(double limit) {
        setLimit(limit);
        this.Listcompras = new ArrayList<>();
    }

    private void RegidtraCompra(Compra compra) {
        if (this.getLimit() >= compra.getValor()) {
            this.setLimit(this.getLimit() - compra.getValor());
            Listcompras.add(compra);
            log.info("xxxxx");
        }
    }

    public void buy(double valor) {
        Compra compra = new Compra(valor);
        RegidtraCompra(compra);

    }

    public void extrato() {
        for (Compra compra : Listcompras) {
            System.out.println(compra);
        }
        System.out.println(getLimit());
    }
}
