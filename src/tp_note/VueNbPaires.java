package tp_note;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
/**
 * Classe qui impl�mente une vue dans le cadre d'une architecture MVC
 * @author sinteff3u
 *
 */
public class VueNbPaires extends JLabel implements Observer{
	
	/**
	 * Constructeur de la vue
	 */
	public VueNbPaires(){
		this.setText("Nombre de paires d�couvertes: 0");
	}
	
	/**
	 * m�thode appel�e par notifyObervers() du mod�le
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.setText("Nombre de paires d�couvertes: "+((Model)o).getNbPaires());
		
	}

}
