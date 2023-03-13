package pruebaVentana;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class Ventana extends JFrame {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane tabedPane = new JTabbedPane();
		tabedPane.add("Cursos", new VentanaGestionCurso());

		this.setContentPane(tabedPane);		
	}

}
