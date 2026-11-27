public class Motor extends Thread {

    private int id;
    private volatile int potenciaObjectiu = 0;   
    private int potenciaActual = 0;
    private volatile boolean ordenat = false;    

    public Motor(int id) {
        this.id = id;
    }

    public void setPotencia(int p) {
        potenciaObjectiu = p;
        ordenat = true;
    }

    @Override
    public void run() {
        while (true) {
            int objectiu = potenciaObjectiu;

            if (potenciaActual == objectiu) {
                if (ordenat && objectiu == 0) {
                    return;
                }
                dormir(20);    
            } else {

                dormir(1000 + (int) (Math.random() * 1001));

                objectiu = potenciaObjectiu;    
                String etiqueta = "FerRes";
                if (potenciaActual < objectiu) {
                    potenciaActual++;
                    etiqueta = "Incre.";
                } else if (potenciaActual > objectiu) {
                    potenciaActual--;
                    etiqueta = "Decre.";
                }
                if (potenciaActual == objectiu) {
                    etiqueta = "FerRes";
                }

                System.out.printf("Motor %d: %s Objectiu: %d Actual: %d%n",
                        id, etiqueta, objectiu, potenciaActual);
            }
        }
    }

    private void dormir(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}