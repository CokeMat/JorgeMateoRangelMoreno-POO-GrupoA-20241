package usuarios.utils;

import java.util.HashMap;

public class EntidadFederativa {
    private static final HashMap<String, String> entidadesFederativas = new HashMap<>();
    private static final HashMap<Estado, String> estadosEnString = new HashMap<>();
    private static EntidadFederativa instance = null;

    public EntidadFederativa() {
        entidadesFederativas.put("AGUASCALIENTES", "AS");
        entidadesFederativas.put("BAJA CALIFORNIA", "BC");
        entidadesFederativas.put("BAJA CALIFORNIA SUR", "BS");
        entidadesFederativas.put("CAMPECHE", "CC");
        entidadesFederativas.put("COAHUILA", "CL");
        entidadesFederativas.put("COLIMA", "CM");
        entidadesFederativas.put("CHIAPAS", "CS");
        entidadesFederativas.put("CHIHUAHUA", "CH");
        entidadesFederativas.put("CIUDAD DE MEXICO", "DF");
        entidadesFederativas.put("DURANGO", "DG");
        entidadesFederativas.put("GUANAJUATO", "GT");
        entidadesFederativas.put("GUERRERO", "GR");
        entidadesFederativas.put("HIDALGO", "HG");
        entidadesFederativas.put("JALISCO", "JC");
        entidadesFederativas.put("ESTADO DE MEXICO", "MC");
        entidadesFederativas.put("MICHOACAN", "MN");
        entidadesFederativas.put("MORELOS", "MS");
        entidadesFederativas.put("NAYARIT", "NT");
        entidadesFederativas.put("NUEVO LEON", "NL");
        entidadesFederativas.put("OAXACA", "OC");
        entidadesFederativas.put("PUEBLA", "PL");
        entidadesFederativas.put("QUERETARO", "QT");
        entidadesFederativas.put("QUINTANA ROO", "QR");
        entidadesFederativas.put("SAN LUIS POTOSI", "SP");
        entidadesFederativas.put("SINALOA", "SL");
        entidadesFederativas.put("SONORA", "SR");
        entidadesFederativas.put("TABASCO", "TC");
        entidadesFederativas.put("TAMAULIPAS", "TS");
        entidadesFederativas.put("TLAXCALA", "TL");
        entidadesFederativas.put("VERACRUZ", "VZ");
        entidadesFederativas.put("YUCATAN", "YN");
        entidadesFederativas.put("ZACATECAS", "ZS");
        entidadesFederativas.put("NACIDO EN EXTRANJERO", "NE");

        estadosEnString.put(Estado.Aguascalientes, "AGUASCALIENTES");
        estadosEnString.put(Estado.Baja_California, "BAJA CALIFORNIA");
        estadosEnString.put(Estado.Baja_California_Sur, "BAJA CALIFORNIA SUR");
        estadosEnString.put(Estado.Campeche, "CAMPECHE");
        estadosEnString.put(Estado.Coahuila, "COAHUILA");
        estadosEnString.put(Estado.Colima, "COLIMA");
        estadosEnString.put(Estado.Chiapas, "CHIAPAS");
        estadosEnString.put(Estado.Chihuahua, "CHIHUAHUA");
        estadosEnString.put(Estado.CDMX, "CIUDAD DE MEXICO");
        estadosEnString.put(Estado.Durango, "DURANGO");
        estadosEnString.put(Estado.Guanajuato, "GUANAJUATO");
        estadosEnString.put(Estado.Guerrero, "GUERRERO");
        estadosEnString.put(Estado.Hidalgo, "HIDALGO");
        estadosEnString.put(Estado.Jalisco, "JALISCO");
        estadosEnString.put(Estado.Estado_de_Mexico, "ESTADO DE MEXICO");
        estadosEnString.put(Estado.Michoacan, "MICHOACAN");
        estadosEnString.put(Estado.Morelos, "MORELOS");
        estadosEnString.put(Estado.Nayarit, "NAYARIT");
        estadosEnString.put(Estado.Nuevo_Leon, "NUEVO LEON");
        estadosEnString.put(Estado.Oaxaca, "OAXACA");
        estadosEnString.put(Estado.Puebla, "PUEBLA");
        estadosEnString.put(Estado.Queretaro, "QUERETARO");
        estadosEnString.put(Estado.Quintana_Roo, "QUINTANA ROO");
        estadosEnString.put(Estado.San_Luis_Potosi, "SAN LUIS POTOSI");
        estadosEnString.put(Estado.Sinaloa, "SINALOA");
        estadosEnString.put(Estado.Sonora, "SONORA");
        estadosEnString.put(Estado.Tabasco, "TABASCO");
        estadosEnString.put(Estado.Tamaulipas, "TAMAULIPAS");
        estadosEnString.put(Estado.Tlaxcala, "TLAXCALA");
        estadosEnString.put(Estado.Veracruz, "VERACRUZ");
        estadosEnString.put(Estado.Yucatan, "YUCATAN");
        estadosEnString.put(Estado.Zacatecas, "ZACATECAS");
        estadosEnString.put(Estado.Nacido_En_Extranjero, "NACIDO EN EXTRANJERO");

    }

    public static String getEntidadFederativa(String estado) {
        return EntidadFederativa.getInstance().getEntidadesFederativas().get(estado);
    }

    public static Estado convertirEstado(String estadoString) {// ???, si es justo aquí donde truena
        return Estado.valueOf(estadoString.replace(" ", "_"));
    } 

    public static String getStringEstado(Estado estado) {
        return EntidadFederativa.getInstance().getStringsEstado().get(estado);
    }

    private static EntidadFederativa getInstance() {
        if (instance == null) {
            instance = new EntidadFederativa();
        }
        return instance;
    }

    private HashMap<String, String> getEntidadesFederativas() {
        return entidadesFederativas;
    }

    private HashMap<Estado, String> getStringsEstado() {
        return estadosEnString;
    }

}