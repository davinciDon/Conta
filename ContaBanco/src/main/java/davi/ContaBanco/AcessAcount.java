package davi.ContaBanco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcessAcount {

    public static void main(String[] args) {
        Open OPEN1 = new Open();
        OPEN1.OpenAcount();
        OPEN1.status();
        OPEN1.buy();
        OPEN1.buy();
        OPEN1.status();



    }
}
