package tp_note;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

/**
 * Classe qui implémente une vue dans le cadre du MVC
 * @author sinteff3u
 *
 */
public class VueNbCoups extends JLabel implements Observer{
	
	/**
	 * constructeur pour une mise à 0
	 */
	public VueNbCoups(){
		this.setText("Nombre de coups joués: 0");
	}
	
	
	/**
	 * méthode appelée par notifyObervers() du modèle
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.setText("Nombre de coups joués: "+((Model)o).getNbCoups());
		
	}

}
