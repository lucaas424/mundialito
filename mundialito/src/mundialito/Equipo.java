package mundialito;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private int puntos;
    private ArrayList<Partido> partidos;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.partidos = new ArrayList<Partido>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getCantidadPartidos() {
        return partidos.size();
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }

    @Override
    public String toString() {
        return nombre + " (" + puntos + " pts, " + getCantidadPartidos() + " PJ)";
    }
}
