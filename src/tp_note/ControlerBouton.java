package tp_note;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * classe qui implémente le contrôlleur de l'architecture MVC
 * il permet de remettre à zéro le modèle quand le bouton est cliqué, le modèle notifie les vues
 * @author sinteff3u
 *
 */
public class ControlerBouton extends JButton{
	
	private Model m;
	
	public ControlerBouton(Model model){
		super();
		this.setText("Rejouer");
		m=model;
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				m.init();
				
			}
			
		});
	}
	
}
