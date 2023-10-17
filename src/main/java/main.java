import libs.Leer;

public class main {
    public static void main(String[]args){
        String guiones = "-".repeat(20);
        int menu;
        boolean salir = false;
        do

        {
            System.out.println(guiones);
            System.out.println("1.");
            System.out.println("0.Salir");
            System.out.println(guiones);
            menu = Leer.introduceEntero("Introduce el número del menú: ");
            System.out.println(guiones);

            switch (menu) {
                case 1 -> ;
                case 0 -> salir = true;
            }
        }while(!salir);
    }
}
