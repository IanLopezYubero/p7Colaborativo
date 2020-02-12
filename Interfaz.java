import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
/**
 * @param Clase interfaz
 * @author Ian Lopez
 * @throws
 */
public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldLastName;
	private JTextField textFieldNif;
	private JTextField textFieldNss;
	private JTextField textFieldEuroHora;
	private JTextField textFieldHoras;

	/**
	 * Launch the application.
	 */
	//La clase main que arranca el programa
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	//El metodo para crear toda la interfaz visual
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(68, 13, 189, 22);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 16, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(285, 16, 56, 16);
		contentPane.add(lblApellidos);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(342, 13, 189, 22);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		JLabel lblNif = new JLabel("NIF:");
		lblNif.setBounds(12, 45, 56, 16);
		contentPane.add(lblNif);
		
		textFieldNif = new JTextField();
		textFieldNif.setBounds(45, 42, 116, 22);
		contentPane.add(textFieldNif);
		textFieldNif.setColumns(10);
		
		JLabel lblNss = new JLabel("NSS:");
		lblNss.setBounds(184, 48, 56, 16);
		contentPane.add(lblNss);
		
		textFieldNss = new JTextField();
		textFieldNss.setBounds(218, 45, 141, 22);
		contentPane.add(textFieldNss);
		textFieldNss.setColumns(10);
		
		JLabel lblTarifahora = new JLabel("Tarifa(\u20AC/hora):");
		lblTarifahora.setBounds(12, 77, 94, 16);
		contentPane.add(lblTarifahora);
		
		textFieldEuroHora = new JTextField();
		textFieldEuroHora.setBounds(106, 74, 116, 22);
		contentPane.add(textFieldEuroHora);
		textFieldEuroHora.setColumns(10);
		
		JLabel lblHorasTrabajadas = new JLabel("Horas trabajadas:");
		lblHorasTrabajadas.setBounds(259, 77, 109, 16);
		contentPane.add(lblHorasTrabajadas);
		
		textFieldHoras = new JTextField();
		textFieldHoras.setBounds(368, 74, 116, 22);
		contentPane.add(textFieldHoras);
		textFieldHoras.setColumns(10);
		
		JTextArea textAreaResul = new JTextArea();
		textAreaResul.setBounds(12, 194, 750, 384);
		contentPane.add(textAreaResul);
		
		JButton btnCalcularNmina = new JButton("CALCULAR N\u00D3MINA");
		btnCalcularNmina.addActionListener(new ActionListener() {
			//Metodo para realizar las acciones al presionar sobre el boton
			public void actionPerformed(ActionEvent e) {
				double salarioBase = (Double.parseDouble(textFieldEuroHora.getText().toString())) * (Double.parseDouble(textFieldHoras.getText().toString()));
				textAreaResul.append(textFieldName.getText().toString() + " " + textFieldLastName.getText().toString() + "\n");
				textAreaResul.append("Salario Base: " + String.valueOf(salarioBase) + "\n");
				
				if(Double.parseDouble(textFieldHoras.getText().toString()) >= 1 && Double.parseDouble(textFieldHoras.getText().toString()) <= 10) {
					double bonificacion = (salarioBase * 5)/100;
					textAreaResul.append("Bonificación: " + String.valueOf(bonificacion) + "\n");
					textAreaResul.append("Salario bruto: " + String.valueOf(bonificacion+salarioBase) + "\n");
					double retenciones = ((salarioBase+bonificacion) * 15)/100;
					textAreaResul.append("Retención: " + String.valueOf(retenciones) + "\n");
					double salarioNeto = (bonificacion+salarioBase)-retenciones;
					textAreaResul.append("Salario neto: " + String.valueOf(salarioNeto) + "\n");
				}else if(Double.parseDouble(textFieldHoras.getText().toString()) >= 11 && Double.parseDouble(textFieldHoras.getText().toString()) <= 20) {
					double bonificacion = (salarioBase * 10)/100;
					bonificacion = salarioBase + bonificacion;
					textAreaResul.append("Bonificación: " + String.valueOf(bonificacion) + "\n");
					textAreaResul.append("Salario bruto: " + String.valueOf(bonificacion+salarioBase) + "\n");
					double retenciones = ((salarioBase+bonificacion) * 15)/100;
					textAreaResul.append("Retención: " + String.valueOf(retenciones) + "\n");
					double salarioNeto = (bonificacion+salarioBase)-retenciones;
					textAreaResul.append("Salario neto: " + String.valueOf(salarioNeto) + "\n");
				}else if(Double.parseDouble(textFieldHoras.getText().toString()) > 20) {
					double bonificacion = (salarioBase * 30)/100;
					bonificacion = salarioBase + bonificacion;
					textAreaResul.append("Bonificación: " + String.valueOf(bonificacion) + "\n");
					textAreaResul.append("Salario bruto: " + String.valueOf(bonificacion+salarioBase) + "\n");
					double retenciones = ((salarioBase+bonificacion) * 15)/100;
					textAreaResul.append("Retención: " + String.valueOf(retenciones) + "\n");
					double salarioNeto = (bonificacion+salarioBase)-retenciones;
					textAreaResul.append("Salario neto: " + String.valueOf(salarioNeto) + "\n");
				}

				Sytem.out.println("Soy el segundo cambio de erick");

				Sytem.out.println("Soy el tercer cambio de erick");
				
				
				
			}
		});
		btnCalcularNmina.setBounds(259, 127, 154, 58);
		contentPane.add(btnCalcularNmina);
	}
}
