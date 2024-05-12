package src.usuarios.utils;

import java.util.HashMap;


public class EntidadFederativa {
    private static final HashMap<Estado, String> entidadesFederativas = new HashMap<>();
    private static final HashMap<Estado, String> estadosEnString = new HashMap<>();
    private static EntidadFederativa instance = null;
    
    public EntidadFederativa(){
        entidadesFederativas.put(Estado.Aguascalientes, "AS");
        entidadesFederativas.put(Estado.Baja_California, "BC");
        entidadesFederativas.put(Estado.Baja_California_Sur, "BS");
        entidadesFederativas.put(Estado.Campeche, "CC");
        entidadesFederativas.put(Estado.Coahuila, "CL");
        entidadesFederativas.put(Estado.Colima, "CM");
        entidadesFederativas.put(Estado.Chiapas, "CS");
        entidadesFederativas.put(Estado.Chihuahua, "CH");
        entidadesFederativas.put(Estado.CDMX, "DF");
        entidadesFederativas.put(Estado.Durango, "DG");
        entidadesFederativas.put(Estado.Guanajuato, "GT");
        entidadesFederativas.put(Estado.Guerrero, "GR");
        entidadesFederativas.put(Estado.Hidalgo, "HG");
        entidadesFederativas.put(Estado.Jalisco, "JC");
        entidadesFederativas.put(Estado.Estado_de_Mexico, "MC");
        entidadesFederativas.put(Estado.Michoacan, "MN");
        entidadesFederativas.put(Estado.Morelos, "MS");
        entidadesFederativas.put(Estado.Nayarit, "NT");
        entidadesFederativas.put(Estado.Nuevo_Leon, "NL");
        entidadesFederativas.put(Estado.Oaxaca, "OC");
        entidadesFederativas.put(Estado.Puebla, "PL");
        entidadesFederativas.put(Estado.Queretaro, "QT");
        entidadesFederativas.put(Estado.Quintana_Roo, "QR");
        entidadesFederativas.put(Estado.San_Luis_Potosi, "SP");
        entidadesFederativas.put(Estado.Sinaloa, "SL");
        entidadesFederativas.put(Estado.Sonora, "SR");
        entidadesFederativas.put(Estado.Tabasco, "TC");
        entidadesFederativas.put(Estado.Tamaulipas, "TS");
        entidadesFederativas.put(Estado.Tlaxcala, "TL");
        entidadesFederativas.put(Estado.Veracruz, "VZ");
        entidadesFederativas.put(Estado.Yucatan, "YN");
        entidadesFederativas.put(Estado.Zacatecas, "ZS");
        entidadesFederativas.put(Estado.Nacido_En_Extranjero, "NE");

        estadosEnString.put(Estado.Aguascalientes, "AGUASCALIENTES");
        estadosEnString.put(Estado.Baja_California, "BAJA CALIFORNIA");
        estadosEnString.put(Estado.Baja_California_Sur, "BAJA CALIFORNIA SUR");
        estadosEnString.put(Estado.Campeche, "CAMPECHE");
        estadosEnString.put(Estado.Coahuila, "COAHUILA");
        estadosEnString.put(Estado.Colima, "COLIMA");
        estadosEnString.put(Estado.Chiapas, "CHIAPAS");
        estadosEnString.put(Estado.Chihuahua, "CHIHUAHUA");
        estadosEnString.put(Estado.CDMX, "CIUDAD DE MÉXICO");
        estadosEnString.put(Estado.Durango, "DURANGO");
        estadosEnString.put(Estado.Guanajuato, "GUANAJUATO");
        estadosEnString.put(Estado.Guerrero, "GUERRERO");
        estadosEnString.put(Estado.Hidalgo, "HIDALGO");
        estadosEnString.put(Estado.Jalisco, "JALISCO");
        estadosEnString.put(Estado.Estado_de_Mexico, "ESTADO DE MÉXICO");
        estadosEnString.put(Estado.Michoacan, "MICHOACÁN");
        estadosEnString.put(Estado.Morelos, "MORELOS");
        estadosEnString.put(Estado.Nayarit, "NAYARIT");
        estadosEnString.put(Estado.Nuevo_Leon, "NUEVO LEÓN");
        estadosEnString.put(Estado.Oaxaca, "OAXACA");
        estadosEnString.put(Estado.Puebla, "PUEBLA");
        estadosEnString.put(Estado.Queretaro, "QUERÉTARO");
        estadosEnString.put(Estado.Quintana_Roo, "QUINTANA ROO");
        estadosEnString.put(Estado.San_Luis_Potosi, "SAN LUIS POTOSÍ");
        estadosEnString.put(Estado.Sinaloa, "SINALOA");
        estadosEnString.put(Estado.Sonora, "SONORA");
        estadosEnString.put(Estado.Tabasco, "TABASCO");
        estadosEnString.put(Estado.Tamaulipas, "TAMAULIPAS");
        estadosEnString.put(Estado.Tlaxcala, "TLAXCALA");
        estadosEnString.put(Estado.Veracruz, "VERACRUZ");
        estadosEnString.put(Estado.Yucatan, "YUCATÁN");
        estadosEnString.put(Estado.Zacatecas, "ZACATECAS");
        estadosEnString.put(Estado.Nacido_En_Extranjero, "NACIDO EN EXTRANJERO");
        
    }

    public static String getEntidadFederativa(Estado estado){
        return EntidadFederativa.getInstance().getEntidadesFederativas().get(estado);
    }

    public static String getStringEstado(Estado estado){
        return EntidadFederativa.getInstance().getStringsEstado().get(estado);
    }

    private static EntidadFederativa getInstance(){
        if (instance == null) {
            instance = new EntidadFederativa();
        }
        return instance;
    }

    private HashMap<Estado, String> getEntidadesFederativas(){
        return entidadesFederativas;
    }

    private HashMap<Estado, String> getStringsEstado(){
        return estadosEnString;
    }

}