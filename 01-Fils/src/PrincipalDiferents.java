public class PrincipalDiferents {
    public static void main(String[] args) {
        //la diferencia entre este y el anterior es que ambos tienes distinta prioridad (como se ve en el Thread)
        Fil pepe = new Fil("Pepe", Thread.MIN_PRIORITY, 0, "Acaba");
        Fil juan = new Fil("Juan", Thread.MAX_PRIORITY, 0, "Acaba");

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}