import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;

public class Review extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;

	Form _form;

	public Review(Form form) throws IOException{
		_form = form;
		
		//Design
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\escarapela.png"));
		setTitle("Pregunta "+form.getNumPregunta());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1700, 1024);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {52, 0, 26, 110, 0, 155, 11, 180, 0, 180, 26, 83, 0, 151, 20, 300, 0};
		gridBagLayout.rowHeights = new int[]{90, 170, -5, 30, 30, 30, 31, 13, 30, -2, 170, 0, 31, 9, 50, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel = new JPanel(gridBagLayout);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		panel.add(horizontalStrut, gbc_horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 1;
		gbc_horizontalStrut_1.gridy = 1;
		panel.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JTextArea pregunta = new JTextArea();
		pregunta.setWrapStyleWord(true);
		pregunta.setLineWrap(true);
		pregunta.setEditable(false);
		pregunta.setBackground(new Color(255, 255, 255));
		pregunta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pregunta.setText(_form.getPregunta());
		pregunta.setBounds(101, 142, 837, 148);
		GridBagConstraints gbc_pregunta = new GridBagConstraints();
		gbc_pregunta.fill = GridBagConstraints.BOTH;
		gbc_pregunta.insets = new Insets(0, 0, 5, 5);
		gbc_pregunta.gridwidth = 12;
		gbc_pregunta.gridx = 2;
		gbc_pregunta.gridy = 1;
		panel.add(pregunta, gbc_pregunta);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 14;
		gbc_horizontalStrut_3.gridy = 1;
		panel.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		JLabel img_pregunta = new JLabel("");
		GridBagConstraints gbc_img_pregunta = new GridBagConstraints();
		gbc_img_pregunta.insets = new Insets(0, 0, 5, 5);
		gbc_img_pregunta.gridx = 15;
		gbc_img_pregunta.gridy = 1;
		panel.add(img_pregunta, gbc_img_pregunta);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.gridwidth = 2;
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_2.gridx = 16;
		gbc_horizontalStrut_2.gridy = 1;
		panel.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 2;
		panel.add(verticalStrut, gbc_verticalStrut);
		
		JTextArea ans1 = new JTextArea();
		ans1.setWrapStyleWord(true);
		ans1.setLineWrap(true);
		ans1.setEditable(false);
		ans1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ans1.setText(_form.getA());
		ans1.setBounds(168, 333, 770, 30);
		GridBagConstraints gbc_ans1 = new GridBagConstraints();
		gbc_ans1.fill = GridBagConstraints.BOTH;
		gbc_ans1.insets = new Insets(0, 0, 5, 5);
		gbc_ans1.gridwidth = 11;
		gbc_ans1.gridx = 3;
		gbc_ans1.gridy = 3;
		panel.add(ans1, gbc_ans1);
		
		JTextArea ans2 = new JTextArea();
		ans2.setWrapStyleWord(true);
		ans2.setLineWrap(true);
		ans2.setEditable(false);
		ans2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ans2.setText(_form.getB());
		ans2.setBounds(168, 373, 770, 30);
		GridBagConstraints gbc_ans2 = new GridBagConstraints();
		gbc_ans2.fill = GridBagConstraints.BOTH;
		gbc_ans2.insets = new Insets(0, 0, 5, 5);
		gbc_ans2.gridwidth = 11;
		gbc_ans2.gridx = 3;
		gbc_ans2.gridy = 4;
		panel.add(ans2, gbc_ans2);
		
		JTextArea ans3 = new JTextArea();
		ans3.setWrapStyleWord(true);
		ans3.setLineWrap(true);
		ans3.setEditable(false);
		ans3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ans3.setText(_form.getC());
		ans3.setBounds(168, 413, 770, 30);
		GridBagConstraints gbc_ans3 = new GridBagConstraints();
		gbc_ans3.fill = GridBagConstraints.BOTH;
		gbc_ans3.insets = new Insets(0, 0, 5, 5);
		gbc_ans3.gridwidth = 11;
		gbc_ans3.gridx = 3;
		gbc_ans3.gridy = 5;
		panel.add(ans3, gbc_ans3);
		
		JTextArea ans4 = new JTextArea();
		ans4.setWrapStyleWord(true);
		ans4.setLineWrap(true);
		ans4.setEditable(false);
		ans4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ans4.setText(_form.getD());
		ans4.setBounds(168, 453, 770, 30);
		GridBagConstraints gbc_ans4 = new GridBagConstraints();
		gbc_ans4.fill = GridBagConstraints.BOTH;
		gbc_ans4.insets = new Insets(0, 0, 5, 5);
		gbc_ans4.gridwidth = 11;
		gbc_ans4.gridx = 3;
		gbc_ans4.gridy = 6;
		panel.add(ans4, gbc_ans4);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 7;
		panel.add(verticalStrut_2, gbc_verticalStrut_2);
		
		JTextPane tipo = new JTextPane();
		tipo.setEditable(false);
		tipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tipo.setText(_form.getTipoPregunta());
		tipo.setBounds(267, 536, 201, 30);
		GridBagConstraints gbc_tipo = new GridBagConstraints();
		gbc_tipo.fill = GridBagConstraints.BOTH;
		gbc_tipo.insets = new Insets(0, 0, 5, 5);
		gbc_tipo.gridx = 5;
		gbc_tipo.gridy = 8;
		panel.add(tipo, gbc_tipo);
		
		JLabel lblNewLabel_5_1 = new JLabel("Dificultad");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5_1.setBounds(642, 536, 85, 30);
		GridBagConstraints gbc_lblNewLabel_5_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_5_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_1.gridx = 11;
		gbc_lblNewLabel_5_1.gridy = 8;
		panel.add(lblNewLabel_5_1, gbc_lblNewLabel_5_1);
		
		JTextPane dificultad = new JTextPane();
		dificultad.setEditable(false);
		dificultad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dificultad.setText(_form.getDificultad());
		dificultad.setBounds(737, 536, 201, 30);
		GridBagConstraints gbc_dificultad = new GridBagConstraints();
		gbc_dificultad.fill = GridBagConstraints.BOTH;
		gbc_dificultad.insets = new Insets(0, 0, 5, 5);
		gbc_dificultad.gridx = 13;
		gbc_dificultad.gridy = 8;
		panel.add(dificultad, gbc_dificultad);
		
				
		JLabel lblNewLabel = new JLabel("Revisión");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(448, 46, 190, 44);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 18;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(126, 333, 20, 30);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 3;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("B");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(126, 373, 20, 30);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("C");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(126, 413, 20, 30);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 5;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("D");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(126, 453, 20, 30);
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 6;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de pregunta");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(101, 536, 156, 30);
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 8;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 9;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JTextArea explicacion = new JTextArea();
		explicacion.setWrapStyleWord(true);
		explicacion.setLineWrap(true);
		explicacion.setEditable(false);
		explicacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		explicacion.setText(_form.getExplicacion());
		explicacion.setBounds(101, 612, 837, 148);
		GridBagConstraints gbc_explicacion = new GridBagConstraints();
		gbc_explicacion.fill = GridBagConstraints.BOTH;
		gbc_explicacion.insets = new Insets(0, 0, 5, 5);
		gbc_explicacion.gridwidth = 12;
		gbc_explicacion.gridx = 2;
		gbc_explicacion.gridy = 10;
		panel.add(explicacion, gbc_explicacion);
		
		JLabel error = new JLabel("No se encontró la ruta especificada en el archivo .config");
		error.setForeground(new Color(255, 0, 0));
		error.setFont(new Font("Tahoma", Font.PLAIN, 16));
		error.setBounds(320, 834, 430, 43);
		error.setVisible(false);
		
		JLabel img_explicacion = new JLabel("");
		GridBagConstraints gbc_img_explicacion = new GridBagConstraints();
		gbc_img_explicacion.insets = new Insets(0, 0, 5, 5);
		gbc_img_explicacion.gridx = 15;
		gbc_img_explicacion.gridy = 10;
		panel.add(img_explicacion, gbc_img_explicacion);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 11;
		panel.add(verticalStrut_3, gbc_verticalStrut_3);
		
		JLabel lblNewLabel_6 = new JLabel("Referencia");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 3;
		gbc_lblNewLabel_6.gridy = 12;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JTextArea referencia = new JTextArea();
		referencia.setWrapStyleWord(true);
		referencia.setLineWrap(true);
		referencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		referencia.setEditable(false);
		referencia.setText(_form.getReferencia());
		GridBagConstraints gbc_referencia = new GridBagConstraints();
		gbc_referencia.gridwidth = 9;
		gbc_referencia.insets = new Insets(0, 0, 5, 5);
		gbc_referencia.fill = GridBagConstraints.BOTH;
		gbc_referencia.gridx = 5;
		gbc_referencia.gridy = 12;
		panel.add(referencia, gbc_referencia);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 13;
		panel.add(verticalStrut_4, gbc_verticalStrut_4);
		GridBagConstraints gbc_error = new GridBagConstraints();
		gbc_error.insets = new Insets(0, 0, 5, 0);
		gbc_error.fill = GridBagConstraints.BOTH;
		gbc_error.gridwidth = 7;
		gbc_error.gridx = 11;
		gbc_error.gridy = 14;
		panel.add(error, gbc_error);
		
		JButton volver = new JButton("Volver");
		volver.setFont(new Font("Tahoma", Font.PLAIN, 17));
		volver.setBounds(322, 795, 182, 40);
		GridBagConstraints gbc_volver = new GridBagConstraints();
		gbc_volver.fill = GridBagConstraints.HORIZONTAL;
		gbc_volver.insets = new Insets(0, 0, 5, 5);
		gbc_volver.gridx = 7;
		gbc_volver.gridy = 14;
		panel.add(volver, gbc_volver);
		
		volver.addActionListener((ActionListener) new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				setVisible(false);	
				form.setVisible(true);
				dispose();
		        }  
		    }); 
		
		JButton guardar = new JButton("Guardar pregunta");
		guardar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		guardar.setBounds(528, 795, 182, 40);
		GridBagConstraints gbc_guardar = new GridBagConstraints();
		gbc_guardar.anchor = GridBagConstraints.WEST;
		gbc_guardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_guardar.insets = new Insets(0, 0, 5, 5);
		gbc_guardar.gridx = 9;
		gbc_guardar.gridy = 14;
		panel.add(guardar, gbc_guardar);
		
		guardar.addActionListener((ActionListener) new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
					save(form, error);
					try {
						Form newForm = new Form(form.getDatosPersonales(), form.getNumPregunta());
						newForm.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }  
		    }); 
		if (form.getRespuestaC().equals("A")) {	ans1.setBackground(Color.green); }
		if (form.getRespuestaC().equals("B")) { ans2.setBackground(Color.GREEN); }
		if (form.getRespuestaC().equals("C")) { ans3.setBackground(Color.GREEN); }
		if (form.getRespuestaC().equals("D")) { ans4.setBackground(Color.GREEN); }
		
		if (form.getImagePregunta() != "" && form.getImagePregunta() != null) {
			draw_image(form.getImagePregunta(), form.getImagePreguntaDir(), img_pregunta);
		}
		if (form.getImageExplicacion() != "" && form.getImageExplicacion() != null) {
			draw_image(form.getImageExplicacion(), form.getImageExplicacionDir(), img_explicacion);
		}		

		addWindowListener((WindowListener) new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	int out=JOptionPane.showConfirmDialog(null, "¿Desea guardar las preguntas?", "¡Cuidado!", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
            	if (out==0) {
            		save(form, error);
                }
            }
        });

		JScrollPane scrollpane = new JScrollPane(panel);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.gridheight = 2;
		gbc_verticalStrut_5.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_5.gridx = 0;
		gbc_verticalStrut_5.gridy = 15;
		panel.add(verticalStrut_5, gbc_verticalStrut_5);
		getContentPane().add(scrollpane);
	}
	
	private void draw_image(String file_name, String fileDir, JLabel img_label) throws IOException {
		BufferedImage myPicture = ImageIO.read(new File(fileDir+file_name));
		Image scaled;
		
		if (myPicture.getWidth() > myPicture.getHeight()) {
			scaled = myPicture.getScaledInstance(300,  myPicture.getHeight()*300/myPicture.getWidth(),Image.SCALE_SMOOTH);
		}
		else {
			scaled = myPicture.getScaledInstance(myPicture.getWidth()*300/myPicture.getHeight(), 300,Image.SCALE_SMOOTH);
		}
		
		img_label.setIcon(new ImageIcon(scaled));
		
	}
	
	private void save(Form form, JLabel error) {
		File file = new File(form.getDir()+".txt"); //creamos un objeto de fichero txt
		try {
			FileWriter fw= new FileWriter(file);
			savePregunta(fw, form.getDatosPersonales());
			fw.close();
			if (form.getImagePregunta() != "") {
				String extension = form.getImagePregunta().substring(form.getImagePregunta().lastIndexOf('.') + 1);
				saveImage("p_"+form.getUsr()+"_"+form.getNumPregunta()+"."+extension, form.getImagesPreguntasFolder(), form.getImagePreguntaDir(), form.getImagePregunta());
			}
			if (form.getImageExplicacion() != "") {
				String extension = form.getImageExplicacion().substring(form.getImageExplicacion().lastIndexOf('.') + 1);
				saveImage("e_"+form.getUsr()+"_"+form.getNumPregunta()+"."+extension, form.getImagesExplicacionFolder(), form.getImageExplicacionDir(), form.getImageExplicacion());
			}
			form.dispose();
            setVisible(false);
            dispose();
		} catch (IOException e1) {
			error.setVisible(true);
			e1.printStackTrace();
		}
	}
	
	private void savePregunta(FileWriter _fw, String[] datos_personales) throws IOException {	
		_fw.write(datos_personales[0]+"|");
		_fw.write(datos_personales[1].toLowerCase()+"|");
		_fw.write(datos_personales[2]+"|");
		_fw.write(_form.getPregunta()+"|");
		_fw.write(_form.getTipoPregunta()+"|");
		_fw.write(_form.getA()+"|");
		_fw.write(_form.getB()+"|");
		_fw.write(_form.getC()+"|");
		_fw.write(_form.getD()+"|");
		_fw.write(_form.getRespuestaC().toLowerCase()+"|");
		_fw.write(_form.getExplicacion()+"|");
		_fw.write(_form.getReferencia()+"|");
		_fw.write(_form.getDificultad().toLowerCase()+"\n");
	}
	
	private void saveImage(String name, String dst_dir, String imageDir, String imageFile) {
		File f_dir = new File(dst_dir);
		if(!f_dir.isDirectory() || !f_dir.exists()) {
			new File(dst_dir).mkdirs();
		}
        Path src = Paths.get(imageDir+imageFile);
        Path dst = Paths.get(dst_dir+"\\"+name);
        try {
			Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
