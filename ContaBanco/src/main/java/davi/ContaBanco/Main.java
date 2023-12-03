package davi.ContaBanco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Main {

    public static void main(String[] args) {
        Open OPEN1 = new Open(777);


        OPEN1.buy(10000);
        OPEN1.buy(100);

        OPEN1.extrato();


    }
}
