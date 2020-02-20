  
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
import edu.elsmancs.crystalExpender.CrystalExpender;

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
        
        // Procesamos el pago y reserva de ovni de Abradolph
        ufosPark.dispatch(abradolph);

        // Mostramos el ID del ovni asignado a Abradolph
        System.out.println("\nOvni de Abradolph\n" + 
                             "=================");
        System.out.println(ufosPark.getUfoOf(abradolph.number()));
       
        // Mostramos el credito de la tarjeta de Abradolph
        System.out.println("Credito de Abradolph: " + abradolph.credit());

        // Abradolph quiere reservar otro ovni.
        // El sistema detecta que ya tiene uno 
        // e ignora la petici�n.

        System.out.println("\nAbradolph quiere otro ovni\n" + 
                             "==========================");
        ufosPark.dispatch(abradolph);
        System.out.println("Su credito no ha cambiado: " + abradolph.credit());
        System.out.println("Ovni de Abradolph: " + ufosPark.getUfoOf(abradolph.number()));

        // A GearHead le vac�a la tarjeta el alien "C�mara Lenta" 
        // mientras le daba la chapa, justo antes de pagar el ovni.
        // Intenta reservarlo y el componente de reserva de ovnis
        // no le asigna ninguno.

        System.out.println("\nLLega GearHead!\n" + 
                             "===============");
        CreditCard gearHead = new CreditCard("Gearhead", "8888888888888888");

        gearHead.pay(3000); // le vac�an la cartera

        ufosPark.dispatch(gearHead);
        System.out.println("Su credito es cero: " + gearHead.credit());
        System.out.println("No puede reservar ovni: " + ufosPark.getUfoOf(gearHead.number()));
        
        // Squanchy deja su ovni reservado
        // antes de irse a squanchear

        System.out.println("\nLLega Squanchy!\n" + 
                             "==============");
        CreditCard squanchy = new CreditCard("Squanchy", "4444444444444444");
        ufosPark.dispatch(squanchy);
        System.out.println("Su credito es: " + squanchy.credit());
        System.out.println("Su ovni es: " + ufosPark.getUfoOf(squanchy.number()));

        // Morty quiere un ovni para huir de la fiesta
        // pero ya no queda ninguno disponible

        System.out.println("\nAlgun ovni para Morty?\n" + 
                             "======================");
        CreditCard morty = new CreditCard("Morty", "0000000000000000");
        ufosPark.dispatch(morty);
        System.out.println("Su credito no ha cambiado: " + morty.credit());
        System.out.println("No hay ovni Morty: " + ufosPark.getUfoOf(morty.number()));

        // Metemos un ovni m�s en la flota de ovnis
        // y mostramos la flota por consola

        System.out.println("\nFlota de ovnis\n" + 
                             "==============");
        ufosPark.add("trex");
        System.out.println(ufosPark);
        

        /**
         * Construye el dispensador de packs de bienvenida.
         * Indica el numero de unidades y el coste de cada
         * uno de ellos, que es de 50 EZIs
         */

        CrystalExpender packExpender = new CrystalExpender(3, 50);

        // Muestra el total de packs y su precio unidad
        System.out.println("\nPacks\n" + 
                             "=====");
        System.out.println(packExpender);

        // Abradolph compra su pack de bienvenida
        packExpender.dispatch(abradolph);

        System.out.println("\nAbradolph compra su pack\n" + 
                             "========================");
        System.out.println("Packs\n" + packExpender);
        System.out.println("Credito de Abradolph: " + abradolph.credit());

        // El pobre GerHead no tiene cr�dito para comprar su pack
        System.out.println("\nGearHead sin credito para su pack\n" + 
                             "=================================");
        packExpender.dispatch(gearHead);
        System.out.println("Packs\n" + packExpender);
        System.out.println("Credito de GearHead: " + gearHead.credit());



    }
}