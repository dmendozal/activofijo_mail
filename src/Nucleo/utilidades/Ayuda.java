/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nucleo.utilidades;

/**
 *
 * @author isaias
 *
 */
public class Ayuda {

    public static String separador = "------------------------------------------------------------------------------\n\n";

    public static final String HELP_GLOBAL = "Bienvenido!!!\n\n"
            + "A continuacion se listaran los comandos disponibles para interactuar con el sistema\n"
            + "Ejemplo: COMANDO HELP\n"
            + separador
            + "REGISTRO DE ESTADOS\n\n"
            + "INSERTARESTADO[\"SIGLA\",\"NOMBRE\"]\n\n"
            + "EDITARESTADO[ID,\"SIGLA\",\"NOMBRE\"]\n\n"
            + "ELIMINARESTADO[ID]\n\n"
            + "LISTARESTADO\n\n"
            + separador
            + "REGISTRO DE MANTENNIMIENTO\n\n"
            + "INSERTARMANTENIMIENTO[\"FECHA INGRESO\",\"FECHA DEVOLUCION\",FKIDACTIVO,FKIDEMPRESA]\n\n"
            + "EDITARMANTENIMIENTO[ID,\"FECHA INGRESO\",\"FECHA DEVOLUCION\",FKIDACTIVO,FKIDEMPRESA]\n\n"
            + "ELIMINARMANTENIMIENTO[ID]\n\n"
            + "LISTARMANTENIMIENTO\n\n"
            + separador
            + "REGISTRO DE BIENES\n\n"
            + "INSERTARBIEN[\"NOMBRE\",\"DESCRIPCION\"]\n\n"
            + "EDITARBIEN[ID,\"NOMBRE\",\"DESCRIPCION\"]\n\n"
            + "ELIMINARBIEN[ID]\n\n"
            + "LISTARBIEN\n\n"
            + separador
            + "REGISTRO DE ACTIVO\n\n"
            + "INSERTARACTIVO[\"CODIGO\",FKID_ESTADO,FKID_BIEN,FKID_UBICACION]\n\n"
            + "EDITARACTIVO[ID,\"CODIGO\",FKID_ESTADO,FKID_BIEN,FKID_UBICACION]\n\n"
            + "ELIMINARACTIVO[ID]\n\n"
            + "LISTARACTIVO\n\n"
            + separador
            + "REGISTRO DE USUARIO\n\n"
            + "INSERTARUSUARIO[\"NOMBRE\",\"APELLIDO\",\"EMAIL\",\"PASSWORD\",\"DIRECCION\",\"TELEFONO\",ID_CARGO]\n\n"
            + "EDITARUSUARIO[ID,\"NOMBRE\",\"APELLIDO\",\"EMAIL\",\"PASSWORD\",\"DIRECCION\",\"TELEFONO\",ID_CARGO]\n\n"
            + "ELIMINARUSUARIO[ID]\n\n"
            + "LISTARUSUARIO\n\n"
            + separador
            + "REGISTRO DE ASIGNACION\n\n"
            + "INSERTARASIGNACION[ID_USUARIO,ID_BIEN]\n\n"
            + "EDITARASIGNACION[ID_USUARIO,ID_BIEN]\n\n"
            + "ELIMINARASIGNACION[ID_USUARIO,ID_BIEN]\n\n"
            + "LISTARASIGNACION\n\n"
            + separador
            + "REGISTRO DE INVENTARIO\n\n"
            + "INSERTARINVENTARIO[IDABIEN]\n\n"
            + "EDITARINVENTARIO[ID,IDABIEN]\n\n"
            + "ELIMINARINVENTARIO[ID]\n\n"
            + "LISTARINVENTARIO\n\n"
            + separador
            + "REGISTRO DEL CARGO DE USUARIO\n\n"
            + "INSERTARCARGO[\"NOMBRE\",\"DESCRIPCION\"]\n\n"
            + "EDITARCARGO[ID,\"NOMBRE\",\"DESCRIPCION\"]\n\n"
            + "ELIMINARCARGO[ID]\n\n"
            + "LISTARCARGO\n\n"
            + separador
            
            + "REGISTRO DE UBICACION\n\n"
            + "INSERTARUBICACION[AULA,PISO]\n\n"
            + "EDITARUBICACION[ID,AULA,PISO]\n\n"
            + "ELIMINARUBICACION[ID]\n\n"
            + "LISTARUBICACION\n\n"
            + separador
            + "REGISTRO DE ROL DE USUARIOS\n\n"
            
            + "INSERTARROL[\"DESCRIPCION\"]\n\n"
            + "EDITARUBICACION[ID,\"DESCRIPCION\"]\n\n"
            + "ELIMINARROL[ID]\n\n"
            + "LISTARROL\n\n"
            + separador
            
            + "REGISTRO DE EMPRESAS\n\n"
            + "INSERTAREMPRESA[\"RAZON SOCIAL\",\"EMAIL\",\"DIRECCION\",\"TELEFONO\"]\n\n"
            + "EDITAREMPRESA[ID,\"RAZON SOCIAL\",\"EMAIL\",\"DIRECCION\",\"TELEFONO\"]\n\n"
            + "ELIMINAREMPRESA[ID]\n\n"
            + "LISTAREMPRESA\n\n"
            
            + separador
            + "REPORTES\n\n"
            + "LISTARREPORTE\n\n"
            + separador;
}
