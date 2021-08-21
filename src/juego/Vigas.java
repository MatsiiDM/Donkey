package juego;

import java.util.ArrayList;
import java.util.Collection;

import com.sun.javafx.geom.Rectangle;

import entorno.Entorno;
import entorno.Herramientas;

public class Vigas {
	
	ArrayList<Viga> vigas;
	ArrayList<Viga> escaleras;
	

	public Vigas() {

		this.vigas = new ArrayList<>();
		this.escaleras = new ArrayList<>();
		iniciar();
		

		
	}
	

	void iniciar() {
		// Indico el "X" inicial , la altura y el ancho de la viga y tambien de la escalera
		agregarViga(0, 125, 700);
		
		//escalera(65, 125, 8);
		
		//escalera(110, 125, 2);
		
		agregarViga(150, 200, 700);
		
		escalera(660, 180, 2);

		agregarViga(0, 275, 700);

		escalera(150, 255, 2);

		agregarViga(150, 350, 700);

		escalera(660, 330, 2);

		agregarViga(0, 425, 700);

		escalera(150, 405, 2);

		agregarViga(150, 500, 700);

		escalera(660, 480, 2);

		agregarViga(0, 600, 810);

		escalera(150, 575, 3);
		
		
	}
	//Agrego vigas a la lista
	private void agregarViga(int i, int j, int k) {
		Viga aux;
		aux = new Viga(i, j, 0, k);
		this.vigas.add(aux);

	}
	//Agrega escaleras a la lista
		private void escalera(int x_inicial, int y_inicial, int escalones) {
			Viga axx;
			int x = x_inicial;
			int y = y_inicial;

			for (int i = escalones; i > -1; i--) {
				axx = new Viga(x, y, 0, 30);
				y -= 20;
				this.escaleras.add(axx);
			}

		}

	void Dibujar(Entorno entorno) {
		//Dibujos las vigas con la imagenes:
		for (Viga viga : this.vigas) {
			viga.Dibujarvigas(entorno);
		}
		//Dibujos las escaleras con la imagenes:
		for (Viga viga : this.escaleras) {
			viga.Dibujaresca(entorno);
			
		}

	}
	
	public boolean EstaColisionando(Rectangle rectangulo) {
		//Verifico que jumpman o un barril este sobre una viga:
		for (Viga viga : this.vigas) {
			if (viga.colisionCon(rectangulo) == true) {

				return true;
			}

		}
		//Verifico que jumpman este sobre una escalera:
		for (Viga viga : this.escaleras) {
			if (viga.colisionCon(rectangulo) == true) {

				return true;
			}

		}
		return false;
	}
	
	

}
