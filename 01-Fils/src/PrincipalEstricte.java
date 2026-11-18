public class PrincipalEstricte {
    public static void main(String[] args) throws InterruptedException {
        Fil juan = new Fil("Juan", Thread.NORM_PRIORITY, 50, "Termina");
        Fil pepe = new Fil("Pepe", Thread.NORM_PRIORITY, 50, "Termina");

        juan.start();
        Thread.sleep(25);   //Pepe arranca a mitad del turno de Juan
        pepe.start();

        System.out.println("Termina thread main");
    }
}