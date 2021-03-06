package Nucleo.procesador;

import java.util.Arrays;
import java.util.LinkedList;

public class LCC {

    private static final LinkedList<String> comandos = new LinkedList<>(Arrays.asList(
            "HELP",
            "TRUE",
            "FALSE",
            //::: ESTADO ::://
            "INSERTARESTADO",
            "EDITARESTADO",
            "LISTARESTADO",
            "ELIMINARESTADO",
            //::: MANTENIMIENTO ::://
            "INSERTARMANTENIMIENTO",
            "EDITARMANTENIMIENTO",
            "LISTARMANTENIMIENTO",
            "ELIMINARMANTENIMIENTO",
            //::: BIEN ::://
            "INSERTARBIEN",
            "EDITARBIEN",
            "LISTARBIEN",
            "ELIMINARBIEN",
            //::: ACTIVO :::// 
            "INSERTARACTIVO",
            "EDITARACTIVO",
            "LISTARACTIVO",
            "ELIMINARACTIVO",
            ///Modulo Estado
            "INSERTARESTADO",
            "EDITARESTADO",
            "LISTARESTADO",
            "ELIMINARESTADO",
            ///Modulo Usuario
            "INSERTARUSUARIO",
            "EDITARUSUARIO",
            "LISTARUSUARIO",
            "ELIMINARUSUARIO",
            ///Modulo Asignacion
            "INSERTARASIGNACION",
            "EDITARASIGNACION",
            "ELIMINARASIGNACION",
            "LISTARASIGNACION",
            ///Modulo INVENTARIO
            "INSERTARINVENTARIO",
            "EDITARINVENTARIO",
            "ELIMINARINVENTARIO",
            "LISTARINVENTARIO",
            ////cargo
            "INSERTARCARGO",
            "EDITARCARGO",
            "LISTARCARGO",
            "ELIMINARCARGO",
            "INSERTARUBICACION",
            "EDITARUBICACION",
            "LISTARUBICACION",
            "ELIMINARUBICACION",
            "INSERTAREMPRESA",
            "EDITAREMPRESA",
            "LISTAREMPRESA",
            "ELIMINAREMPRESA",
            "LISTARREPORTE",
            "LISTARREPORTEACTIVOSUSUARIOS"
    ));

