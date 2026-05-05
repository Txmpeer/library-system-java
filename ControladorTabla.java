// Julián Quiroz Ramírez 
// 29 de noviembre 2023
// Proyecto final Algortimos y Programas
import java.awt.Event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Scanner;
import java.util.Timer;
public class ControladorTabla extends VistaTabla{
	
	protected Biblioteca f1;
	// Todos los metodos excepto MostrarLibros y MostrarMembresias, aparecen 
	// en el JLabel Respuesta, los otros dos metodos se muestran en ScrollPane
	// Creamos el metodo de alta boton para poder asignarselo al boton
	public class AltaBoton implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String nombreL,genero,autor,n;
			double costo;
			boolean resp;
			nombreL = txtLibro.getText();
			genero = txtGenero.getText();
			autor = txtAutor.getText();
			n = txtCostoLibro.getText();
			costo = Double.parseDouble(n);
			resp=f1.altaLibro(nombreL, genero, autor, costo);
			if (resp) {
				lblRespuesta.setText("Se dio de alta exitosamente");
			}
			else {
				lblRespuesta.setText("No se dio de alta");
			}
		}
	}
	//Metodo baja boton con ActionLis para atribuirselo al boton
	public class bajaBoton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String nombreL;
			boolean resp;
			nombreL=txtLibro.getText();
			resp=f1.bajaLibro(nombreL);
			if (resp) {
				lblRespuesta.setText("El libro se dio de baja exitosamente");	
			}else {
				lblRespuesta.setText("El libro NO se dio de baja exitosamente");
			}
		}
	}
	//Metodo para comprar libros ocupando ActionListener
	public class compraBoton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String nombreL,clav;
			int claveU;
			boolean resp;
			nombreL = txtLibro.getText();
			clav = txtClaveU.getText();
			claveU = Integer.parseInt(clav);
			resp = f1.compraLibro(nombreL, claveU);
			if (resp)
				lblRespuesta.setText("Se compro el libro "+txtLibro.getText());
			else
				lblRespuesta.setText("No see compro el libro "+txtLibro.getText());
		}
	}
	// Metodo para la renta de libros ocupando ActionListener
	public class rentaBoton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String nombreL,clav;
			int claveU;
			boolean resp;
			nombreL = txtLibro.getText();
			clav = txtClaveU.getText();
			claveU = Integer.parseInt(clav);
			resp = f1.prestamo(nombreL, claveU);
			if (resp)
				lblRespuesta.setText("Se presto el libro");
			else
				lblRespuesta.setText("no se presto el libro");
		}
	}
	//Metodo para la devolucion de libros ocupando ActionListener
	public class devolucion implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean resp;
			String clav;
			int claveU;
			clav = txtClaveU.getText();
			claveU = Integer.parseInt(clav);
			resp=f1.devolucion(claveU);
			if(resp)
				lblRespuesta.setText("Se realizo la devolución");
			else
				lblRespuesta.setText("No se pudo realizar devolución");
		}
	}
	// Metodo para el alta membresia ocupando ActionListener
	public class AltaMem implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String nombre,ed,sal,clav;
			int edad,claveU;
			double saldo;
			boolean resp;
			nombre=txtNombreM.getText();
			ed=txtEdad.getText();
			sal=txtSaldo.getText();
			clav=txtClaveU.getText();
			edad=Integer.parseInt(ed);
			claveU=Integer.parseInt(clav);
			saldo=Double.parseDouble(sal);
			resp=f1.altaMembresias(nombre, edad, saldo, claveU);
			if(resp) {
				lblRespuesta.setText("La membresia se dio de alta");
			}else {
				lblRespuesta.setText("La membresia NO se dio de alta");
			}	
		}
	}
	// Metodo para limpiar los TextFields de nuestra vista al clickear 
	public class limpiar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			txtLibro.setText("");
			txtGenero.setText("");
			txtAutor.setText("");
			txtSaldo.setText("");
			txtEdad.setText("");
			txtClaveU.setText("");
			txtCostoLibro.setText("");
			txtNombreM.setText("");
			txtMembresia.setText("");
			areaCatalogo.setText("");
			lblRespuesta.setText("");
		}	
	}
	// Metodo para mostrar libros de la libreria presionando un boton
	// Este metodo a diferencia de otros, aparece en el ScrollBar
	public class verLibros implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			areaCatalogo.setText("");
			areaCatalogo.setText(f1.mostrarLibros());
		}
	}
	// Metodo para mostrar membresias de la libreria presionando boton
	// Este metodo a diferencia de otros, aparece en el ScrollBar
	public class verMembresias implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			areaCatalogo.setText("");
			areaCatalogo.setText(f1.mostrarMembresias());
		}
	}
	//Metodo para consultar el saldo de una membresia 
	public class consultaSaldo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String clav;
			int claveU;
			double saldo;
			clav = txtClaveU.getText();
			claveU = Integer.parseInt(clav);
			saldo = f1.consultaSaldo(claveU);
			lblRespuesta.setText("El saldo es: "+saldo);
		}
	}
	//Metodo para abonar saldo a una cuenta
	public class abonaSaldo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String clav,cash;
			int saldo,clavU;
			clav = txtClaveU.getText();
			clavU = Integer.parseInt(clav);
			cash = txtSaldo.getText();
			saldo = Integer.parseInt(cash);
			f1.cargarSaldo(clavU, saldo);
			lblRespuesta.setText("Se agrego la cantidad de "+saldo+" a tu cuenta");
		}
	}
	// Metodo para salir de la vista, es decir que cierre el programa
	public class salir implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(DISPOSE_ON_CLOSE);
		}
		
	}
	// Metodo para cargar la informacion de los archivos de texto anteriormente creados
	public void cargarInfo(Biblioteca f1) {
		// Se lee el archivo de texto libros.txt, el cual contiene libros ordenados de la sig manera:
		// nombre, genero, autor, costoLibro
		// Este metodo los ira leyendo de esa manera y los va a ir dando de alta
		String nombre,genero,autor,i;
		Scanner lectura;
		File archivo;
		archivo = new File ("libros.txt");
		double costoLibro;
		boolean resp;
		try {
			lectura = new Scanner (archivo);
			while (lectura.hasNextLine()) {
			nombre = lectura.nextLine();
			genero = lectura.nextLine();
			autor = lectura.nextLine();
			i = lectura.nextLine();
			costoLibro = Double.parseDouble(i);
			resp = f1.altaLibro(nombre, genero, autor, costoLibro);
			}
			} catch(Exception error) {
				System.err.println("Error al leer el archivo"+error.getMessage());
				}
		//Se lee el archivo de texto Membresias.txt el cual contiene membresias ordenadas de la sig manera:
		//ordendas por nombre,edad,saldo y clave unica.
		//Lo que hara es ir leyendo cada uno de los renglones hasta que se acaben e ir guardadndolas en la biblioteca
		File arch;
		arch = new File ("Membresias.txt");
		String nomb,p;
		boolean res;
		int edad,claveU;
		double saldo;
		try {
			lectura = new Scanner(arch);
			while (lectura.hasNextLine()) {
				nomb=lectura.nextLine();
				p=lectura.nextLine();
				edad=Integer.parseInt(p);
				p=lectura.nextLine();
				saldo=Double.parseDouble(p);
				p=lectura.nextLine();
				claveU=Integer.parseInt(p);
				res=f1.altaMembresias(nomb, edad, saldo, claveU);
			}
		}catch(Exception error) {
			System.err.println("ERROR"+error.getMessage());
		}
	}
	
	public ControladorTabla() {
		//Instancio mi biblioteca y además le asigno a cada uno de los botones
		// su respectivo metodo, con el ActionListener, para que al presionarlos
		// nos ejecute alguno de los metodos que se crearon arriba
		super();
		f1 = new Biblioteca ("Biblioteca ITAMITA","Rio Hondo 1");
		cargarInfo(f1);
		btAlta.addActionListener(new AltaBoton());
		btBaja.addActionListener(new bajaBoton());
		btCompra.addActionListener(new compraBoton());
		btRenta.addActionListener(new rentaBoton());
		btDevolucion.addActionListener(new devolucion());
		btMembresia.addActionListener(new AltaMem());
		btCatalogoL.addActionListener(new verLibros());
		btCatalogoM.addActionListener(new verMembresias());
		btConsultaSaldo.addActionListener(new consultaSaldo());
		btAbonarSaldo.addActionListener(new abonaSaldo());
		btSalir.addActionListener(new salir());
		btLimpiar.addActionListener(new limpiar());
		
	}
}