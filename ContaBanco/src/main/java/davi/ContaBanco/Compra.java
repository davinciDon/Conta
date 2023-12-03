package davi.ContaBanco;

import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

@Getter
@Setter
public class Compra {
    private double valor;

    public Compra(double valor){
        this.setValor(valor);
    }

    public String toString() {
        return "valor = " + getValor();
    }


}

