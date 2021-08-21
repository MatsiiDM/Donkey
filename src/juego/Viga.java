package juego;

import java.awt.Color;
import java.awt.Image;

import com.sun.javafx.geom.Rectangle;

import entorno.Entorno;
import entorno.Herramientas;
import javafx.scene.shape.Circle;

public class Viga {


	double angulo;
	Color color;
	int ancho;
	int largo;
	Rectangle rectangulo;
	Image ivigas;
	Image iesca;
	//Constructor de vigas
	public Viga(int x_inicial, int y_inicial, double angulo_inicial,int ancho) {
		this.angulo = angulo_inicial;
		this.color = Color.yellow;
		this.ancho = ancho;
		this.largo = 10;
		this.rectangulo = new Rectangle(x_inicial, y_inicial, this.ancho, this.largo);
		ivigas=Herramientas.cargarImagen("viga.png");
		iesca=Herramientas.cargarImagen("escalera.png");
	}

	void Dibujarvigas(Entorno entorno) {

		//entorno.dibujarRectangulo(this.rectangulo.x+(this.ancho/2), this.rectangulo.y,this.rectangulo.width, this.rectangulo.height, this.angulo, this.color);
		entorno.dibujarImagenConCentro(ivigas,this.rectangulo.x, this.rectangulo.y,0,10,0.0,0.5);
	}
	void Dibujaresca(Entorno entorno) {
		entorno.dibujarImagenConCentro(iesca,this.rectangulo.x, this.rectangulo.y,0,155,1.57,0.25);
		//entorno.dibujarRectangulo(this.rectangulo.x+(this.ancho/2), this.rectangulo.y,this.rectangulo.width, this.rectangulo.height, this.angulo, this.color);
	}
	void Dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(this.rectangulo.x+(this.ancho/2), this.rectangulo.y,this.rectangulo.width, this.rectangulo.height, this.angulo, this.color);
	}
	//Verifico que la viga esta siendo colisionada por algun barril:
	boolean colisionCon(Rectangle rectangulo) {
		//compruebo que no este en el ancho de la viga
		if ((rectangulo.x+5<= this.rectangulo.x-5)
				|| (rectangulo.x-5>= this.rectangulo.x+this.rectangulo.width))
			return false;

		// compruebo que no este sobre la viga
		else if ((rectangulo.y+rectangulo.height <= this.rectangulo.y)
				|| (rectangulo.y >= this.rectangulo.y+rectangulo.height))
			return false;
		// –podríamos seguir comparando mas dimensiones si las tuvieramos, pero como
		// sólo hay 2, estamos antes una colisión.
		else
			return true;

	}

}
