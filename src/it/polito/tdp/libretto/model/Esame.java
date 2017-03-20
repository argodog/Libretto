package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
 * Oggetto semplice che contiene i dati relativi ad un singolo esame.
 * POJO - plain old java object
 * 
 * oggetto al cui interno contiene:
 * dati privati (proprietà)
 * costruttore
 * metodi getter/setter
 * metodi di servizio (toString, equals, hashCode, [compareTo])
 * 
 * @author Ste
 *
 */

public class Esame {

	private String codiceEsame;
	private String titoloEsame;
	//****
	
	// sarebbe molto più funzionale usare un oggetto di classe docente:
	// private Docente docente;
	
	//****
	private String docente; //per ora trattiamo il docente come stringa per comodità
	
	private boolean superato;
	private int votoEsame;
	private LocalDate dataSuperamento;
	
}
