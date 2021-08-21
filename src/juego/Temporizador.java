package juego;

import java.awt.Color;

import entorno.Entorno;

public class Temporizador {
	
	int tiempo;
	
	public Temporizador(int tiempoMaximo)
	{
		this.tiempo=tiempoMaximo;
	}
	
	void MostrarTiempo(Entorno entorno)
	{
		entorno.cambiarFont("Comic Sans", 40, Color.white);
		entorno.escribirTexto(String.valueOf(this.tiempo/100),30,40);
	}
	
	boolean seterminoElTiempo()
	{
		if(this.tiempo<=0) return true;
		this.tiempo++;
		return false;
	}

}
