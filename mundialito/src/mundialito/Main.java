package mundialito;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        String[] nombresEquipos = {
            "Argentina", "Brasil", "Francia", "Alemania",
            "España", "Inglaterra", "Italia", "Países Bajos",
            "Portugal", "Croacia", "Uruguay", "Bélgica",
            "Suiza", "Senegal", "EEUU", "México",
            "Polonia", "Corea del Sur", "Japón", "Australia",
            "Serbia", "Marruecos", "Canadá", "Ecuador",
            "Ghana", "Camerún", "Irán", "Dinamarca",
            "Costa Rica", "Túnez", "Arabia Saudita", "Qatar"
        };

        ArrayList<Grupo> grupos = new ArrayList<>();
        int equiposPorGrupo = 4; 

        
        for (int i = 0; i < 8; i++) {
            ArrayList<Equipo> equiposGrupo = new ArrayList<>();
            for (int j = 0; j < equiposPorGrupo; j++) {
                equiposGrupo.add(new Equipo(nombresEquipos[i * equiposPorGrupo + j]));
            }
            Grupo grupo = new Grupo("Grupo " + (char)('A' + i));
            grupo.agregarEquipos(equiposGrupo);
            grupo.jugarPartidos();
            grupo.mostrarResultados();
            grupos.add(grupo);
        }

        
        ArrayList<Equipo> clasificados = new ArrayList<>();
        for (Grupo g : grupos) {
            clasificados.addAll(g.getEquiposQueAvanzan());
        }

        
        Llave octavos = new Llave("Octavos de final");
        octavos.agregarEquipos(clasificados);
        octavos.jugarPartidos();
        octavos.mostrarResultados();

        Llave cuartos = new Llave("Cuartos de final");
        cuartos.agregarEquipos(octavos.getEquiposQueAvanzan());
        cuartos.jugarPartidos();
        cuartos.mostrarResultados();

        Llave semis = new Llave("Semifinales");
        semis.agregarEquipos(cuartos.getEquiposQueAvanzan());
        semis.jugarPartidos();
        semis.mostrarResultados();

        
        ArrayList<Equipo> finalistas = semis.getEquiposQueAvanzan();
        ArrayList<Equipo> perdedoresSemi = new ArrayList<>();
        for (Equipo eq : cuartos.getEquiposQueAvanzan()) {
            if (!finalistas.contains(eq)) {
                perdedoresSemi.add(eq);
            }
        }

        Llave finalMundial = new Llave("Final del Mundial");
        finalMundial.agregarEquipos(finalistas);
        finalMundial.jugarPartidos();
        finalMundial.mostrarResultados();

        Llave tercerPuesto = new Llave("Tercer Puesto");
        tercerPuesto.agregarEquipos(perdedoresSemi);
        tercerPuesto.jugarPartidos();
        tercerPuesto.mostrarResultados();

        
        Equipo campeon = finalMundial.getEquiposQueAvanzan().get(0);
        System.out.println("🏆 ¡El campeón del Mundial es: " + campeon.getNombre() + "!");
    }
}
