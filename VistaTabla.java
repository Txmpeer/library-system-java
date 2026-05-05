import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.GridLayout;
public class VistaTabla extends JFrame{
	private Biblioteca f1 = new Biblioteca ("Biblioteca itamita","Rio Hondo 1");
	protected JLabel lblLibro,lblGenero,lblAutor,lblCostoLibro,lblNombreM,lblEdad,lblSaldo,lblClaveU, lblClave, lblVacia,lblRespuesta,lblAlta,lblBaja, lblCompra,lblRenta,lblMembresia;
	protected JTextField txtSaldo,txtEdad,txtClaveU,txtGenero,txtAutor,txtCostoLibro,txtNombreM,txtLibro,txtClave,txtMembresia;
	protected JButton btLimpiar,btCatalogoL,btAceptar,btSalir,btCatalogoM,btAbonarSaldo,btConsultaSaldo,btMembresia,btDevolucion, btBuscar,btAlta,btBaja,btCompra,btRenta;
	protected Border miBorde;
	protected JPanel miPanel;
	protected JTextArea areaCatalogo;
	protected JScrollPane barrita;

	public VistaTabla() {
		//Creamos mi panel de 8 renglones x 4 columnas
		//Todo lo que vayamos agregando al panel se ira acomodando de tal manera que
		//que se llene el primer renglon, es decir 4 elementos por renglon que son las 4 columnas
		//Existen varios botones porque a estos, les asignaremos un metodo en el ControladorTabla
		//Ademas se trato de acomodar los botones de la manera más comoda posible porque
		//el boton mostrar libros y mostrar membresias, se encuentran en los costados del ScrollPane
		//Porque son los unicos dos que apareceran mostados ahi, ya que puede que tengan demasiada 
		//informacion como para ser mostrados en el JLabel Respuesta
		super("Libreria");
		miPanel = new JPanel (new GridLayout(8,4));
		miBorde = BorderFactory.createEmptyBorder(15,15,15,15);
		miPanel.setBorder(miBorde);
		
		lblLibro = new JLabel ("Nombre del libro: ");
		miPanel.add(lblLibro);
		txtLibro = new JTextField();
		miPanel.add(txtLibro);
		
		lblGenero = new JLabel("Genero del libro: ");
		miPanel.add(lblGenero);
		txtGenero = new JTextField();
		miPanel.add(txtGenero);
		
		lblAutor = new JLabel ("Autor del libro: ");
		miPanel.add(lblAutor);
		txtAutor = new JTextField();
		miPanel.add(txtAutor);
		
		lblCostoLibro = new JLabel ("Costo del libro: ");
		miPanel.add(lblCostoLibro);
		txtCostoLibro = new JTextField();
		miPanel.add(txtCostoLibro);
		
		lblNombreM = new JLabel ("Nombre del titular: ");
		miPanel.add(lblNombreM);
		txtNombreM = new JTextField ();
		miPanel.add(txtNombreM);
		
		lblEdad = new JLabel ("Edad del titular: ");
		miPanel.add(lblEdad);
		txtEdad = new JTextField ();
		miPanel.add(txtEdad);
		
		lblSaldo = new JLabel("Saldo: ");
		miPanel.add(lblSaldo);
		txtSaldo = new JTextField();
		miPanel.add(txtSaldo);
		
		lblClaveU = new JLabel ("Clave unica: ");
		miPanel.add(lblClaveU);
		txtClaveU = new JTextField();
		miPanel.add(txtClaveU);
		
		btAlta = new JButton ("Alta Libro");
		miPanel.add(btAlta);
		btBaja = new JButton ("Baja libro ");
		miPanel.add(btBaja);
		
		btCompra = new JButton ("Comprar");
		miPanel.add(btCompra);
		btRenta = new JButton ("Rentar");
		miPanel.add(btRenta);
		
		btDevolucion = new JButton ("Devolución");
		miPanel.add(btDevolucion);
		btMembresia = new JButton ("Alta Membresia");
		miPanel.add(btMembresia);
		
		btConsultaSaldo = new JButton ("Consulta saldo");
		miPanel.add(btConsultaSaldo);
		btAbonarSaldo = new JButton ("Abonar saldo");
		miPanel.add(btAbonarSaldo);
		
		btCatalogoL = new JButton ("Mostrar libros");
		miPanel.add(btCatalogoL);
		
		//ScrollBar que ocupe en los catalogos por si el catalogo es muy amplio
		
		areaCatalogo = new JTextArea (100,100);
		areaCatalogo.setLineWrap(true);
		areaCatalogo.setEditable(false);
		areaCatalogo.setVisible(true);
		miPanel.add(areaCatalogo);
		barrita = new JScrollPane(areaCatalogo);
		barrita.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		miPanel.add(barrita);
		
		btCatalogoM = new JButton ("Mostrar membresias");
		miPanel.add(btCatalogoM);
		btSalir = new JButton("Salir");
		miPanel.add(btSalir);
		
		btLimpiar = new JButton("Limpiar");
		miPanel.add(btLimpiar);
		lblRespuesta = new JLabel("");
		lblRespuesta.setBackground(Color.white);
		miPanel.add(lblRespuesta);
		
		
		
		miPanel.setBackground(Color.yellow);
		super.add(miPanel);
		super.setBounds(550,100,600,450);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible(true);
	}
}
