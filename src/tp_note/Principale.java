package tp_note;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Principale {

	public static void main(String[] args) {
		
		JPanel 			panneauSud;
		PanneauImages 	pims;
		JLabel 			nbCoups;
		JLabel		 	nbPaires;
		Border 			compound;
		JFrame frame=new JFrame("Memory MVC");
		

		/***********************************
		 * Création de l'instance de Model
		 **********************************/
		Model m = new Model();
		
		/**************************************
		 * Création de l'instance de Controler
		 *************************************/
		Controler c = new Controler(m);
		

		/**********************************
		* Création des bords des composants
		***********************************/
		Border raisedbevel 	= BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		compound 			= BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
			
	

		/********************************************************************
		* Le JPanel panneauSud du Sud qui s'ouvre à l'ouverture du jeu
		********************************************************************/
		panneauSud= new JPanel(new GridLayout(3,1));
		
		nbCoups=new VueNbCoups();
		nbCoups.setPreferredSize(new Dimension(605,55));
		nbCoups.setOpaque(true);
		nbCoups.setForeground(Color.blue);
		nbCoups.setBorder(compound);
		panneauSud.add(nbCoups);
	
		nbPaires=new VueNbPaires();
		nbPaires.setPreferredSize(new Dimension(605,55));
		nbPaires.setOpaque(true);
		nbPaires.setForeground(Color.blue);
		nbPaires.setBorder(compound);
		panneauSud.add(nbPaires);
		
		JPanel boutons;
		
		boutons = new JPanel();
		
		JButton rejouer = new ControlerBouton(m);
		
		JButton sortir = new JButton("Sortir");
		sortir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
			
		});
		
		boutons.add(rejouer);
		boutons.add(sortir);
		panneauSud.add(boutons);
		
		pims=new PanneauImages(m);
		pims.setPreferredSize(new Dimension(605,485));
		pims.setBorder(compound);
		
		/**********************************************
		 * Ajout du Controler dans les MouseListeners
		 *********************************************/
		pims.addMouseListener(c);
		
		/*********************************
		 * Ajout des vues à l'Observable
		 ********************************/
		m.addObserver(pims);
		m.addObserver((Observer) nbCoups);
		m.addObserver((Observer) nbPaires);
		
		/**************************************
		* Construction de l'IG dans une JFrame	
		***************************************/	 
		
		frame.getContentPane().setBackground(Color.BLUE);	 
		
		frame.getContentPane().add(pims,BorderLayout.CENTER);
		frame.getContentPane().add(panneauSud,BorderLayout.SOUTH);
		  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}

}
