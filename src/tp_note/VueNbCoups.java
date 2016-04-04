package tp_note;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

/**
 * Classe qui impl�mente une vue dans le cadre du MVC
 * @author sinteff3u
 *
 */
public class VueNbCoups extends JLabel implements Observer{
	
	/**
	 * constructeur pour une mise � 0
	 */
	public VueNbCoups(){
		this.setText("Nombre de coups jou�s: 0");
	}
	
	
	/**
	 * m�thode appel�e par notifyObervers() du mod�le
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.setText("Nombre de coups jou�s: "+((Model)o).getNbCoups());
		
	}

}
