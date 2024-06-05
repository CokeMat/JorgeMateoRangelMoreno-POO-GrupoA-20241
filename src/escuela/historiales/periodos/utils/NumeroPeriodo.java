package escuela.historiales.periodos.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class NumeroPeriodo {
    public static final HashMap<Integer, String> numerosPeriodo = incializarHashMapNumerosPeriodo();

    private static HashMap<Integer, String> incializarHashMapNumerosPeriodo() {
        HashMap<Integer, String> mapa = new LinkedHashMap<>();
        mapa.put(1, NombrePeriodo.AGOSTO_DICIEMBRE_2023.toString());
        mapa.put(2, NombrePeriodo.ENERO_JUNIO_2024.toString());
        mapa.put(3, NombrePeriodo.AGOSTO_DICIEMBRE_2024.toString());
        mapa.put(4, NombrePeriodo.ENERO_JUNIO_2025.toString());
        mapa.put(5, NombrePeriodo.AGOSTO_DICIEMBRE_2025.toString());
        mapa.put(6, NombrePeriodo.ENERO_JUNIO_2026.toString());
        return mapa;
        
    }
}
