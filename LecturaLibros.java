// Julián Quiroz Ramírez 
// 29 de noviembre 2023
// Proyecto final Algortimos y Programas
import java.io.File;
import java.util.Scanner;

public class LecturaLibros {
	// Esta clase, está hecha unicamente para probar los metodos elaborados en la clase Biblioteca
	public static void main(String[] args) {
		//Se lee el archivo de texto libros.txt el cual contiene libros ordenados de la sig manera:
		// ordenados por nombre,genero,autor y costo libro.
		//Lo que hará es ir leyend cada uno de los renglones hasta que se acaben e ir guardandolos en la biblioteca
		Biblioteca f1 = new Biblioteca ("Biblioteca ITAMITA","Rio Hondo 1");
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
		System.out.println(f1.mostrarLibros());
		System.out.println(f1.mostrarMembresias());
		Scanner lectur;
		lectur = new Scanner(System.in);
		int opcion;
		opcion=0;
		//Ocupamos un do while para correr nuestro menu del programa siempre que el número que ingresemos sea distinto del solicitado
		//Además ocupamos el try, en caso de que exista un error y provoque el programa termine
		//Cada uno de los numeros del menu esta relacionado con los metodos propuestos en la clase biblioteca
		do {
			try {
				System.out.println("Hola, bienvenid@s a la libreria ITAMITA!!");
				System.out.println(" 1 --- Obtener membresia");
				System.out.println(" 2 --- Solicitar prestamo");
				System.out.println(" 3 --- Devolución libro");
				System.out.println(" 4 --- Compra libro");
				System.out.println(" 5 --- Mostrar libros disponibles");
				System.out.println(" 6 --- Mostrar personas registradas");
				System.out.println(" 7 --- Buscar libro");
				System.out.println(" 8 --- Buscar membresia por clave unica");
				System.out.println(" 9 --- Obtener el saldo de membresia");
				System.out.println("10 --- Cargar saldo a la membresia");
				System.out.println("11 --- Registrar un libro nuevo");
				System.out.println("12 --- Eliminar un libro");
				System.out.println("13 --- Salir");
				opcion = lectur.nextInt();
				
				switch (opcion) {
				case 1:
					System.out.println("Ingresa tu nombre: ");
					nombre = lectur.next();
					System.out.println("Ingresa tu edad: ");
					edad = lectur.nextInt();
					System.out.println("Ingresa saldo: ");
					saldo = lectur.nextDouble();
					System.out.println("Ingresa clave unica: ");
					claveU = lectur.nextInt();
					System.out.println(f1.altaMembresias(nombre, edad, saldo, claveU));
					break;
				case 2:
					System.out.println("Ingresa el nombre del libro: ");
					nombre = lectur.next();
					System.out.println("Ingresa clave unica de membresia: ");
					claveU = lectur.nextInt();
					System.out.println(f1.prestamo(nombre, claveU));
					break;
				case 3:
					System.out.println("Dame tu clave unica: ");
					claveU = lectur.nextInt();
					System.out.println(f1.devolucion(claveU));
					break;
				case 4:
					System.out.println("Ingresa el nombre del libro: ");
					nombre = lectur.next();
					System.out.println("Ingresa la clave unica de tu membresia");
					claveU = lectur.nextInt();
					System.out.println(f1.compraLibro(nombre, claveU));
					break;
				case 5:
					System.out.println(f1.mostrarLibros());
					break;
				case 6:
					System.out.println(f1.mostrarMembresias());
					break;
				case 7:
					System.out.println("Ingresa el nombre del libro que quieres buscar");
					nombre = lectur.next();
					System.out.println(f1.buscaLibro(nombre));
					break;
				case 8:
					System.out.println("Ingresa la clave unica de la membresia");
					claveU = lectur.nextInt();
					System.out.println(f1.membresiaRegistrada(claveU));
					break;
				case 9:
					System.out.println("Ingrese la clave unica: ");
					claveU = lectur.nextInt();
					System.out.println(f1.consultaSaldo(claveU));
					break;
				case 10:
					System.out.println("Ingrese la clave unica: ");
					claveU = lectur.nextInt();
					System.out.println("Ingrese la cantidad de saldo a cargar: ");
					saldo = lectur.nextDouble();
					f1.cargarSaldo(claveU, saldo);
					System.out.println("el nuevo saldo de tu cuenta es: "+f1.consultaSaldo(claveU));
					break;
				case 11:
					System.out.println("Nombre del libro: ");
					nombre = lectur.next();
					System.out.println("Genero del libro: ");
					genero = lectur.next();
					System.out.println("Nombre del autor: ");
					autor = lectur.next();
					System.out.println("¿Cual es el costo del libro?");
					costoLibro = lectur.nextDouble();
					System.out.println(f1.altaLibro(nombre, genero, autor, costoLibro));
					break;
				case 12:
					System.out.println("Ingresa el nombre del libro:");
					nombre = lectur.next();
					System.out.println(f1.bajaLibro(nombre));
					break;
				default:
					System.out.println();
					System.out.println("Gracias por escogernos");
				}
			}catch(Exception error) {
				System.err.println("ERROR!!"+error.getMessage());
			}
		} while (opcion!=13);
			
		
	}
}


