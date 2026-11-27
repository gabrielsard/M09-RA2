import java.util.Scanner;

public class Coet {

    private Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            throw new IllegalArgumentException("Potència incorrecta: " + p + " (ha d'estar entre 0 i 10)");
        }
        System.out.println("Passant a potència " + p);
        for (int i = 0; i < motors.length; i++) {
            motors[i].setPotencia(p);
        }
    }

    public void arranca() {
        for (int i = 0; i < motors.length; i++) {
            motors[i].start();
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();

        Scanner scanner = new Scanner(System.in);
        int p = -1;

        while (p != 0) {
            if (scanner.hasNextInt()) {
                p = scanner.nextInt();
                try {
                    coet.passaAPotencia(p);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Introdueix un número enter");
                scanner.next();
            }
        }
    }
}