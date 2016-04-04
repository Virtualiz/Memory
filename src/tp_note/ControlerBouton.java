package tp_note;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * classe qui impl�mente le contr�lleur de l'architecture MVC
 * il permet de remettre � z�ro le mod�le quand le bouton est cliqu�, le mod�le notifie les vues
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
