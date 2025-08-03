package mundialito;

import java.util.ArrayList;

public class Llave extends EtapaMundial {

    private ArrayList<Equipo> equipos;

    public Llave(String descripcion) {
        super(descripcion);
        this.equipos = new ArrayList<Equipo>();
    }

    public void agregarEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public ArrayList<Equipo> getEquiposQueAvanzan() {
        ArrayList<Equipo> ganadores = new ArrayList<Equipo>();

        for (Partido partido : partidos) {
            if (partido.getResultado().ganoLocal()) {
                ganadores.add(partido.getLocal());
            } else {
                ganadores.add(partido.getVisitante());
            }
        }

        return ganadores;
    }

    public void jugarPartidos() {
        for (int i = 0; i < equipos.size(); i += 2) {
            Equipo equipo1 = equipos.get(i);
            Equipo equipo2 = equipos.get(i + 1);
            Resultado resultado = new Resultado((int) (Math.random() * 5), (int) (Math.random() * 5));

            
            while (resultado.empatado()) {
                resultado = new Resultado((int) (Math.random() * 5), (int) (Math.random() * 5));
            }

            Partido partido = new Partido(equipo1, equipo2, resultado);
            partidos.add(partido);
        }
    }

    public void mostrarResultados() {
        System.out.println("Resultados de " + descripcionEtapa + ":");
        for (Partido p : partidos) {
            System.out.println(p);
        }
        System.out.println();
    }
}
