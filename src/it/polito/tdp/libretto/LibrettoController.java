package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
	
	
	//Non ha senso che sia il controllore a creare il modello perchè possono essercene più di uno
	//Model model = new Model(); <---NO
	//Semplicemente creiamo un riferimento alla classe Model
	//che il controllore si fa passare da qualcuno all'esterno, cioè il MAIN
	//con un metodo SET pubblico
	
	Model model; 

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCodice;

    @FXML
    private TextField txtDocente;

    @FXML
    private TextField txtTitolo;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtMessage;

    @FXML
    void handleCerca(ActionEvent event) {
    	String codice = txtCodice.getText();
    	
    	if (codice.length()<5){
    		txtMessage.appendText("Codice non valido\n");
    		return;
    	}
    	Esame e = model.cercaEsame(codice);
    	if (e == null ){
    		txtMessage.appendText("Codice "+codice+" non trovato\n");
    	}
    	else {
    		txtMessage.appendText("Codice "+codice+" trovato\n");
    		txtCodice.setText(e.getCodiceEsame());
    		txtTitolo.setText(e.getTitoloEsame());
    		txtDocente.setText(e.getDocente());
    	}
    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	//Recupera i dati dalla vista
    	String codice = txtCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	//Verifica la validità dei dati
    	if (codice.length()<5 || titolo.length()==0 || docente.length()==0){
    		txtMessage.appendText("Dati esame insufficienti\n");
    		return;
    	}
    	//Chiedi al Model di effettuare l'operazione
    	Esame e = new Esame (codice, titolo, docente);
    	boolean result = model.addEsame(e);
    	
    	//aggiorna la vista con il risultato dell'operazione
    	if (result){
    		txtMessage.appendText("Esame aggiunto correttamente\n");
    	}
    	else {
    		txtMessage.appendText("Esame non aggiunto (codice duplicato)\n");
    	}
    }

    @FXML
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'Libretto.fxml'.";

    }

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}
}
