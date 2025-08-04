package mundialito;

import java.util.ArrayList;

public abstract class EtapaMundial {
    protected String descripcionEtapa;
    protected ArrayList<Partido> partidos;

    public EtapaMundial(String descripcionEtapa) {
        this.descripcionEtapa = descripcionEtapa;
        this.partidos = new ArrayList<Partido>();
    }

    public String getDescripcionEtapa() {
        return descripcionEtapa;
    }

    public void addPartido(Partido partido) {
        partidos.add(partido);
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public abstract ArrayList<Equipo> getEquiposQueAvanzan();

    @Override
    public String toString() {
        return descripcionEtapa + " - Partidos: " + partidos.size();
    }
}
