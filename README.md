# Library Management System

Sistema de gestión de biblioteca desarrollado en Java, que permite administrar libros, membresías, préstamos, devoluciones y saldo de usuarios mediante una interfaz gráfica.

---

## 📦 Estructura del proyecto

⚠️ IMPORTANTE:  
Todos los archivos deben mantenerse en la misma carpeta para que el sistema funcione correctamente, ya que las clases están interconectadas.

Biblioteca.java
Libro.java
Membresia.java
VistaTabla.java
ControladorTabla.java
LecturaLibros.java
PruebaProy.java


---

## 🧠 Descripción de cada archivo

### 📚 Biblioteca.java
Clase principal del sistema.  
Contiene la lógica de negocio: administración de libros, membresías, préstamos, devoluciones y saldo.

---

### 📘 Libro.java
Representa la entidad "Libro".  
Define atributos como título, autor y disponibilidad.

---

### 👤 Membresia.java
Representa a los usuarios del sistema.  
Gestiona información de membresía y saldo.

---

### 🖥️ VistaTabla.java
Interfaz gráfica desarrollada con Java Swing.  
Permite al usuario interactuar con el sistema mediante botones y campos de texto.

---

### 🎮 ControladorTabla.java
Controlador del sistema.  
Conecta la interfaz gráfica con la lógica de la clase Biblioteca.

---

### 📂 LecturaLibros.java
Maneja la carga de información desde archivos externos (si aplica).  
Permite inicializar el sistema con datos.

---

### 🚀 PruebaProy.java
Clase de ejecución principal.  
Contiene el método `main` para correr el programa.

---

## ⚙️ Cómo ejecutar el proyecto

1. Asegúrate de tener Java instalado (JDK 8 o superior)

2. Compila todos los archivos:

```bash

javac *.java
java PruebaProy
```

## 💻 Ejemplo de código

A continuación se muestra un fragmento de la lógica de préstamo de libros:

```java
public void prestarLibro(String titulo, Membresia usuario) {
    Libro libro = buscarLibro(titulo);
    if (libro != null && libro.disponible()) {
        libro.prestar();
        usuario.agregarPrestamo(libro);
    } else {
        System.out.println("El libro no está disponible");
    }
}
```

🔄 Funcionamiento general

El sistema sigue una arquitectura tipo MVC simplificada:

Modelo: Libro, Membresia
Vista: VistaTabla
Controlador: ControladorTabla
Lógica: Biblioteca

El usuario interactúa con la interfaz gráfica, que envía acciones al controlador, el cual modifica la lógica del sistema.

🎯 Funcionalidades principales
Alta y baja de libros
Registro de membresías
Compra y renta de libros
Devolución de préstamos
Consulta y gestión de saldo
Visualización de catálogo

🧩 Notas importantes
Todas las clases deben estar en la misma carpeta
No eliminar archivos, ya que están interdependientes
El sistema no funcionará correctamente si falta alguna clase

👨‍💻 Autor

Julian Quiroz
ITAM – Finanzas y Ciencia de Datos