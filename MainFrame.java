import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;


public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField extension;
	private JTextField correo;
	private Image img = ImageIO.read(new File("resources\\background2.png"));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public MainFrame() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\escarapela.png"));
		setTitle("Log In");

		Image dimg = img.getScaledInstance(360, 240, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		JLabel label = new JLabel(imageIcon);
		setContentPane(label);
		
		setBounds(100, 100, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(194, 31, 91, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Empleo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(48, 177, 135, 25);
		getContentPane().add(lblNewLabel_1_1);
		
		extension = new JTextField();
		extension.setFont(new Font("Tahoma", Font.PLAIN, 16));
		extension.setColumns(10);
		extension.setBounds(243, 131, 173, 25);
		getContentPane().add(extension);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Número de extensión");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(48, 129, 185, 27);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JComboBox<String> empleo = new JComboBox<String>();
		empleo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empleo.setModel(new DefaultComboBoxModel<String>(new String[] {"Teniente", "Capitán", "Comandante", "Teniente Coronel", "Coronel"}));
		empleo.setBounds(243, 178, 173, 25);
		getContentPane().add(empleo);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(173, 288, 112, 33);
		getContentPane().add(btnNewButton);
		
		JLabel errormsg = new JLabel("Rellene todos los campos");
		errormsg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		errormsg.setForeground(new Color(255, 0, 0));
		errormsg.setBounds(149, 234, 170, 25);
		getContentPane().add(errormsg);
		
		correo = new JTextField();
		correo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		correo.setColumns(10);
		correo.setBounds(243, 86, 173, 25);
		getContentPane().add(correo);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Correo corporativo");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1.setBounds(48, 86, 159, 27);
		getContentPane().add(lblNewLabel_1_1_1_1);
		errormsg.setVisible(false);
		
		btnNewButton.addActionListener((ActionListener) new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				
					try {
						if (!areEmptyFields()) {
							if (mailCorrect(correo.getText())) {
								String[] datos_personales = {correo.getText(),(String) empleo.getSelectedItem(),extension.getText()};
					            Form form = new Form(datos_personales, 1);
					            setVisible(false);
					            form.setVisible(true);
							}
							else {
								errormsg.setText("Correo inválido");
								errormsg.setVisible(true);
							}
						}
						else {
				        	errormsg.setVisible(true);
						}
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }  
			});  

	}
	
	private boolean areEmptyFields(){
		boolean empty = false;
			if (extension.getText().trim().isEmpty()) {
				empty = true;
			}
		return empty;
	}
	
	private boolean mailCorrect(String mail) {
		Pattern pattern=Pattern.compile("^[A-Z0-9]{7}+@+[A-Z.]+.es$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(mail);
		
		return matcher.find();
	}
}