    private static final LinkedList<Token> tokens = new LinkedList<>(Arrays.asList(
            new Token(Token.HELP, -1, "HELP"),
            new Token(Token.TRUE, -1, "TRUE"),
            new Token(Token.FALSE, -1, "FALSE"),
            //::: ESTADO ::://
            new Token(Token.FUNC, Token.INSERTARESTADO, "INSERTARESTADO"),
            new Token(Token.FUNC, Token.EDITARESTADO, "EDITARESTADO"),
            new Token(Token.FUNC, Token.LISTARESTADO, "LISTARESTADO"),
            new Token(Token.FUNC, Token.ELIMINARESTADO, "ELIMINARESTADO"),
            //::: MANTENIMIENTO ::://
            new Token(Token.FUNC, Token.INSERTARMANTENIMIENTO, "INSERTARMANTENIMIENTO"),
            new Token(Token.FUNC, Token.EDITARMANTENIMIENTO, "EDITARMANTENIMIENTO"),
            new Token(Token.FUNC, Token.LISTARMANTENIMIENTO, "LISTARMANTENIMIENTO"),
            new Token(Token.FUNC, Token.ELIMINARMANTENIMIENTO, "ELIMINARMANTENIMIENTO"),
            //::: BIEN ::://
            new Token(Token.FUNC, Token.INSERTARBIEN, "INSERTARBIEN"),
            new Token(Token.FUNC, Token.EDITARBIEN, "EDITARBIEN"),
            new Token(Token.FUNC, Token.LISTARBIEN, "LISTARBIEN"),
            new Token(Token.FUNC, Token.ELIMINARBIEN, "ELIMINARBIEN"),
            //::: ACTIVO ::://
            new Token(Token.FUNC, Token.INSERTARACTIVO, "INSERTARACTIVO"),
            new Token(Token.FUNC, Token.EDITARACTIVO, "EDITARACTIVO"),
            new Token(Token.FUNC, Token.LISTARACTIVO, "LISTARACTIVO"),
            new Token(Token.FUNC, Token.ELIMINARACTIVO, "ELIMINARACTIVO"),
            new Token(Token.FUNC, Token.INSERTARESTADO, "INSERTARESTADO"),
            new Token(Token.FUNC, Token.EDITARESTADO, "EDITARESTADO"),
            new Token(Token.FUNC, Token.LISTARESTADO, "LISTARESTADO"),
            new Token(Token.FUNC, Token.ELIMINARESTADO, "ELIMINARESTADO"),
            //Modulo Usuario
            new Token(Token.FUNC, Token.INSERTARUSUARIO, "INSERTARUSUARIO"),
            new Token(Token.FUNC, Token.EDITARUSUARIO, "EDITARUSUARIO"),
            new Token(Token.FUNC, Token.LISTARUSUARIO, "LISTARUSUARIO"),
            new Token(Token.FUNC, Token.ELIMINARUSUARIO, "ELIMINARUSUARIO"),
            //Modulo Asignacion
            new Token(Token.FUNC, Token.INSERTARASIGNACION, "INSERTARASIGNACION"),
            new Token(Token.FUNC, Token.EDITARASIGNACION, "EDITARASIGNACION"),
            new Token(Token.FUNC, Token.ELIMINARASIGNACION, "ELIMINARASIGNACION"),
            new Token(Token.FUNC, Token.LISTARASIGNACION, "LISTARASIGNACION"),
            ///Modulo Inventario
            new Token(Token.FUNC, Token.INSERTARINVENTARIO, "INSERTARASIGNACION"),
            new Token(Token.FUNC, Token.EDITARINVENTARIO, "EDITARINVENTARIO"),
            new Token(Token.FUNC, Token.ELIMINARINVENTARIO, "ELIMINARINVENTARIO"),
            new Token(Token.FUNC, Token.LISTARINVENTARIO, "LISTARINVENTARIO"),
            new Token(Token.FUNC, Token.INSERTARCARGO, "INSERTARCARGO"),
            new Token(Token.FUNC, Token.EDITARCARGO, "EDITARCARGO"),
            new Token(Token.FUNC, Token.LISTARCARGO, "LISTARCARGO"),
            new Token(Token.FUNC, Token.ELIMINARCARGO, "ELIMINARCARGO"),
            new Token(Token.FUNC, Token.INSERTARUBICACION, "INSERTARUBICACION"),
            new Token(Token.FUNC, Token.EDITARUBICACION, "EDITARUBICACION"),
            new Token(Token.FUNC, Token.LISTARUBICACION, "LISTARUBICACION"),
            new Token(Token.FUNC, Token.ELIMINARUBICACION, "ELIMINARUBICACION"),
            new Token(Token.FUNC, Token.INSERTAREMPRESA, "INSERTAREMPRESA"),
            new Token(Token.FUNC, Token.EDITAREMPRESA, "EDITAREMPRESA"),
            new Token(Token.FUNC, Token.LISTAREMPRESA, "LISTAREMPRESA"),
            new Token(Token.FUNC, Token.ELIMINAREMPRESA, "ELIMINAREMPRESA"),
            new Token(Token.FUNC, Token.LISTARREPORTE, "LISTARREPORTE"),
            new Token(Token.FUNC, Token.LISTARREPORTEACTIVOSUSUARIOS, "LISTARREPORTEACTIVOSUSUARIOS")
    ));

    public static Token estaEnLCC(String lexema) {
        lexema = lexema.toUpperCase();
        for (int i = 0; i < comandos.size(); i++) {
            if (comandos.get(i).toUpperCase().equals(lexema)) {
                Token token = new Token();
                token.setNombre(tokens.get(i).getNombre());
                token.setAtributo(tokens.get(i).getAtributo());
                token.setToStr(tokens.get(i).getToStr());
                return token;
            }
        }
        return null;
    }
}
