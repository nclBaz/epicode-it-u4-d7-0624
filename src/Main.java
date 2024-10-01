import entities.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		User aldo = new User("Aldo", "Baglio");
		User giovanni = new User("Giovanni", "Storti");
		User giacomo = new User("Giacomo", "Poretti");

		ArrayList<User> usersList = new ArrayList<>(); // Nelle parentesi angolari vado a specificare il tipo di dato che voglio venga salvato nella lista


		System.out.println("------------------------------------------ ADD --------------------------------------------");
		// Permette di aggiungere elementi o in coda, o specificando un indice/posizione che di conseguenza shifta gli altri elementi
		System.out.println("La lista ha " + usersList.size() + " elementi");
		usersList.add(aldo);
		usersList.add(giovanni);
		usersList.add(giacomo);
		usersList.add(0, new User("Marina", "Massironi"));
		// oppure	usersList.addFirst(new User("Marina", "Massironi"));
		System.out.println("La lista ha " + usersList.size() + " elementi");

		System.out.println(usersList);

		for (User user : usersList) {
			System.out.println(user);
		}

		System.out.println("------------------------------------------ GET --------------------------------------------");
		// Permette di ottenere un elemento fornendo l'indice di tale elemento (occhio a non uscire dai limiti della lista)
		try {
			User found = usersList.get(5);
			System.out.println(found);
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Utente non trovato!");
		}

		System.out.println("------------------------------------------ INDEX OF --------------------------------------------");
		// Ci restituisce l'indice di uno specifico utente della lista
		System.out.println("L'indice di Giovanni è: " + usersList.indexOf(giovanni));

		System.out.println("------------------------------------------ CONTAINS --------------------------------------------");
		// Ci ritorna un booleano che permette di verificare se un certo elemento è presente nella lista
		if (usersList.contains(aldo)) {
			// .contains() internamente utilizza il metodo .equals della classe User. Di default quindi compara le celle di memoria, volendo
			// però .equals si può overridare a piacimento
			System.out.println("La lista contiene l'elemento Aldo");
		} else {
			System.out.println("La lista NON contiene Aldo");
		}

		System.out.println("------------------------------------------ REMOVE --------------------------------------------");
		// Remove permette di togliere un elemento dalla lista o passando l'elemento stesso oppure passando un indice. Due varianti comode
		// invece permettono di rimuovere il primo elemento o l'ultimo
		usersList.remove(aldo);
		usersList.remove(1);
		usersList.removeFirst();
		usersList.removeLast();
		System.out.println("La lista ha " + usersList.size() + " elementi");

		System.out.println("------------------------------------------ ADD ALL --------------------------------------------");
		// AddAll ci consente di aggiungere ad una lista dati provenienti da una Collection. Se parto da un array devo convertilo in lista
		usersList.addAll(List.of(new User[]{aldo, giovanni, giacomo})); // Se ho un array di User posso 'convertirlo in lista' e tramite addAll inserirlo all'interno di un'altra lista
		System.out.println("La lista ha " + usersList.size() + " elementi");
		System.out.println(usersList);

		System.out.println("------------------------------------------ REMOVE ALL --------------------------------------------");
		// RemoveAll ci permette di rimuovere una lista di elementi (non svuota per forza tutta la lista originaria)
		User[] usersArray = {aldo, giovanni};
		usersList.removeAll(List.of(usersArray));
		System.out.println("La lista ha " + usersList.size() + " elementi");
		System.out.println(usersList);

		System.out.println("------------------------------------------ SET --------------------------------------------");
		// Set serve per rimpiazzare un elemento della lista dato un indice
		usersList.set(0, new User("Ajeje", "Brazorf"));
		System.out.println(usersList);

		System.out.println("------------------------------------------ CLEAR --------------------------------------------");
		// Clear svuota totalmente una lista
		System.out.println("La lista è vuota? " + usersList.isEmpty());
		usersList.clear();
		System.out.println("La lista è vuota? " + usersList.isEmpty());
		System.out.println("La lista ha " + usersList.size() + " elementi");
		System.out.println(usersList);

		// ************************************************************** COLLECTIONS E TIPI PRIMITIVI **************************************************
		// ArrayList<int> numeriInteri = new ArrayList<>(); <-- Non posso creare Collections contenenti dati primitivi
		// Però posso utilizzare le cosiddette WRAPPER CLASSES, ovvero le classi che corrispondono ai tipi primitivi. Ogni tipo primitivo avrà la sua:
		// Integer, Double, Float, Byte, Short, Boolean,....
		ArrayList<Integer> numeriInteri = new ArrayList<>();
		numeriInteri.add(1);
		numeriInteri.add(100);
	}
}