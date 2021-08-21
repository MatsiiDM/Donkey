package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;

	// Variables y métodos propios de cada grupo
	// ...
	Personaje JumpMan;
	Generar_Barril barriles;
	Vigas vigas;
	Temporizador reloj;
	Donkey donkey;
	Image fondo;
	BFijos fijos;
	Vigas escaleras;
	VigaAux vigaabajo;
	void iniciarObjetos() {
		this.reloj = new Temporizador(1);
		this.vigas = new Vigas();
		this.barriles = new Generar_Barril(40, 110);
		this.JumpMan = new Personaje(280, 555, vigas,escaleras, barriles);
		this.donkey = new Donkey (80,100);
		this.fondo = Herramientas.cargarImagen("fondo.jpg");
		this.fijos = new BFijos (40,100);
		this.vigaabajo= new VigaAux(0,600);
		// Inicializar lo que haga falta para el juego
		// ...

		// Inicia el juego!
		this.entorno.iniciar();
	}

	Juego() {
		this.entorno = new Entorno(this,
				"Donkey - GrupoXX - Apellido1 - Apellido2 -Apellido3 - V0.01",
				800, 600);
		iniciarObjetos();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por
	 * lo tanto es el método más importante de esta clase. Aquí se debe
	 * actualizar el estado interno del juego para simular el paso del tiempo
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick() {
		entorno.dibujarImagen(fondo, 0.0, 0.0, 0.0, 1.5);
		//Utilizaba esto para ver los pixeles de la pantalla:
		/*entorno.cambiarFont("Comic Sans", 12, Color.white);
			for(int x=800;x>0;x-=70) { 
				for(int y=600;y>0;y-=15) {
				entorno.escribirTexto(String.valueOf(x)+"-"+String.valueOf(y), x, y);
				} 
			}*/ 
		
		// Procesamiento de un instante de tiempo
		// ... }
		
		//Dibujo todoo
		
		vigas.Dibujar(entorno);
		if (JumpMan.ganador()== false) {
			barriles.generar();
			barriles.Dibujar(entorno, vigas);
			barriles.Mover(vigas);
			fijos.dibujarse(entorno);
			vigaabajo.dibujarse(entorno);
			donkey.dibujarse(entorno);
			JumpMan.Dibujar(entorno);
			
			//Muestro el tiempo de juego
			reloj.MostrarTiempo(entorno);
			reloj.seterminoElTiempo();
		}	
		//Si jumpman choca con algun barril, o se termina el tiempo. Se reinicia el juego 
		if ( JumpMan.colisionConBarriles() == true)
			iniciarObjetos();
			
		//Si Jumpman sube la ultima escalera se termina el juego y ganas
		if (JumpMan.ganador() == true) {
			entorno.cambiarFont("Comic Sans", 40, Color.white);
			entorno.escribirTexto("¡¡GANASTEEEEE!!", 220, 330);
		}
		

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
