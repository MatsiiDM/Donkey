package juego;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.Image;
import com.sun.javafx.geom.Rectangle;
import entorno.Herramientas;
import entorno.Entorno;

public class Personaje {
	int ancho;
	int largo;
	int angulo;
	Color color;
	Rectangle rectangulo;
	Vigas vigas; // aux
	int velocidad;
	boolean saltando;
	boolean der;
	boolean izq;
	int tiempoSalto;
	ArrayList<Barril> barriles;
	Vigas escaleras;
	Image saltarinder;
	Image saltarinizq;
	Image derecha;
	Image izquierda;
	//Constructor de personaje:
	public Personaje(int x_inicial, int y_inicial, Vigas vigas,Vigas escaleras, Generar_Barril aux) {
		this.ancho = 10;
		this.largo = 10;
		this.angulo = 0;
		this.color = Color.CYAN;
		this.rectangulo = new Rectangle(x_inicial, y_inicial, this.ancho, this.largo);
		this.vigas = vigas;
		this.velocidad = 2;
		this.saltando = false;
		this.izq = false;
		this.der = false;
		this.barriles = aux.Barriles;
		saltarinder=Herramientas.cargarImagen("marioder.png");
		saltarinizq=Herramientas.cargarImagen("marioizq.png");
		this.derecha=Herramientas.cargarImagen("Derecha.gif");
		this.izquierda=Herramientas.cargarImagen("Izquierda.gif");
		this.escaleras = escaleras;
	}

	void Dibujar(Entorno entorno) {
		
		//entorno.dibujarRectangulo(this.rectangulo.x + 5, this.rectangulo.y, this.rectangulo.width,this.rectangulo.height, this.angulo, this.color);
		
		
	
	//Movimiento de Jumpman
		
		Gravedad();
		//Jumpman se mueve hacia la Izquierda
		if (entorno.estaPresionada('a') && this.rectangulo.x > 0) {
			this.rectangulo.x -= velocidad;
			entorno.dibujarImagenConCentro(izquierda, this.rectangulo.x, this.rectangulo.y,30,135, 0.0, 0.2);
			
		}
		//Jumpman se mueve hacia la Derecha
		else if (entorno.estaPresionada('d') && this.rectangulo.x < 800) {
			this.rectangulo.x += velocidad;
			entorno.dibujarImagenConCentro(derecha, this.rectangulo.x, this.rectangulo.y,30,135, 0.0, 0.2);
		}
		if (entorno.sePresiono('a')) {
			this.izq= true;
			this.der = false;
		}
		if (entorno.sePresiono('d')) {
			this.der = true;
			this.izq= false;
			
		}
		//Verifico poner el personaje mirando a la izquierda
		if(this.izq==true && entorno.estaPresionada('a')==false&&entorno.estaPresionada('d')==false){
			entorno.dibujarImagenConCentro(saltarinizq,this.rectangulo.x + 5, this.rectangulo.y,45,140,this.angulo,0.2);
			
		}
		//Verifico poner el personaje mirando a la derecha
		if(this.der==true && entorno.estaPresionada('a')==false&&entorno.estaPresionada('d')==false){
			entorno.dibujarImagenConCentro(saltarinder,this.rectangulo.x + 5, this.rectangulo.y,45,140,this.angulo,0.2);
		}
		//El personaje por defecto al comenzar el juego esta mirando a la izquierda
		if(this.der==false&& this.izq==false && entorno.estaPresionada('a')==false&&entorno.estaPresionada('d')==false){
			entorno.dibujarImagenConCentro(saltarinder,this.rectangulo.x + 5, this.rectangulo.y,45,140,this.angulo,0.2);
		}
			
		//Jumpman salta
		if (entorno.estaPresionada('w') && (colision(this.vigas)) && (this.saltando == false)) {
			this.tiempoSalto = 25;
			this.saltando = true;
			this.rectangulo.y -= 5;
		}
		
			
		
		 
		
	}
	private void revisarSalto() {
		if (this.saltando == true) {
			if (this.tiempoSalto == 0) {
				this.saltando = false;
			} else {
				this.tiempoSalto--;
				this.rectangulo.y -= 1;
			}
		}

	}
	//Jumpman cae si no esta sobre ninguna viga o escalera
	void Gravedad() {

		if (!colision(this.vigas) && this.saltando == false) {
			this.rectangulo.y++;
		} else if (this.saltando == true)
			revisarSalto();

	}

	private boolean colision(Vigas viga) {
		boolean bandera;

		bandera = viga.EstaColisionando(this.rectangulo);
		return bandera;
	}
	//Verifico si Jumpman colisiona con algun barril de la lista barriles
	boolean colisionConBarriles() {
		for (Barril b : this.barriles)
			if (colisionCon(b.rectangulo))
				return true;
		return false;
	}
	//Verifico si Jumpman colisiona con la viga o barril:
	boolean colisionCon(Rectangle rectangulo) {
		if ((rectangulo.x+5<= this.rectangulo.x-5)
				|| (rectangulo.x-5>= this.rectangulo.x+this.rectangulo.width))
			return false;

		else if ((rectangulo.y + rectangulo.height <= this.rectangulo.y-20)|| (rectangulo.y-rectangulo.height >= this.rectangulo.y +10 ))
			return false;
		else
			return true;
	}
	//No se usa pero veo si jumpman se cae fuera del mapa
	boolean fueraDeMapa() {
		
		if (this.rectangulo.y>650) {
			return true;
		}
		return false;
	}
	//Verifica que Jumpman interactua con donkey y ganador es true
	boolean ganador() {
		
		if(this.rectangulo.x<=125 && this.rectangulo.y<=125) {
			return true;
			}
		return false;
		
	}
}
