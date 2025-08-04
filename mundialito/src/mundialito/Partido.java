package mundialito;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private Resultado resultado;

    public Partido(Equipo local, Equipo visitante, Resultado resultado) {
        this.local = local;
        this.visitante = visitante;
        this.resultado = resultado;

        local.agregarPartido(this);
        visitante.agregarPartido(this);

        if (resultado.ganoLocal()) {
            local.sumarPuntos(3);
        } else if (resultado.empatado()) {
            local.sumarPuntos(1);
            visitante.sumarPuntos(1);
        } else {
            visitante.sumarPuntos(3);
        }
    }

    public Equipo getLocal() {
        return local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public String toString() {
        return local.getNombre() + " vs " + visitante.getNombre() + " => " + resultado.toString();
    }
}
