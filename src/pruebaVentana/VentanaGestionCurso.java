package pruebaVentana;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.ControladorCurso;
import controllers.ControladorMateria;
import models.Curso;
import models.Materia;
import utils.CacheImagenes;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class VentanaGestionCurso extends JPanel {
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;
	private JComboBox<Curso> jcbcurso;
	private JComboBox<Materia> jcbmateria;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JTextField textField_1;
	private JCheckBox chckbxNewCheckBox;
	private JTextField textField_2;
	private JButton btnNewButton_2;
	private String TITULO_APLICACION = "MAmalon";

	private CacheImagenes cacheImagenes;
	private JPasswordField passwordField;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JPasswordField passwordField_1;
	private JButton btnconfoto;
	private JButton btnNewButton_5;

	/**
	 * Create the frame.
	 */
	public VentanaGestionCurso() {
		cacheImagenes = new CacheImagenes();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblNewLabel_2 = new JLabel("Gestión de Cursos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 50));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 3;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 20, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		lblNewLabel_1 = new JLabel("Curso");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbcurso = new JComboBox<Curso>();
		GridBagConstraints gbc_jcbcurso = new GridBagConstraints();
		gbc_jcbcurso.insets = new Insets(0, 0, 5, 5);
		gbc_jcbcurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbcurso.gridx = 1;
		gbc_jcbcurso.gridy = 1;
		add(jcbcurso, gbc_jcbcurso);

		btnNewButton = new JButton("Seso");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarmateriassssssss();

			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);

		lblNewLabel = new JLabel("Materia");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		jcbmateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbmateria = new GridBagConstraints();
		gbc_jcbmateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbmateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbmateria.gridx = 1;
		gbc_jcbmateria.gridy = 2;
		add(jcbmateria, gbc_jcbmateria);

		btnNewButton_1 = new JButton("Agwuallio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leerjcombosentexfielses();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 2;
		add(btnNewButton_1, gbc_btnNewButton_1);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		chckbxNewCheckBox = new JCheckBox("New check box");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 5;
		add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 6;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		btnNewButton_2 = new JButton("jpane");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String posiblesRespuestas[] = { "Sí", "No", "tal vez", "awuayin" };
				// En esta opción se utiliza un showOptionDialog en el que personalizo el icono
				// mostrado
				int opcionElegida = JOptionPane.showInternalOptionDialog(null, "joption mamadisimo", TITULO_APLICACION,
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, cacheImagenes.getIcono("confirm.png"),
						posiblesRespuestas, posiblesRespuestas[3]);

				if (opcionElegida == 0) {
					System.exit(0);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 7;
		add(btnNewButton_2, gbc_btnNewButton_2);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 8;
		add(passwordField, gbc_passwordField);

		btnNewButton_3 = new JButton("validate tu");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validation();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 9;
		add(btnNewButton_3, gbc_btnNewButton_3);
		
		btnNewButton_4 = new JButton("correo ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (esCorreo(passwordField_1.getText())) {
					System.out.println("Manol");
				}else {
					System.out.println("Adri");
				}
				
			}
		});
		
		passwordField_1 = new JPasswordField();
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.gridx = 1;
		gbc_passwordField_1.gridy = 10;
		add(passwordField_1, gbc_passwordField_1);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 11;
		add(btnNewButton_4, gbc_btnNewButton_4);
		
		btnNewButton_5 = creaBoton("", "confirm.png", "");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 12;
		add(btnNewButton_5, gbc_btnNewButton_5);
		


//		llenarJcb();

	}
	
	private JButton creaBoton(String titulo, String icono, String toolTip) {
        JButton jbt = new JButton();
        
        jbt.setText(titulo);
        jbt.setToolTipText(toolTip);
        
        jbt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Has hecho clic en el botón: \"" + toolTip + "\"");
            }
        });
        
        try {
        	jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));  
          } catch (Exception ex) {
        	  ex.printStackTrace();
          }
        return jbt;
	}
	
	
	
	public boolean esCorreo(String correo) {
        Pattern patron = Pattern.compile("[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}");
        
        Matcher comparar = patron.matcher(correo);
        return comparar.find();
    }

	private void validation() {
		String str = passwordField.getText();
		str.trim();
		int contMayus = 0, contMinus = 0, contNum = 0, contNoAlfa = 0;
		String str1[] = str.split("[ ]{1,}");
		for (int i = 0; i < str1.length; i++) {
			char[] letra = str1[i].toCharArray();
			contMayus = 0;
			contMinus = 0;
			contNum = 0;
			contNoAlfa = 0;
			for (int j = 0; j < letra.length; j++) {
				if (Character.isUpperCase(letra[j]))
					contMayus++;
				if (Character.isLowerCase(letra[j]))
					contMinus++;
				if (Character.isDigit(letra[j]))
					contNum++;
				if (!Character.isLetterOrDigit(letra[j]))
					contNoAlfa++;
			}
			if (contMayus > 0 && contMinus > 1 && contNum > 0 && contNoAlfa > 0)
				System.out.println("Las palabras que contienen los requisitos son: " + str1[i]);
			else
				System.out.println("La palabra " + str1[i] + " no cumple con los requisitos.");
		}
	}

	private void llenarJcb() {
		List<Curso> lc = ControladorCurso.findAll();
		for (Curso curso : lc) {
			jcbcurso.addItem(curso);
		}
	}

	private void cargarmateriassssssss() {
		Curso c = (Curso) jcbcurso.getSelectedItem();
		List<Materia> lc = ControladorMateria.cargarMaterias(c.getId());

		try {
			jcbmateria.removeAllItems();
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (Materia materia : lc) {
			jcbmateria.addItem(materia);
		}

	}

	private void leerjcombosentexfielses() {
		Materia m = (Materia) jcbmateria.getSelectedItem();
		textField.setText(m.getNombre());
		textField_1.setText(m.getAcronimo());
		chckbxNewCheckBox.setSelected(m.isAprobado());
		textField_2.setText(new SimpleDateFormat("dd/MM/yyyy").format(m.getFecha()));
		passwordField.setText(m.getContrasenia());
	}

}
