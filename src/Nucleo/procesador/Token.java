package Nucleo.procesador;

public class Token {

    public static final int NUM = 0; // Numero Valor
    public static final int STRING = 1; // String Constante
    public static final int FUNC = 2; // Alguna Funcion
    public static final int GB = 3; //Guion Bajo
    public static final int CA = 4; // Corchete Abierto
    public static final int CC = 5; // Corchete Cerrado
    public static final int COMA = 6; // Coma ,
    public static final int FIN = 7;
    public static final int ERROR = 8;
    public static final int TRUE = 9;
    public static final int FALSE = 10;
    public static final int HELP = 11;
    public static final int HELPGLOBAL = 12;

    public static final int INSERTARESTADO = 20;
    public static final int EDITARESTADO = 21;
    public static final int LISTARESTADO = 22;
    public static final int ELIMINARESTADO = 23;

    ///Modulo Usuario
    public static final int INSERTARUSUARIO = 50;
    public static final int EDITARUSUARIO = 51;
    public static final int LISTARUSUARIO = 52;
    public static final int ELIMINARUSUARIO = 53;

    ///Modulo Asignacion
    public static final int INSERTARASIGNACION = 54;
    public static final int EDITARASIGNACION = 55;
    public static final int ELIMINARASIGNACION = 56;
    public static final int LISTARASIGNACION = 57;

    ///Modulo Inventario
    public static final int INSERTARINVENTARIO = 58;
    public static final int EDITARINVENTARIO = 59;
    public static final int ELIMINARINVENTARIO = 60;
    public static final int LISTARINVENTARIO = 61;

    private int nombre;
    private int atributo;
    private String toStr;

    public Token() {
    }

    public Token(int nombre, int atributo, String toStr) {
        this.nombre = nombre;
        this.atributo = atributo;
        this.toStr = toStr;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getAtributo() {
        return atributo;
    }

    public void setAtributo(int atributo) {
        this.atributo = atributo;
    }

    public String getToStr() {
        return toStr;
    }

    public void setToStr(String toStr) {
        this.toStr = toStr;
    }

}
