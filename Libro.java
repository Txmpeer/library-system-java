// Julián Quiroz Ramírez 
// 29 de noviembre 2023
// Proyecto final Algortimos y Programas
public class Libro {
	//Atributos de la clase
	private String nombre;
	private String genero;
	private String autor;
	private double costoLibro;
	
	//Constructor 
	public Libro (String nombre, String genero, String autor,double costoLibro) {
		this.nombre=nombre;
		this.genero=genero;
		this.autor=autor;
		this.costoLibro=costoLibro;
	}
	
	//Getters y setters
	public String getNombre() {
		return nombre;
	}

	public String getGenero() {
		return genero;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public double getCostoLibro() {
		return costoLibro;
	}
	
	//Funcionalidad minima requerida
	public boolean equals (Libro otro) {
		boolean resp;
		if (nombre.equalsIgnoreCase(otro.nombre))
			resp=true;
		else
			resp=false;
		return resp;
	}
	
	public int compareTo (Libro otro) {
		int resp;
		if (nombre.equalsIgnoreCase(otro.nombre))
			resp=0;
		else
			if(nombre.compareToIgnoreCase(otro.nombre)>0)
				resp=1;
			else
				resp=-1;
		return resp;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder ();
		sb.append("El nombre del libro es: ").append(nombre);
		sb.append("\nSu genero es ").append(genero);
		sb.append("\nEl nombre del autor es ").append(autor).append(" y su costo es: ").append(costoLibro);
		return sb.toString();
	}


}
