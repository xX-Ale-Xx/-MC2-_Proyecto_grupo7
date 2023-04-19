/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kruskalproyecto;

import java.util.Comparator;


    class Edge implements Comparator<Edge>{
	    int origen;     //Vértice origen
	    int destino;    //Vértice destino
	    int peso;       //Peso entre el vértice origen y destino
	    Edge(){}
	    //Comparador por peso, me servira al momento de ordenar lo realizara en orden ascendente
	    //Ordenar de forma descendente para obtener el arbol de expansion maxima
		@Override
		public int compare(Edge e1 , Edge e2 ) {
			//return e2.peso - e1.peso; //Arbol de expansion maxima
			return e1.peso - e2.peso;   //Arbol de expansion minima
		}
	}

