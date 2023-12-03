package davi.ContaBanco;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

@Getter
@Setter
@Slf4j

public class Open extends Cartao {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random(1000);

    private int NumConta;
    private String Tipo;
    private String Dono;


    private double Balance;
    private double saldoDepositado;
    private double saldoSacado;

    public Open(double limit) {
        super(limit);
    }

    public void OpenConta() {
        log.info("Enter the username: ");
        setDono(scanner.nextLine());
        log.info("Digite o tipo de conta: ");
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
        inicialDeposito();
        if (getTipo() == "CONTA CORRENTE") {
            setBalance(Balance += 50);
        } else {
            setBalance(Balance += 150);
        }

    }

    public void inicialDeposito() {
        log.info("initial deposit: ");
        try {
            setSaldoDepositado(scanner.nextDouble());
        } catch (InputMismatchException e) {

            inicialDeposito();
        }
    }

    public void depositar() {
        System.out.println("");
        log.info("What amount do you want to deposit?");

        try {
            setSaldoDepositado(scanner.nextDouble());
            SaldoAtual();
        } catch (InputMismatchException e) {
            log.info("Invalid input. Please enter a valid number.");
            scanner.next();
            depositar();
        }


    }

    public void SaldoAtual() {
        setBalance(getBalance() + getSaldoDepositado() - getSaldoSacado());
        log.info("The balance in your account is now: " + getBalance());

    }

    public void saque() {
        System.out.println("");
        log.info("what amount do you want to withdraw?");
        try {
            setSaldoSacado(scanner.nextDouble());
            SaldoAtual();
        } catch (InputMismatchException e) {
            log.info("Invalid input. Please enter a valid number.");
            scanner.next();
            saque();
        }
    }

    public void status() {
        log.info("");
        log.info(getTipo());
        log.info("The account balance iS: " + getBalance());
        log.info("COUNT NUMBER: " + getNumConta());
    }


    }

