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
	
	/**
	 * Nuovo esame, non ancora superato
	 * @param codice codice dell'esame
	 * @param titolo denominazione del corso
	 * @param docente cognome e nome del docente titolare
	 */
	
	public Esame (String codice, String titolo, String docente){
		super();
		this.codiceEsame=codice;
		this.titoloEsame=titolo;
		this.docente=docente;
		
		this.superato=false;
		
	}

	public String getCodiceEsame() {
		return codiceEsame;
	}

	public void setCodiceEsame(String codiceEsame) {
		this.codiceEsame = codiceEsame;
	}

	public String getTitoloEsame() {
		return titoloEsame;
	}

	public void setTitoloEsame(String titoloEsame) {
		this.titoloEsame = titoloEsame;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public boolean isSuperato() {
		return superato;
	}

	public void setSuperato(boolean superato) {
		this.superato = superato;
	}

	/**
	 * Restituisce il voto, solo se l'esame è stato superato,
	 * altrimenti eccezione.
	 * @return
	 */
	public int getVotoEsame() {
		if (this.superato){
		return votoEsame;
		}
		else{
			throw new IllegalStateException("Esame "+this.codiceEsame+" non ancora superato");
		}
	}

	public void setVotoEsame(int votoEsame) {
		this.votoEsame = votoEsame;
	}

	public LocalDate getDataSuperamento() {
		if (this.superato){
		return dataSuperamento;
		}
		else{
			throw new IllegalStateException("Esame "+this.codiceEsame+" non ancora superato");
	
		}
	}

	public void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}

	@Override
	public String toString() {
		return "Esame [codiceEsame=" + codiceEsame + ", titoloEsame=" + titoloEsame + ", docente=" + docente
				+ ", superato=" + superato + ", votoEsame=" + votoEsame + ", dataSuperamento=" + dataSuperamento + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceEsame == null) ? 0 : codiceEsame.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codiceEsame == null) {
			if (other.codiceEsame != null)
				return false;
		} else if (!codiceEsame.equals(other.codiceEsame))
			return false;
		return true;
	}
	
	/**
	 * Se l'esame non è ancora superato, lo considera
	 * superato con il voto e la data specificati.
	 * Se invece l'esame era già superato, genera
	 * un'eccezione.
	 * @param voto
	 * @param data
	 */
	
	public void supera (int voto, LocalDate data){
		if (!this.superato){
			// non ancora superato : OK
			this.superato=true;
			this.votoEsame=voto;
			this.dataSuperamento=data;
			
		} else {
			throw new IllegalStateException("Esame "+this.codiceEsame+" già superato");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
