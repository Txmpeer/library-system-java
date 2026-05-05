// Julián Quiroz Ramírez 
// 29 de noviembre 2023
// Proyecto final Algortimos y Programas
import java.io.File;
import java.util.Scanner;

public class Biblioteca {
	//Atributos de la clase
	private String direccion;
	private String nombre;
	private Libro [] libros; //arreglo donde guardare libros
	private Membresia [] membresias; //arreglo para guardar membresias
	private final int MAX = 20;
	private int contador;
	private int contadorM;
	
	//Constructor
	public Biblioteca (String nombre, String direccion) {
		libros = new Libro[MAX];
		membresias = new Membresia[MAX];
	    contador = 0;
	    contadorM = 0;
		this.nombre=nombre;
		this.direccion=direccion;
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public Libro[] getLibros() {
		return libros;
	}

	public Membresia[] getMembresias() {
		return membresias;
	}

	//Metodo para dar de alta un libro con su contador
	public boolean altaLibro(String nombre, String genero,String autor,double costoLibro) {
		boolean resp;
		resp=false;
		if (contador<MAX) {
			libros[contador] = new Libro(nombre,genero,autor,costoLibro);
			contador++;
			resp=true;
			ordenaLibros(); //Metodo para ordenar alfabeticamente
		}
		if(resp==true)
			System.out.println("se dio de alta exitosamente");
		else
			System.out.println("no se dio de alta");
		return resp;
	}
	
	//Metodo para ordenar los libros de manera alfabetica
	public void ordenaLibros() {
	    int n = contador;
	    boolean intercambiado;
	    do {
	        intercambiado = false;
	        for (int i = 1; i < n; i++) {
	            if (this.libros[i - 1].getNombre().compareTo(this.libros[i].getNombre()) > 0) {
	                Libro temp = libros[i - 1];
	                libros[i - 1] = libros[i];
	                libros[i] = temp; // Corregir aquí para mantener el valor temporal
	                intercambiado = true;
	            }
	        }
	        n--;
	    } while (intercambiado);
	}
	
	//Metodo donde da de baja un libro, buscandolo por su nombre y recorriendo si hay lugar vacio
	public boolean bajaLibro(String nombre) {
		boolean resp;
		int i;
		i=0;
		while (!libros[i].getNombre().equalsIgnoreCase(nombre)) {
			i++;
		}
		if (i==contador)
			resp=false;
		else {
			libros[i]=null;
			for (int j=i;j<contador;j++) {
				libros[j]=libros[j+1];
				contador--;
				}
			resp=true;
			}
		if(resp==true)
			System.out.println("se dio de baja exitosamente");
		else
			System.out.println("no se dio de baja");
		return resp;
		}
	
	//Metodo para dar de alta las membresias 
	public boolean altaMembresias(String nombre,int edad,double saldo,int claveU) {
		boolean resp;
		resp=false;
		if (contadorM<MAX) {
			membresias[contadorM] = new Membresia(nombre,edad,saldo,claveU);
			contadorM++;
			resp=true;
			ordenaMembresias(); //Metodo para ordenar alfabeticamente
		}
		if(resp==true)
			System.out.println("se dio de alta exitosamente");
		else
			System.out.println("no se dio de alta");
		return resp;
	}
	
	//Metodo para ir ordenando las membresias en lo que vas dando de alta
	public void ordenaMembresias() {
	    int n = contadorM;
	    boolean intercambiado;
	    do {
	        intercambiado = false;
	        for (int i = 1; i < n; i++) {
	            if (this.membresias[i - 1].getNombre().compareTo(this.membresias[i].getNombre()) > 0) {
	                Membresia temp = membresias[i - 1];
	                membresias[i - 1] = membresias[i];
	                membresias[i] = temp; 
	                intercambiado = true;
	            }
	        }
	        n--;
	    } while (intercambiado);
	}
	
	//Metodo para dar de baja las membresias y recorrer si hay lugar vacio
	public boolean bajaMembresias(int claveU) {
		boolean resp;
		int i;
		i=0;
		while (membresias[i].getClaveU()!=claveU)
			i++;
		if (contadorM==i)
			resp=false;
		else {
			membresias[i]=null;
			for (int j=i;j<contadorM;j++) 
				membresias[j]=membresias[j+1];
			contadorM--;
			resp=true;
		}
		if(resp==true)
			System.out.println("se pudo dar de baja exitosamente");
		else
			System.out.println("no se pudo dar de baja");
		return resp;
	}
	
	//metodo para revisar si la membresia ya esta registrada en el sistema
	public boolean membresiaRegistrada(int claveU) {
		boolean resp;
		int i;
		i=0;
		while (membresias[i].getClaveU()!=claveU)
			i++;
		if(i==contadorM)
			resp=false;
		else 
			resp=true;
		if(resp==true)
			System.out.println("si está registrado");
		else
			System.out.println("no está registrado");
		return resp;
	}
	
	//metodo para mostrar la información de las membresias
	public String mostrarMembresias() {
		StringBuilder sb = new StringBuilder ();
		for (int i=0;i<contadorM;i++)
			sb.append(membresias[i].getNombre()).append(" "+membresias[i].getClaveU()).append(",");
		return sb.toString();
			
	}
	
	//metodo para mostrar la información de los libros
	public String mostrarLibros() {
		StringBuilder sr = new StringBuilder ();
		for (int i=0;i<contador;i++) {
			sr.append(libros[i].getNombre()).append(", ");
		}
		return sr.toString();
	}
	
	//metodo para comprar un libro, por la clave unica de la membresia
	public boolean compraLibro(String nombreLibro, int claveU) {
	    boolean resp;
	    double a;
	    int i,j;
	    i=0;
	    j=0;
	    while (claveU!=membresias[j].getClaveU())
	    	j++;
	    while (libros[i]!=null && !libros[i].getNombre().equalsIgnoreCase(nombreLibro))
	    	i++;
	    if (i==contador)
	    	resp=false;
	    else {
	    	a=membresias[j].getSaldo()-libros[i].getCostoLibro();
	    	if (a>0) {
	    		membresias[j].setSaldo(a);
	    		membresias[j].setLibroCompra(libros[i]);
	    		resp=true;
	    	}
	    	else
	    		resp=false;
	    }
	    if (resp==true)
	    	System.out.println("la compra se realizo exitosamente");
	    else
	    	System.out.println("no se pudo realizar la compra");
	    return resp;
	}
	
	//metodo para que presten un libro, tomando en cuenta que al prestarlo ya no estará disponible para otras personas
	public boolean prestamo(String nombre,int claveU) {
		boolean resp;
		int i,j;
		resp=false;
		j=0;
		i=0;
		while(!libros[i].getNombre().equals(nombre))
			i++;
		while(membresias[j].getClaveU()!=claveU)
			j++;
		if (j==contador)
			resp=false;
		else {
			membresias[j].setLibroRenta(libros[i]);
			int p=i;
			bajaLibro(libros[i].getNombre());
			resp=true;
		}
		if(resp==true)
			System.out.println("se aprobo el prestamo");
		else
			System.out.println("se rechazo el prestamo");
		return resp;
	}
	
	//metodo para regresar el libro del que se habia solicitado prestamo, otra vez está dispoonible para otras personas
	public boolean devolucion(int claveU) {
		boolean resp;
		int j;
		j=0;
		while (membresias[j].getClaveU()!=claveU)
			j++;
		resp=altaLibro(membresias[j].getLibroRenta().getNombre(),membresias[j].getLibroRenta().getGenero(),membresias[j].getLibroRenta().getAutor(),membresias[j].getLibroRenta().getCostoLibro());
		return resp;
	}
	
	//metodo para buscar un libro a traves de su nombre
	public Libro buscaLibro(String nombre) {
		for (int i=0;i<contador;i++) {
			Libro A = libros[i];
			if (A!=null && A.getNombre().equalsIgnoreCase(nombre))
				return A;
		}
		return null;
	}
	
	//metodo para consultar el saldo disponible ne una cuenta a partir de su clave unica
	public double consultaSaldo(int claveU) {
		int j;
		j=0;
		while (membresias[j].getClaveU()!=claveU) {
			j++;
		}
		return membresias[j].getSaldo();
	}
	
	//metodo para poder cargarle saldo a una cuenta a partir de su clave unica
	public void cargarSaldo(int claveU,double saldo) {
		int j;
		j=0;
		while(membresias[j].getClaveU()!=claveU)
			j++;
		membresias[j].setSaldo(membresias[j].getSaldo()+saldo);
	}
	
	//Funcionalidad minima requerida 
	public boolean equals (Biblioteca otro) {
		boolean resp;
		if (direccion.equalsIgnoreCase(otro.direccion))
			resp=true;
		else
			resp=false;
		return resp;
	}
	
	public int compareTo(Biblioteca otro) {
		int resp;
		if (direccion.equalsIgnoreCase(otro.direccion))
			resp=0;
		else
			if (direccion.compareTo(otro.direccion)>0)
				resp=1;
			else
				resp=-1;
		return resp;
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		sb.append("El nombre de la libreria es ").append(nombre).append(" y se encuentra ubicada en ").append(direccion);
		for (int i=0;i<contador;i++)
			sb.append(libros[i].toString());
		return sb.toString();
	}
	

}
