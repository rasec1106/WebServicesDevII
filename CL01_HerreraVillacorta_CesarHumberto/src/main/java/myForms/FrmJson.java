package myForms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONObject;

import model.Product;
import util.JsonFormatter;
import util.JsonSerializer;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmJson extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdProducto;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JTextField txtEstado;
	private JTextArea txtSerializado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmJson frame = new FrmJson();
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
	public FrmJson() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SERIALIZACION JSON");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(42, 30, 218, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblIdProducto = new JLabel("ID PRODUCTO");
		lblIdProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdProducto.setBounds(42, 105, 168, 46);
		contentPane.add(lblIdProducto);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescripcion.setBounds(42, 160, 168, 46);
		contentPane.add(lblDescripcion);
		
		JLabel lblStock = new JLabel("STOCK");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStock.setBounds(42, 220, 168, 46);
		contentPane.add(lblStock);
		
		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(42, 270, 168, 46);
		contentPane.add(lblPrecio);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstado.setBounds(42, 330, 168, 46);
		contentPane.add(lblEstado);
		
		txtIdProducto = new JTextField();
		txtIdProducto.setBounds(220, 110, 140, 30);
		contentPane.add(txtIdProducto);
		txtIdProducto.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(220, 165, 140, 30);
		contentPane.add(txtDescripcion);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(220, 225, 140, 30);
		contentPane.add(txtStock);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(220, 275, 140, 30);
		contentPane.add(txtPrecio);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(220, 335, 140, 30);
		contentPane.add(txtEstado);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLimpiar(e);
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimpiar.setBounds(401, 151, 116, 46);
		contentPane.add(btnLimpiar);
		
		JButton btnSerializar = new JButton("Serializar");
		btnSerializar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnSerializar(e);
			}
		});
		btnSerializar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSerializar.setBounds(401, 237, 116, 46);
		contentPane.add(btnSerializar);
		
		txtSerializado = new JTextArea();
		txtSerializado.setBounds(570, 105, 375, 321);
		contentPane.add(txtSerializado);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnGrabar(e);
			}
		});
		btnGrabar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGrabar.setBounds(94, 421, 116, 46);
		contentPane.add(btnGrabar);
		
		JButton btnLeer = new JButton("Leer");
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLeer(e);
			}
		});
		btnLeer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLeer.setBounds(244, 421, 116, 46);
		contentPane.add(btnLeer);
	}
	
	// Obtiene los inputs de los txtField y devuelve un objeto Producto
	private Product readProduct() {
		Product product = new Product();
		product.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
		product.setDescripcion(txtDescripcion.getText());
		product.setStock(Integer.parseInt(txtStock.getText()));
		product.setPrecio(Integer.parseInt(txtPrecio.getText()));
		product.setEstado(txtEstado.getText());
		return product;
	}
	
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		txtIdProducto.setText("");
		txtDescripcion.setText("");
		txtStock.setText("");
		txtPrecio.setText("");
		txtEstado.setText("");
		txtSerializado.setText("");
		
		txtIdProducto.requestFocus();
	}	
	
	// Convierte a String el producto y lo muestra en el txtArea
	protected void actionPerformedBtnSerializar(ActionEvent e) {		
		Product product = readProduct();
		JSONObject json = product.convertToJson();
		txtSerializado.setText(JsonFormatter.jsonToString(json));
	}
	
	// Serializa el json y lo guarda en un archivo
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		Product product = readProduct();
		JsonSerializer.serializeJson(product.convertToJson());
	}
	
	// Lee desde el archivo y lo muestra en el txtArea
	protected void actionPerformedBtnLeer(ActionEvent e) {
		JSONObject json = JsonSerializer.deserializeJson();
		txtSerializado.setText(JsonFormatter.jsonToString(json));
	}
}
