import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int  fichas, masFicha, ruleta, gana;
        int tope = 1000;

        double azar;
        String cantidad, elegir, respuesta;


        respuesta = JOptionPane.showInputDialog(null, "Quiere jugar a la ruleta*, Si o No?");// Pregunta si quieren jugar

        do{

            if(respuesta.equalsIgnoreCase("si")){//aca evalua si la respuesta de arriba si es SI ejecut lo que se encuentra dentro del do, sino salta hasta el while
                cantidad = JOptionPane.showInputDialog(" Apuesta maxima " + tope + "¿Cuantas fichas quiere apostar?" );//apusta
                fichas = Integer.parseInt(cantidad);
                elegir = JOptionPane.showInputDialog("Elija un numero, entre el '0 y el 36'");// elegis el numero
                ruleta = Integer.parseInt(elegir);
                if( ruleta >= 0 && ruleta <= 36){//evalua si el numero se encuentra entre 0 y 36
                    azar = Math.random() * 36;// tira un numero random entre 0 y 36 este es Double
                    gana = (int) Math.round(azar);// aca pasamos el Double a entero
                    JOptionPane.showMessageDialog(null, "El numero ganador es " + gana);//aca muestra el numero que salio random
                    if(ruleta == gana){//aca compara si tu numero es igual al random
                        masFicha = fichas * 35;//aca si ganaste lo multiplica por 35
                        tope += fichas;//aca la var tope se suma en caso de ganar
                        JOptionPane.showMessageDialog(null, "Ganaste " + masFicha + " fichas, ahora tienes " + tope + "en total");//imprime

                        respuesta = JOptionPane.showInputDialog(null, "Quiere seguir jugando? Si o No");//aca pregunta si quiere volver a jugar

                    }else if(ruleta != gana){//aca se evalua si el num que elegiste es diferente al numero ganador
                        tope -= fichas; // aca se var tope se resta
                        JOptionPane.showMessageDialog(null, "Perdiste " + fichas + " fichas y te quedan disponible " +tope );// muestra por pantalla que perdiste
                        respuesta = JOptionPane.showInputDialog(null, "No has tenido suerte, vuelves a intentarlo? Si o No");//vuelve a preguntar si queres jugar
                    }
                }else if(ruleta < 0 || ruleta > 36){//aca se evalua si el numero que ingresaste es menor a 0 y mayor a 36
                    JOptionPane.showMessageDialog(null, "Numeros validos desde el '0 al 36'");// muestra por pantalla
                }
            }
        }while(respuesta.equalsIgnoreCase("Si") == true); //aca se evalua si la respuesta que diste es NO y te saca del bucle
        JOptionPane.showMessageDialog(null, "Adios, LUDOPATA... enfermo, vuelva pronto ;)");//
    }

}