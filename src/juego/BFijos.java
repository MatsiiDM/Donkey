package juego;

import java.awt.Image;
import entorno.Herramientas;
import entorno.Entorno;
//Uso esta clase para dibujar los 4 barriles iniciales
public class BFijos{
	
	// Variables de instancia
	
			private double x;
			private double y;
			private int ancho;
			private int alto;
			private int diametro;
			private Image bfijos;
			
	
	// constructor
	BFijos(int x,int y) {
		int diametro = 25;
		this.x = x;
		this.y = y;
		// Cargo una imagen con 4 barriles fijos
		bfijos=Herramientas.cargarImagen("fijos.png");
		}
	
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagenConCentro(bfijos,this.x, this.y,25,185,0,0.2);
	}
}
