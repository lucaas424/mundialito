package mundialito;

import java.util.ArrayList;

public class Grupo extends EtapaMundial {

    private ArrayList<Equipo> equipos;

    public Grupo(String descripcion) {
        super(descripcion);
        this.equipos = new ArrayList<Equipo>();
    }

    public void agregarEquipos(ArrayList<Equipo> equipos) {
        if (equipos.size() < 2) {
            System.out.println("Error: no se pueden agregar menos de 2 equipos al grupo.");
            return;
        }
        this.equipos = equipos;
    }

    public ArrayList<Equipo> getEquiposQueAvanzan() {
        ArrayList<Equipo> clasificados = new ArrayList<Equipo>(equipos);

        for (int i = 0; i < clasificados.size(); i++) {
            for (int j = i + 1; j < clasificados.size(); j++) {
                if (clasificados.get(j).getPuntos() > clasificados.get(i).getPuntos()) {
                    Equipo aux = clasificados.get(i);
                    clasificados.set(i, clasificados.get(j));
                    clasificados.set(j, aux);
                }
            }
        }

        ArrayList<Equipo> dosMejores = new ArrayList<Equipo>();
        dosMejores.add(clasificados.get(0));
        dosMejores.add(clasificados.get(1));
        return dosMejores;
    }

    public void jugarPartidos() {
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                Equipo equipo1 = equipos.get(i);
                Equipo equipo2 = equipos.get(j);
                Resultado resultado = new Resultado((int) (Math.random() * 4), (int) (Math.random() * 4));
                Partido partido = new Partido(equipo1, equipo2, resultado);
                partidos.add(partido);
            }
        }
    }

    public void mostrarResultados() {
        System.out.println("Resultados del " + descripcionEtapa + ":");
        for (Partido p : partidos) {
            System.out.println(p);
        }

        System.out.println("\nTotal de partidos jugados: " + partidos.size());

        ArrayList<Equipo> tabla = new ArrayList<Equipo>(equipos);
        for (int i = 0; i < tabla.size(); i++) {
            for (int j = i + 1; j < tabla.size(); j++) {
                if (tabla.get(j).getPuntos() > tabla.get(i).getPuntos()) {
                    Equipo aux = tabla.get(i);
                    tabla.set(i, tabla.get(j));
                    tabla.set(j, aux);
                }
            }
        }

        System.out.println("\nTabla de posiciones:");
        System.out.printf("%-12s | %-6s | %-3s\n", "Equipo", "Puntos", "PJ");
        for (Equipo e : tabla) {
            System.out.printf("%-12s | %-6d | %-3d\n", e.getNombre(), e.getPuntos(), e.getCantidadPartidos());
        }
        System.out.println();
    }
}
