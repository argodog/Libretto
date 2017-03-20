package it.polito.tdp.libretto.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model m = new Model();

		m.addEsame(new Esame ("03FYZ", "Tecniche di Programmazione", "Fulvio Corno"));
		m.addEsame(new Esame ("01QZP", "Ambient Intelligence", "Fulvio Corno"));
		
		//test riaggiunta esame già inserito
		m.addEsame(new Esame ("03FYZ", "Tecniche di Programmazione", "Fulvio Corno"));

		
		System.out.println(m.cercaEsame("03FYZ"));
		System.out.println(m.cercaEsame("01QZP"));
		System.out.println(m.cercaEsame("04AAA"));

	}

}
