package tp_note;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
/**
 * Classe qui implémente une vue dans le cadre d'une architecture MVC
 * @author sinteff3u
 *
 */
public class VueNbPaires extends JLabel implements Observer{
	
	/**
	 * Constructeur de la vue
	 */
	public VueNbPaires(){
		this.setText("Nombre de paires découvertes: 0");
	}
	
	/**
	 * méthode appelée par notifyObervers() du modèle
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.setText("Nombre de paires découvertes: "+((Model)o).getNbPaires());
		
	}

}
