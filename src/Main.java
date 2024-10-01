import entities.User;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		User aldo = new User("Aldo", "Baglio");
		User giovanni = new User("Giovanni", "Storti");
		User giacomo = new User("Giacomo", "Poretti");

		// ArrayList<User> usersList = new ArrayList<>(); // Nelle parentesi angolari vado a specificare il tipo di dato che voglio venga salvato nella lista
		List<User> usersList = new LinkedList<>(); // <-- UPCASTING. Lo utilizzo se voglio tenermi una porta aperta per il futuro. Nel senso
		// che potrei voler in futuro sostituire l'ArrayList con un altro tipo di List, ad esempio LinkedList
		// Se utilizzo metodi specifici che solo le ArrayList possiedono purtroppo però non potrò usare l'upcasting
		// Le LinkedList sono più performanti in termini di aggiunte/rimozioni rispetto alle ArrayList, di contro però le ArrayList sono ben più compatte
		// e quindi efficienti

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

		// ************************************************************** RIMUOVERE ELEMENTI DA LISTE **************************************************
		ArrayList<String> lettere = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g")); // Per inizializzare una lista con valori posso usare Arrays.asList()

		/* Non si può rimuovere elementi mentre la si sta ciclando
		for (String lettera : lettere) {
				if (lettera.equals("c")) lettere.remove(lettera);
				else System.out.println(lettera);
			}*/

		// Per poter rimuovere elementi da una lista mentre la si cicla bisogna usare il cosiddetto Iterator
		Iterator<String> iterator = lettere.iterator();
		while (iterator.hasNext()) { // Fino a che ci sono ulteriori elementi, prosegui con il ciclo
			String lettera = iterator.next(); // iterator.next() mi restituisce sempre l'elemento corrente
			if (lettera.equals("c")) iterator.remove(); // <-- N.B. non sto facendo lettere.remove() perché avrei lo stesso problema di sopra
				// devo utilizzare l'iterator, quindi iterator.remove(). Il risultato finale è che l'iterator riuscirà a rimuovere quell'elemento
				// dalla lista
			else System.out.println(lettera);
		}


		// ********************************************************** SET **********************************************************
		// I Set a differenza delle List NON AMMETTONO DUPLICATI, per poterci regalare questa funzionalità però ad ogni inserimento dovrà
		// ciclare l'intera collezione di dati per cercare se c'è un duplicato di quello che stiamo inserendo, se non c'è lo inserisce
		// se c'è ritornerà false
		HashSet<User> usersSet = new HashSet<>();
		// Set<User> usersSet = new HashSet<>(); <-- anche qua potrei usare l'upcasting
		// Alternativa a HashSet è il LinkedHashSet che mantiene anche un ordine di inserzione degli elementi
		usersSet.add(aldo);
		usersSet.add(giovanni);
		usersSet.add(giacomo);
		// usersSet.add(aldo); <-- Aggiungere un duplicato non è vietato nel senso che riceverò un'eccezione, IntelliJ mi segnala semplicemente
		// come warning la cosa perché comunque fare un .add() nei Set significa che Java dovrà percorrere tutto il Set prima di capire se può aggiungere
		// l'elemento
		System.out.println(usersSet);

		TreeSet<String> alfabeto = new TreeSet<>(); // Il TreeSet oltre a non contenere duplicati mi ordina gli elementi (operazione molto costosa quindi
		// se non necessaria meglio utilizzare un altro tipo di Set )
		alfabeto.add("g");
		alfabeto.add("b");
		alfabeto.add("z");
		alfabeto.add("a");
		alfabeto.add("c");

		System.out.println(alfabeto);

		TreeSet<User> usersTreeSet = new TreeSet<>(); // Per rendere gli User compatibili con i TreeSet bisogna che essi possiedano un criterio di
		// ordinamento. Per fare ciò devono implementare l'interfaccia COMPARABLE
		usersTreeSet.add(giovanni);
		usersTreeSet.add(aldo);
		System.out.println(usersTreeSet);

		// ********************************************************** MAP **********************************************************
		// Le Map sono strutture dati in cui ogni elemento è caratterizzato da una coppia <CHIAVE, VALORE>, quindi quando ne creiamo una dovremo
		// specificare di che tipo sarà la chiave e di che tipo sarà il valore. Le chiavi devono essere UNICHE
		HashMap<Integer, User> usersMap = new HashMap<>(); // Qua ad es. sto dichiarando che questa usersMap avrà come chiavi dei numeri interi
		// qualsiasi e come valori corrispondenti degli utenti
		// In questo caso ogni elemento di usersMap sarà un qualcosa del tipo:
		// 123213 - Aldo Baglio
		// 213134 - Giovanni Storti
		// 333333 - Giacomo Poretti

		HashMap<String, String> dizionario = new HashMap<>(); // In questo caso sia chiave che valore sono di tipo String
		// In questo caso ogni elemento di dizionario sarà un qualcosa del tipo:
		// "Casa" - "Definizione della parola casa"
		// "Barbagianni" - "Definizione di barbagianni"

		System.out.println("----------------------------------------- AGGIUNTA ELEMENTI --------------------------------------------------");
		usersMap.put(123213, aldo); // Quando aggiungo gli elementi devo rispettare i tipi di chiave e valore
		usersMap.put(213134, giovanni);
		usersMap.put(333333, giacomo);
		System.out.println(usersMap);

		dizionario.put("Casa", "Definizione della parola casa");
		dizionario.put("Barbagianni", "Definizione di barbagianni");
		dizionario.put("Barbagianni", "Asdasdasdsadas"); // Non ci possono essere due elementi con la stessa chiave, mi sovrascriverà il precedente
		System.out.println(dizionario);


		System.out.println("----------------------------------------- LEGGERE ELEMENTI --------------------------------------------------");
		System.out.println("La definizione di Barbagianni è: " + dizionario.get("Barbagianni")); // Se la chiave non viene trovata mi restituisce NULL

		System.out.println("----------------------------------------- RIMUOVERE ELEMENTI --------------------------------------------------");
		dizionario.remove("Casa"); // Anche per rimuovere specifico la chiave

		System.out.println("----------------------------------------- MODIFICARE UN VALORE DI UN ELEMENTO --------------------------------------------------");
		dizionario.replace("Barbagianni", "Definizione più aggiornata di Barbagianni"); // Anche per cambiare un valore specifico la chiave, ritorna null se non lo trova

		System.out.println("----------------------------------------- OTTENERE ELENCO CHIAVI --------------------------------------------------");
		Set<String> chiaviDizionario = dizionario.keySet(); // Mi ritorna un Set perché le chiavi sono tutte univoche

		for (String chiave : chiaviDizionario) {
			System.out.println("Chiave: " + chiave);
			System.out.println("Valore: " + dizionario.get(chiave));
		}

		System.out.println("----------------------------------------- OTTENERE ELENCO VALORI --------------------------------------------------");
		Collection<String> valoriDizionario = dizionario.values();
		System.out.println(valoriDizionario);

	}
}