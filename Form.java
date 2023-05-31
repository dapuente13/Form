import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Component;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Box;

//Q:\Comun\CISPOC AGA\APP_Pilatus\Preguntas
//Q:\Comun\CISPOC AGA\APP_Pilatus\Imagenes

public class Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String dir;
	private String usr;
	private String preguntasFolder;
	private String imagesPreguntasFolder;
	private String imagesExplicacionFolder;
	
	private String[] datos_personales;
	
	private JTextField ans1;
	private JTextField ans2;
	private JTextField ans3;
	private JTextField ans4;
	private JTextField referencia;
	
	private JEditorPane pregunta;
	private JEditorPane explicacion;
	
	private JLabel lblNewLabel_1_2;
	private JLabel ruta_img_pregunta;
	private JLabel ruta_img_explicacion;
	
	private JComboBox<String> respuestac;
	private JComboBox<String> dificultad;
	
	private ButtonGroup G;
	private JRadioButton avion;
	private JRadioButton emergencia;
	
	private FileDialog fd_pregunta;
	private FileDialog fd_explicacion;
	//private Image background = ImageIO.read(new File("resources\\background2.png"));
	
	private int numpregunta = 0;
	
	private JPanel panel;
	private JPanel panelPregunta;
	private JPanel panelRespuestas;
	private JPanel panelExplicacion;

	public Form(String[] datos_personales, int npregunta) throws IOException{
		this.datos_personales = datos_personales;
		//Recopilar rutas
		getDirs();
		usr = this.datos_personales[0].substring(0, 7); // luisito
		dir = newestFile(usr); // preguntasFolder/luisito_X
		
		//Fondo de pantalla
		//Image dimg = background.getScaledInstance(360, 240, Image.SCALE_SMOOTH);
		
		//Design
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\escarapela.png"));
		setTitle("Pregunta "+numpregunta);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1024, 1024);
		setBounds(100, 100, 1024, 1024);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 30, 0};
		gridBagLayout.rowHeights = new int[]{55, 0, 30, 187, 30, 210, 30, 130, 0, 13, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel = new JPanel(gridBagLayout);

		//Formulario
		JLabel lblNewLabel_2 = new JLabel("Editor de preguntas");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		Frame frame = this;
		
		G = new ButtonGroup();
		
		GridBagLayout gridBagLayoutPregunta = new GridBagLayout();
		gridBagLayoutPregunta.columnWidths = new int[]{30, 188, 13, 142, 124, 148, 72, 6, 157, 17, 0, 0};
		gridBagLayoutPregunta.rowHeights = new int[] {124, 41, 22};
		gridBagLayoutPregunta.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayoutPregunta.rowWeights = new double[]{1.0, 0.0, 0.0};
		panelPregunta = new JPanel(gridBagLayoutPregunta);
		
		JLabel lblNewLabel_1 = new JLabel("Pregunta");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridheight = 3;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panelPregunta.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		pregunta = new JEditorPane();
		pregunta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JScrollPane scrollPanePregunta = new JScrollPane((Component) null);
		scrollPanePregunta.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPanePregunta = new GridBagConstraints();
		gbc_scrollPanePregunta.anchor = GridBagConstraints.WEST;
		gbc_scrollPanePregunta.fill = GridBagConstraints.BOTH;
		gbc_scrollPanePregunta.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPanePregunta.gridwidth = 7;
		gbc_scrollPanePregunta.gridx = 2;
		gbc_scrollPanePregunta.gridy = 0;
		panelPregunta.add(scrollPanePregunta, gbc_scrollPanePregunta);
		scrollPanePregunta.setViewportView(pregunta);
		//getContentPane().setLayout(gridBagLayout);
		
		ruta_img_pregunta = new JLabel("");
		ruta_img_pregunta.setHorizontalAlignment(SwingConstants.RIGHT);
		ruta_img_pregunta.setVisible(false);
		
		ruta_img_explicacion = new JLabel("");
		ruta_img_explicacion.setHorizontalAlignment(SwingConstants.RIGHT);
		ruta_img_explicacion.setVisible(false);
		
		GridBagConstraints gbc_ruta_img_pregunta = new GridBagConstraints();
		gbc_ruta_img_pregunta.fill = GridBagConstraints.HORIZONTAL;
		gbc_ruta_img_pregunta.insets = new Insets(0, 0, 5, 5);
		gbc_ruta_img_pregunta.gridwidth = 5;
		gbc_ruta_img_pregunta.gridx = 2;
		gbc_ruta_img_pregunta.gridy = 1;
		panelPregunta.add(ruta_img_pregunta, gbc_ruta_img_pregunta);
		
		JButton img_pregunta = new JButton("Imagen de enunciado");
		img_pregunta.setBackground(Color.WHITE);
		img_pregunta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_img_pregunta = new GridBagConstraints();
		gbc_img_pregunta.anchor = GridBagConstraints.EAST;
		gbc_img_pregunta.fill = GridBagConstraints.VERTICAL;
		gbc_img_pregunta.insets = new Insets(0, 0, 5, 5);
		gbc_img_pregunta.gridwidth = 2;
		gbc_img_pregunta.gridx = 7;
		gbc_img_pregunta.gridy = 1;
		panelPregunta.add(img_pregunta, gbc_img_pregunta);
		img_pregunta.addActionListener((ActionListener) new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				fd_pregunta = new FileDialog(frame, "Seleccione una imagen", FileDialog.LOAD);
				fd_pregunta.setFile("*.jpg;*.jpeg;*.png");
				fd_pregunta.setVisible(true);
		        ruta_img_pregunta.setText(fd_pregunta.getFile());
		        ruta_img_pregunta.setVisible(true);
		        }   
		    }); 
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.anchor = GridBagConstraints.NORTH;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 1;
		panel.add(separator, gbc_separator);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		GridBagConstraints gbc_horizontalGlue = new GridBagConstraints();
		gbc_horizontalGlue.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalGlue.gridx = 1;
		gbc_horizontalGlue.gridy = 2;
		panel.add(horizontalGlue, gbc_horizontalGlue);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tipo de pregunta:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridwidth = 2;
		gbc_lblNewLabel_1_1_1.gridx = 2;
		gbc_lblNewLabel_1_1_1.gridy = 2;
		panelPregunta.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		avion = new JRadioButton("Avión");
		avion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		avion.setSelected(true);
		GridBagConstraints gbc_avion = new GridBagConstraints();
		gbc_avion.fill = GridBagConstraints.HORIZONTAL;
		gbc_avion.insets = new Insets(0, 0, 5, 5);
		gbc_avion.gridx = 4;
		gbc_avion.gridy = 2;
		panelPregunta.add(avion, gbc_avion);
		G.add(avion);
		
		emergencia = new JRadioButton("Emergencia");
		emergencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_emergencia = new GridBagConstraints();
		gbc_emergencia.fill = GridBagConstraints.HORIZONTAL;
		gbc_emergencia.insets = new Insets(0, 0, 5, 5);
		gbc_emergencia.gridx = 5;
		gbc_emergencia.gridy = 2;
		panelPregunta.add(emergencia, gbc_emergencia);
		G.add(emergencia);
		
		GridBagConstraints gbc_panelPregunta = new GridBagConstraints();
		gbc_panelPregunta.fill = GridBagConstraints.VERTICAL;
		gbc_panelPregunta.insets = new Insets(0, 0, 5, 0);
		gbc_panelPregunta.gridx = 1;
		gbc_panelPregunta.gridy = 3;
		panel.add(panelPregunta, gbc_panelPregunta);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.BOTH;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 4;
		panel.add(separator_1, gbc_separator_1);
		
		GridBagLayout gridBagLayoutRespuestas = new GridBagLayout();
		gridBagLayoutRespuestas.columnWidths = new int[]{30, 188, 13, 142, 124, 148, 72, 6, 157, 17, 0, 0};
		gridBagLayoutRespuestas.rowHeights = new int[] {45, 45, 45, 45, 30};
		gridBagLayoutRespuestas.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayoutRespuestas.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panelRespuestas = new JPanel(gridBagLayoutRespuestas);
		
		JLabel lblNewLabel_1_1 = new JLabel("Respuestas");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridheight = 5;
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 0;
		panelRespuestas.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		ans1 = new JTextField();
		ans1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ans1.setColumns(10);
		GridBagConstraints gbc_ans1 = new GridBagConstraints();
		gbc_ans1.fill = GridBagConstraints.BOTH;
		gbc_ans1.insets = new Insets(0, 0, 5, 5);
		gbc_ans1.gridwidth = 6;
		gbc_ans1.gridx = 3;
		gbc_ans1.gridy = 0;
		panelRespuestas.add(ans1, gbc_ans1);
		
		ans2 = new JTextField();
		ans2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ans2.setColumns(10);
		GridBagConstraints gbc_ans2 = new GridBagConstraints();
		gbc_ans2.fill = GridBagConstraints.BOTH;
		gbc_ans2.insets = new Insets(0, 0, 5, 5);
		gbc_ans2.gridwidth = 6;
		gbc_ans2.gridx = 3;
		gbc_ans2.gridy = 1;
		panelRespuestas.add(ans2, gbc_ans2);
		
		ans3 = new JTextField();
		ans3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ans3.setColumns(10);
		GridBagConstraints gbc_ans3 = new GridBagConstraints();
		gbc_ans3.fill = GridBagConstraints.BOTH;
		gbc_ans3.insets = new Insets(0, 0, 5, 5);
		gbc_ans3.gridwidth = 6;
		gbc_ans3.gridx = 3;
		gbc_ans3.gridy = 2;
		panelRespuestas.add(ans3, gbc_ans3);
		
		ans4 = new JTextField();
		ans4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ans4.setColumns(10);
		GridBagConstraints gbc_ans4 = new GridBagConstraints();
		gbc_ans4.fill = GridBagConstraints.BOTH;
		gbc_ans4.insets = new Insets(0, 0, 5, 5);
		gbc_ans4.gridwidth = 6;
		gbc_ans4.gridx = 3;
		gbc_ans4.gridy = 3;
		panelRespuestas.add(ans4, gbc_ans4);
		
		respuestac = new JComboBox<String>();
		respuestac.setFont(new Font("Tahoma", Font.PLAIN, 16));
		respuestac.setBackground(new Color(255, 255, 255));
		respuestac.setModel(new DefaultComboBoxModel<String>(new String[] {"A", "B", "C", "D"}));
		GridBagConstraints gbc_respuestac = new GridBagConstraints();
		gbc_respuestac.anchor = GridBagConstraints.SOUTH;
		gbc_respuestac.fill = GridBagConstraints.HORIZONTAL;
		gbc_respuestac.insets = new Insets(0, 0, 5, 5);
		gbc_respuestac.gridx = 4;
		gbc_respuestac.gridy = 4;
		panelRespuestas.add(respuestac, gbc_respuestac);
		
		JLabel lblNewLabel = new JLabel("Dificultad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 4;
		panelRespuestas.add(lblNewLabel, gbc_lblNewLabel);
		
		dificultad = new JComboBox<String>();
		dificultad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dificultad.setBackground(new Color(255, 255, 255));
		dificultad.setModel(new DefaultComboBoxModel<String>(new String[] {"Fácil", "Normal", "Difícil"}));
		GridBagConstraints gbc_dificultad = new GridBagConstraints();
		gbc_dificultad.fill = GridBagConstraints.BOTH;
		gbc_dificultad.insets = new Insets(0, 0, 5, 5);
		gbc_dificultad.gridx = 8;
		gbc_dificultad.gridy = 4;
		panelRespuestas.add(dificultad, gbc_dificultad);
		
		JLabel lblNewLabel_4 = new JLabel("Respuesta correcta:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridwidth = 2;
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 4;
		panelRespuestas.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("A");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 0;
		panelRespuestas.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("B");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1.gridx = 2;
		gbc_lblNewLabel_3_1.gridy = 1;
		panelRespuestas.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("C");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3_2 = new GridBagConstraints();
		gbc_lblNewLabel_3_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_2.gridx = 2;
		gbc_lblNewLabel_3_2.gridy = 2;
		panelRespuestas.add(lblNewLabel_3_2, gbc_lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("D");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3_3 = new GridBagConstraints();
		gbc_lblNewLabel_3_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_3.gridx = 2;
		gbc_lblNewLabel_3_3.gridy = 3;
		panelRespuestas.add(lblNewLabel_3_3, gbc_lblNewLabel_3_3);
		
		GridBagConstraints gbc_panelRespuestas = new GridBagConstraints();
		gbc_panelRespuestas.fill = GridBagConstraints.VERTICAL;
		gbc_panelRespuestas.insets = new Insets(0, 0, 5, 0);
		gbc_panelRespuestas.gridx = 1;
		gbc_panelRespuestas.gridy = 5;
		panel.add(panelRespuestas, gbc_panelRespuestas);
		
		JSeparator separator_1_1 = new JSeparator();
		GridBagConstraints gbc_separator_1_1 = new GridBagConstraints();
		gbc_separator_1_1.fill = GridBagConstraints.BOTH;
		gbc_separator_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1_1.gridx = 1;
		gbc_separator_1_1.gridy = 6;
		panel.add(separator_1_1, gbc_separator_1_1);
		
		GridBagLayout gridBagLayoutExplicacion = new GridBagLayout();
		gridBagLayoutExplicacion.columnWidths = new int[]{188, 13, 142, 124, 148, 72, 6, 157, 0};
		gridBagLayoutExplicacion.rowHeights = new int[] {130, 41, 31};
		gridBagLayoutExplicacion.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayoutExplicacion.rowWeights = new double[]{0.0, 0.0, 0.0};
		panelExplicacion = new JPanel(gridBagLayoutExplicacion);
		
		lblNewLabel_1_2 = new JLabel("Explicación");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridheight = 2;
		gbc_lblNewLabel_1_2.gridx = 0;
		gbc_lblNewLabel_1_2.gridy = 0;
		panelExplicacion.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		explicacion = new JEditorPane();
		explicacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JScrollPane scrollPaneExplicacion = new JScrollPane(explicacion);
		scrollPaneExplicacion.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPaneExplicacion = new GridBagConstraints();
		gbc_scrollPaneExplicacion.anchor = GridBagConstraints.WEST;
		gbc_scrollPaneExplicacion.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneExplicacion.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneExplicacion.gridwidth = 7;
		gbc_scrollPaneExplicacion.gridx = 1;
		gbc_scrollPaneExplicacion.gridy = 0;
		panelExplicacion.add(scrollPaneExplicacion, gbc_scrollPaneExplicacion);
		
		GridBagConstraints gbc_ruta_img_explicacion = new GridBagConstraints();
		gbc_ruta_img_explicacion.fill = GridBagConstraints.BOTH;
		gbc_ruta_img_explicacion.insets = new Insets(0, 0, 5, 5);
		gbc_ruta_img_explicacion.gridwidth = 5;
		gbc_ruta_img_explicacion.gridx = 1;
		gbc_ruta_img_explicacion.gridy = 1;
		panelExplicacion.add(ruta_img_explicacion, gbc_ruta_img_explicacion);
		
		
		JButton img_explicacion = new JButton("Imagen de explicación");
		img_explicacion.setBackground(Color.WHITE);
		img_explicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_img_explicacion = new GridBagConstraints();
		gbc_img_explicacion.anchor = GridBagConstraints.EAST;
		gbc_img_explicacion.fill = GridBagConstraints.VERTICAL;
		gbc_img_explicacion.insets = new Insets(0, 0, 5, 0);
		gbc_img_explicacion.gridwidth = 2;
		gbc_img_explicacion.gridx = 6;
		gbc_img_explicacion.gridy = 1;
		panelExplicacion.add(img_explicacion, gbc_img_explicacion);
		img_explicacion.addActionListener((ActionListener) new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				fd_explicacion = new FileDialog(frame, "Seleccione una imagen", FileDialog.LOAD);
				fd_explicacion.setFile("*.jpg;*.jpeg;*.png");
				fd_explicacion.setVisible(true);
		        ruta_img_explicacion.setText(fd_explicacion.getFile());
		        ruta_img_explicacion.setVisible(true);
		        }   
		    }); 
		
		
		GridBagConstraints gbc_panelExplicacion = new GridBagConstraints();
		gbc_panelExplicacion.gridwidth = 2;
		gbc_panelExplicacion.fill = GridBagConstraints.VERTICAL;
		gbc_panelExplicacion.insets = new Insets(0, 0, 5, 0);
		gbc_panelExplicacion.gridy = 7;
		gbc_panelExplicacion.gridx = 0;
		panel.add(panelExplicacion, gbc_panelExplicacion);
		
		JLabel lblNewLabel_5 = new JLabel("Referencia");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 2;
		panelExplicacion.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		referencia = new JTextField();
		referencia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_referencia = new GridBagConstraints();
		gbc_referencia.gridwidth = 7;
		gbc_referencia.insets = new Insets(0, 0, 0, 5);
		gbc_referencia.fill = GridBagConstraints.BOTH;
		gbc_referencia.gridx = 1;
		gbc_referencia.gridy = 2;
		panelExplicacion.add(referencia, gbc_referencia);
		referencia.setColumns(10);
		Form form = this;
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 8;
		panel.add(verticalStrut, gbc_verticalStrut);
		
		JButton guardar_pregunta = new JButton("Revisar pregunta");
		guardar_pregunta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_guardar_pregunta = new GridBagConstraints();
		gbc_guardar_pregunta.fill = GridBagConstraints.VERTICAL;
		gbc_guardar_pregunta.insets = new Insets(0, 0, 5, 0);
		gbc_guardar_pregunta.gridx = 1;
		gbc_guardar_pregunta.gridy = 9;
		panel.add(guardar_pregunta, gbc_guardar_pregunta);
		guardar_pregunta.addActionListener((ActionListener) new ActionListener(){  
			public void actionPerformed(ActionEvent e){  			            				Review review;
				try {
					review = new Review(form);
					setVisible(false);
					review.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
			};					//Form form = new Form(datos_personales, numpregunta);		            //setVisible(false);		            //form.setVisible(true);

		        }  
		}); 
		
		JScrollPane scrollpane = new JScrollPane(panel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 10;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);
		getContentPane().add(scrollpane);
		
		repaint();
		
		// Acciones
			//Seleccionar Imagen
		//Frame frame = this;
		
			//Guardar Pregunta
		//Form form = this;
	}
	
	private void getDirs() {
		String line="";
		File file = new File(".config.txt");
		Scanner myReader;
		int count = 0;
		
		try {
			myReader = new Scanner(file);
			
			while (myReader.hasNextLine()) {
				line=myReader.nextLine();
				if (!line.isEmpty() && line.charAt(0) != '#' && count == 0) {
					preguntasFolder = line;
					count++;
				}
				else if (!line.isEmpty() && line.charAt(0) != '#' && count == 1) {
					imagesPreguntasFolder = line;
					count++;
				}
				else if (!line.isEmpty() && line.charAt(0) != '#' && count == 2) {
					imagesExplicacionFolder = line;
					count++;
				}
	        }
			/*if(!f_dir.isDirectory() || !f_dir.exists()) {
				//new File(dir).mkdirs();
			}*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String newestFile(String usr) {
		boolean found=false;
		int count=1;
		while (!found) {
			File file= new File(preguntasFolder+"\\"+usr+"_"+count+".txt");
			if (!file.exists()) {
				found=true;
			}
			else {
				count++;
			}
		}
		
		numpregunta = count;
		
		return preguntasFolder+"\\"+usr+"_"+count;
	}
	
	public String[] getDatosPersonales() {
		return datos_personales;
	}
	
	public String getDir() {
		return dir;
	}
	
	public int getNumPregunta(){
		return numpregunta;
	}
	public String getPregunta() {
		return pregunta.getText();
	}
	
	public String getTipoPregunta() {
		String tipo_pregunta="";
		if(avion.isSelected()) {
			tipo_pregunta="Avión";
		}
		else {
			tipo_pregunta="Emergencia";
		}
		
		return tipo_pregunta;
	}
	
	public String getA() {
		return ans1.getText();
	}
	
	public String getB() {
		return ans2.getText();
	}
	
	public String getC() {
		return ans3.getText();
	}
	
	public String getD() {
		return ans4.getText();
	}
	
	public String getRespuestaC() {
		return respuestac.getSelectedItem()+"";
	}
	
	public String getExplicacion() {
		return explicacion.getText();
	}
	
	public String getDificultad() {
		return dificultad.getSelectedItem()+"";
	}
	
	public String getImagePregunta() {
		String out="";
		if (ruta_img_pregunta.isVisible()) {
			out = fd_pregunta.getFile();
		}
		return out;
	}
	
	public String getImageExplicacion() {
		String out="";
		if (ruta_img_explicacion.isVisible()) {
			out = fd_explicacion.getFile();
		}
		return out;
	}
	
	public String getImagePreguntaDir() {
		return fd_pregunta.getDirectory();
	}
	
	public String getImageExplicacionDir() {
		return fd_explicacion.getDirectory();
	}
	
	public String getImagesPreguntasFolder() {
		return imagesPreguntasFolder;
	}
	
	public String getImagesExplicacionFolder() {
		return imagesExplicacionFolder;
	}
	
	public String getUsr() {
		return usr;
	}
	
	public String getReferencia() {
		return referencia.getText();
	}

}
