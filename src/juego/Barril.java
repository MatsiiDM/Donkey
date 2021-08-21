package juego;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.Image;
import com.sun.javafx.geom.Rectangle;
import entorno.Herramientas;
import entorno.Entorno;

public class Barril {
	Rectangle rectangulo;
	int diametro;
	Color color;
	int direccion;
	int velocidad;
	Image barril;

	public Barril(int x_inicial, int y_inicial) {

		this.rectangulo = new Rectangle(x_inicial, y_inicial, 10, 10);
		this.diametro = 10;
		this.color = Color.GREEN;
		this.direccion = 1;
		this.velocidad = 1;
		barril=Herramientas.cargarImagen("Barril0.gif");
	}

	void Dibujar(Entorno entorno,Vigas viga) {
		Gravedad(viga);

		//entorno.dibujarCirculo(this.rectangulo.x, this.rectangulo.y, this.diametro, this.color);
		entorno.dibujarImagenConCentro(barril,this.rectangulo.x, this.rectangulo.y,75,140,0.0,0.13);
		
	}
	// Movimiento del barril
	void Movimiento() {
		rebote();

		if (this.direccion == 1) {
			//Barril se mueve hacia la derecha
			this.rectangulo.x += this.velocidad;

		} else {
			//Barril se mueve hacia la izquierda
			this.rectangulo.x -= this.velocidad;
		}
	}
	//Cae el barril por gravedad
	void Gravedad(Vigas viga) {

		if (!colision(viga)) {
			this.rectangulo.y+=1;
		}
		else {
			
			Movimiento();
		}

	}
	//Verifica si el barril esta sobre una viga
	boolean colision(Vigas viga) {

		boolean bandera;

		bandera = viga.EstaColisionando(this.rectangulo);
		return bandera;

	}
	//Cambia direccion de barril a tocar los extremos izquierdo o derecho de la pantalla
	void rebote() {

		if (this.rectangulo.x < 5 || this.rectangulo.x >  800) {
			this.direccion *= -1;

		}

	}

}
