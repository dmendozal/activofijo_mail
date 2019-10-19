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

            + "REGISTRO DIAS DE OFERTA\n\n"
            + "INSERTARDIA[\"DIA\"]\n\n"
            + "MODIFICARDIA[ID,\"DIA\"]\n\n"
            + "ELIMINARDIA[ID]\n\n"
            + "LISTARDIA\n\n"
            + separador

            + "REGISTRO DE TIPOS DE OFERTAS\n\n"
            + "INSERTARTIPO[\"NOMBRE\",\"DESCRIPCION\"]\n\n"
            + "MODIFICARTIPO[\"NOMBRE\",\"DESCRIPCION\"]\n\n"
            + "ELIMINARTIPO[\"NOMBRE\"]\n\n"
            + "LISTARTIPO\n\n"
            + separador

            + "REGISTRO DE OFERTAS\n\n"
            + "INSERTAROFERTA[\"TITULO\",\"DESCRIPCION\",PRECIO,\"TIPO\"]\n\n"
            + "MODIFICAROFERTA[ID,\"TITULO\",\"DESCRIPCION\",PRECIO]\n\n"
            + "ELIMINAROFERTA[ID]\n\n"
            + "LISTAROFERTA\n\n"
            + separador

            + "REGISTRO DE PUBLICO OBJETIVO\n\n"
            + "INSERTARDIRIGIDO[\"DESCRIPCION\",ID_OFERTA]\n\n"
            + "MODIFICARDIRIGIDO[ID,\"DESCRIPCION\"]\n\n"
            + "ELIMINARDIRIGIDO[ID]\n\n"
            + "LISTARDIRIGIDO\n\n"
            + separador

            + "REGISTRO DE OBJETIVO DEL CURSO\n\n"
            + "INSERTAROBJETIVO[\"DESCRIPCION\",ID_OFERTA]\n\n"
            + "MODIFICAROBJETIVO[ID,\"DESCRIPCION\"]\n\n"
            + "ELIMINAROBJETIVO[ID]\n\n"
            + "LISTAROBJETIVO\n\n"
            + separador

            + "REGISTRO DE LA METODOLOGIA DEL CURSO\n\n"
            + "INSERTARMETODOLOGIA[\"DESCRIPCION\",ID_OFERTA]\n\n"
            + "MODIFICARMETODOLOGIA[ID,\"DESCRIPCION\"]\n\n"
            + "ELIMINARMETODOLOGIA[ID]\n\n"
            + "LISTARMETODOLOGIA\n\n"
            + separador

            + "REGISTRO DE CRONOGRAMA\n\n"
            + "INSERTARCRONOGRAMA[\"TITULO\",\"PERIODO\"]\n\n"
            + "MODIFICARCRONOGRAMA[ID,\"TITULO\",\"PERIODO\"]\n\n"
            + "ELIMINARCRONOGRAMA[ID]\n\n"
            + "LISTARCRONOGRAMA\n\n"
            + separador

            + "REGISTRO DEL DETALLE DEL CRONOGRAMA\n\n"
            + "INSERTARDETALLECRONOGRAMA[ID_CRONOGRAMA,ID_OFERTA]\n\n"
            + "ELIMINARDETALLECRONOGRAMA[ID_DETALLE]\n\n"
            + "LISTARDETALLECRONOGRAMA\n\n"
            + separador

            + "REGISTRO DE REQUISITOS\n\n"
            + "INSERTARREQUISITO[\"DESCRIPCION\",ID_OFERTA]\n\n"
            + "MODIFICARREQUISITO[ID,\"DESCRIPCION\"]\n\n"
            + "ELIMINARREQUISITO[ID]\n\n"
            + "LISTARREQUISITO\n\n"
            + separador

            + "REGISTRO DE ROL DE USUARIOS\n\n"
            + "INSERTARROL[\"DESCRIPCION\"]\n\n"
            + "MODIFICARROL[ID,\"DESCRIPCION\"]\n\n"
            + "ELIMINARROL[ID]\n\n"
            + "LISTARROL\n\n"
            + separador

            + "REGISTRO DE GRUPOS DE USUARIOS\n\n"
            + "INSERTARGRUPO[\"NOMBRE\",\"DESCRIPCION\",ID_ROL]\n\n"
            + "MODIFICARGRUPO[ID,\"NOMBRE\",\"DESCRIPCION\"]\n\n"
            + "ELIMINARGRUPO[ID]\n\n"
            + "LISTARGRUPO\n\n"
            + separador

            + "REGISTRO DE USUARIOS\n\n"
            + "INSERTARUSUARIO[\"NOMBRE\",\"EMAIL\",\"PASSWORD\",TIPO,\"ESPECIALIDAD\",\"ACERDADE\",\"TELEFONO\",ID_GRUPOID]\n\n"
            + "MODIFICARUSUARIO[ID,\"NOMBRE\",\"EMAIL\",\"PASSWORD\",TIPO,\"PROFESION\",\"ACERDADE\",\"TELEFONO\",ID_GRUPOID]\n\n"
            + "ELIMINARUSUARIO[ID]\n\n"
            + "LISTARUSUARIOS\n\n"
            + separador

            + "REGISTRO DE RESERVAS\n\n"
            + "INSERTARRESERVA[\"FECHA\",\"DESCRIPCION\",ID_USUARIO,ID_OFERTA]\n\n"
            + "MODIFICARRESERVA[ID,\"FECHA\",\"DESCRIPCION\"]\n\n"
            + "ELIMINARRESERVA[ID]\n\n"
            + "LISTARRESERVA\n\n"
            + separador

            + "REGISTRO DE PAGO\n\n"
            + "INSERTARPAGO[MONTO,\"TIPO_PAGO\"]\n\n"
            + "MODIFICARPAGO[ID,MONTO,\"TIPO_PAGO\"]\n\n"
            + "ELIMINARPAGO[ID]\n\n"
            + "LISTARPAGO\n\n"
            + separador

            + "REGISTRO DE VENTA\n\n"
            + "INSERTARVENTA[MONTO,ID_USUARIO]\n\n"
            + "MODIFICARVENTA[ID,MONTO]\n\n"
            + "ELIMINARVENTA[ID]\n\n"
            + "LISTARVENTA\n\n"
            + separador

            + "REGISTRO DE DETALLE DE VENTA\n\n"
            + "INSERTARDETALLEVENTA[\"FECHA\",ID_VENTA,ID_OFERTA,ID_PAGO,ID_USUARIO]\n\n"
            + "MODIFICARDETALLEVENTA[ID,\"FECHA\"]\n\n"
            + "ELIMINARDETALLEVENTA[ID]\n\n"
            + "LISTARDETALLEVENTA\n\n"
            + separador

            + "REGISTRO DE BOLETA\n\n"
            + "INSERTARBOLETA[MONTO,ID_PAGO]\n\n"
            + "MODIFICARBOLETA[ID,MONTO]\n\n"
            + "ELIMINARBOLETA[ID]\n\n"
            + "LISTARBOLETA\n\n"
            + separador

            + "REGISTRO DE ASIGNACION DE OFERTA - CLIENTE\n\n"
            + "INSERTARPO[ID_USAURIO,ID_OFERTA]\n\n"
            + "ELIMINARPO[ID]\n\n"
            + "LISTARPO\n\n"
            + separador

            + "REGISTRO DE ASIGNACION DE OFERTA - DOCENTE\n\n"
            + "INSERTARDO[ID_OFERTA,ID_DOCENTE]\n\n"
            + "ELIMINARDO[ID]\n\n"
            + "LISTARDO\n\n"
            + separador

            + "Muestre los reportes:\n"
                    + "REPORTE\n\n"
                    + separador;
}
