public class Fil extends Thread {

    private String nombre;
    private int retardo;  
    private long feina = 0;
    private String textoFinal;    

    public Fil(String nom, int prioritat, int retard, String textFinal) {
        this.nombre = nom;
        this.retardo = retard;
        this.textoFinal = textFinal;
        setName(nom);
        setPriority(prioritat);
    }

    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(nombre + " " + i);

            if (retardo > 0) {
                try {
                    Thread.sleep(retardo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                for (int k = 0; k < 1000; k++) {
                    for (int m = 0; m < 1000; m++) {
                        feina++;
                    }
                }
            }
        }
        System.out.println(textoFinal + " el fil " + nombre);
    }
}