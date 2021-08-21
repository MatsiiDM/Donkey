package juego;

import java.awt.Image;
import entorno.Herramientas;
import entorno.Entorno;

//ESTA CLASE SOLO SE UTILIZO PARA RELLENAR LA ULTIMA VIGA
public class VigaAux{
	
	// Variables de instancia
	
			private double x;
			private double y;
			private int ancho;
			private int alto;
			private int diametro;
			private Image vigaabajo;
			
	
	// constructor
	VigaAux(int x,int y) {
		int diametro = 25;
		this.x = x;
		this.y = y;
		// Cargo una imagen de una viga
		vigaabajo=Herramientas.cargarImagen("vigaabajo.png");
		}
	
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagenConCentro(vigaabajo,this.x, this.y,-1350,12,0,0.5);
	}
}
