  
/**
 * Ricksy Business
 * ===============
 * Rick se queda a cargo Morty y Summer, 
 * y celebra una pedazo de fiesta. 
 * Entre los invitados hay adolescentes, aliens, 
 * Gearhead, Squanchy, Birdpearson y 
 * Abradolph Lincler (una combinaci�n de DNA
 * de Adolf Hitler y Abraham Lincoln).
 * 
 * Cuando un invitado/a llega a la fiesta, 
 * se le da de alta en el receptivo del sistema
 * mediante su tarjeta de cr�dito.
 * 
 * El receptivo carga en el cr�dito de la tarjeta:
 * - El coste del UberOvni de vuelta a casa
 * - El coste del pack de bienvenida (Collaxion crystals).
 * 
 * El componente de reserva de Ovnis y el componente
 * de entrega del pack de bienvenida observan al
 * componente receptivo, de modo que cuando el receptivo
 * da de alta a un invitado/a autom�ticamente cargan 
 * en la tarjeta del invitado/a el coste de ambos servicios. 
 */

package edu.elsmancs.ricksy;

import edu.elsmancs.UfosPark.UfosPark;
import edu.elsmancs.creditCard.CreditCard;

public class Ricksy {
    
    public static void main(String[] args) {
        System.out.println();

        /**
         * Crea una tarjeta de cr�dito para Abradolph.
         * Como es una AndromedanExpress
         * el cr�dito inicial es de 3000 EZIS
         */

        CreditCard abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");
        
        System.out.println("\n" + "Tarjeta de Abradolph" + "\n" + 
                                  "===================="        );
        System.out.println(abradolph);

        /**
         * Construye el componente de reserva de Ovnis.
         * Recibe el objeto tarjeta de cr�dito del invitado/a
         * en el m�todo dispatch(card)
         * y realiza un cargo a la tarjeta.
         * Si hay saldo suficiente se reserva un UberOvni
         * de los que est�n libres.
         * El coste del ovni es de 500 EZIs.
         */

        UfosPark ufosPark = new UfosPark();

        // Da de alta en la flota de ovnis 2 UFOS.

        String[] ufosID = { "unx", "dox" };
		for (String ovni : ufosID) {
			ufosPark.add(ovni);
        }

    }
}