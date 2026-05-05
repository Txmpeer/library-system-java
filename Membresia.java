// Julián Quiroz Ramírez 
// 29 de noviembre 2023
// Proyecto final Algortimos y Programas
import java.util.ArrayList;
public class Membresia {
	
	//Atributos de la clase
	private String nombre;
	private int edad;
	private double saldo;
	private int claveU;
	private Libro[] arr;
	private ArrayList <Libro> arre;
	private final int MAP=1;
	
	//Constructor
	public Membresia (String nombre, int edad,double saldo, int claveU) {
		saldo=0;
		arr = new Libro[MAP];
		this.claveU=claveU;
		this.edad=edad;
		this.nombre=nombre;
		this.arr=arr;
		this.arre=arre;
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public int getClaveU() {
		return claveU;
	}
	
	public Libro getLibroRenta() {
		return arr[0];
	}
	
	public void setLibroRenta(Libro lib) {
		arr[0]=lib;
	}
	
	public void setLibroCompra(Libro lib) {
		arre.add(lib);
	}
	
	//Funcionalidad minima requerida
	public boolean equals(Membresia otro) {
		boolean resp;
		if (claveU == otro.claveU)
			resp=true;
		else
			resp=false;
		return resp;
	}
	
	public int compareTo(Membresia otro) {
		int resp;
		if (claveU == otro.claveU)
			resp=0;
		else
			if (claveU > otro.claveU)
				resp=1;
			else
				resp=-1;
		return resp;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder ();
		sb.append("El dueño de la membresia es ").append(nombre).append(" y tiene ").append(edad).append(" años");
		sb.append("\nLa clave de la membresia es ").append(claveU).append("y su saldo es de ").append(saldo);
		sb.append("Los libros prestados son : ").append(arr);
		sb.append("\nLos libros comprados son: ").append(arre);
		return sb.toString();
	}
	
	//Funcionalidad de la clase
	public void setSaldo(double a) {
		this.saldo=a;
	}
}
