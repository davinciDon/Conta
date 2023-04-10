package davi.ContaBanco;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.Scanner;

@Getter
@Setter

public class Open {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random(1000);

    private int NumConta;
    private String Tipo;
    private String Dono;

    private double Balance;
    private double saldoDepositado;
    private double saldoSacado;


    int max = 999;

    int min = 100;

    int intervalo = max - min + 1;


    public void OpenAcount() {

        System.out.print("Enter the username: ");
        setDono(scanner.nextLine());
        System.out.print("Digite o tipo de conta: ");
        setTipo(scanner.nextLine());
        String TYPE = Tipo.toUpperCase();
        if (TYPE.contains("CO")) {
            setTipo("CONTA CORRENTE");  
        } else if (TYPE.contains("PO")) {
            setTipo("CONTA POUPANÇA");
        } else {
            setTipo("CONTA CORRENTE");
        }
        setNumConta(random.nextInt(1000));
        System.out.print("initial deposit: ");
        setBalance(scanner.nextDouble());
        if (getTipo() == "CONTA CORRENTE") {
            setBalance(Balance += 50);
        } else {
            setBalance(Balance += 150);
        }

    }

    public void depositar() {
        System.out.println("");
        System.out.println("what amount do you want to deposit?");
        setSaldoDepositado(scanner.nextDouble());
        setSaldoSacado(0);
        SaldoAtual();

    }

    public void SaldoAtual() {
        setBalance(getBalance() + getSaldoDepositado() - getSaldoSacado());
        System.out.println("The balance in your account is now: " + getBalance());

    }

    public void saque() {
        System.out.println("");
        System.out.println("what amount do you want to withdraw?");
        setSaldoSacado(scanner.nextDouble());
        setSaldoDepositado(0);
        SaldoAtual();
    }

    public void status() {
        System.out.println();
        System.out.println(Tipo);
        System.out.println("The account balance iS: " + getBalance());
        System.out.println("COUNT NUMBER: " + getNumConta());
    }
}
