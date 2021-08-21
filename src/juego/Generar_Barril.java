package juego;

import java.util.ArrayList;
import java.util.Random;

import entorno.Entorno;

public class Generar_Barril {
	ArrayList<Barril> Barriles;
	Barril barril;
	int x;
	int y;
	int tiempo;
	Random r;

	public Generar_Barril(int x_inicial, int y_inicial) {
		this.Barriles = new ArrayList<>();
		this.x = x_inicial;
		this.y = y_inicial;
		this.tiempo = 0;
		r = new Random();

	}
	//Agrega un barril a la lista de Barriles
	void generar() {
		if (reloj()) {
			this.barril = new Barril(this.x, this.y);
			this.Barriles.add(this.barril);
		}
	}
	//Dibujo barriles
	void Dibujar(Entorno entorno,Vigas viga) {

		for (Barril barril : this.Barriles) {
			barril.Dibujar(entorno,viga);
		}

	}
	//Verifica que el barril este sobre la viga 
	void Mover(Vigas viga) {

		for (Barril barril : this.Barriles) {
			barril.Gravedad(viga);
		
		}
		eliminarBarril();
	}
	//el Reloj (Temporizador)
	boolean reloj() {
		if (this.tiempo < 0) {
			this.tiempo = r.nextInt(1000);
			return true;
		}
		//Como tiempo=0, la primera condicion no se cumple, por lo tanto tiempo=-1, y la condicion pasa a cumplirse
		this.tiempo-=1;
		return false;
	}
	//Verifico que el barril esta en la ultima viga y hago que se vaya de pantalla y se remueva 
	void eliminarBarril () {
		 
		 for (Barril barril : this.Barriles) {
			 if (barril.rectangulo.y > 550 && barril.rectangulo.x >800 ) {
				 this.Barriles.remove(barril);
				 return;
			 }
			 
		 }
		 
	 }

}
