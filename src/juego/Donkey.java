package juego;

import java.awt.Image;
import entorno.Herramientas;
import entorno.Entorno;

public class Donkey {
	
	// Variables de instancia
	
			private double x;
			private double y;
			private int ancho;
			private int alto;
			private int diametro;
			private Image Donkey;
			
	
	// constructor
	Donkey(int x,int y) {
		int diametro = 25;
		this.x = x;
		this.y = y;
		// Cargo un gif del donkey
		Donkey=Herramientas.cargarImagen("mono.gif");
		}
	
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagenConCentro(Donkey,this.x, this.y,30,55,0.0,0.4);
	}
}
