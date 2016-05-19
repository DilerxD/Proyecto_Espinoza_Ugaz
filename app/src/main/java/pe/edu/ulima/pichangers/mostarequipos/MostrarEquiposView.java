package pe.edu.ulima.pichangers.mostarequipos;

import java.util.List;

import pe.edu.ulima.pichangers.beans.Equipo;

/**
 * Created by CARLOS on 13/05/2016.
 */
public interface MostrarEquiposView {
    public void setPresenter(MostrarEquiposPresenter presenter);
    public void mostrarEquipos(List<Equipo> equipos);

}
