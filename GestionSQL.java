package com.frtsoft;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GestionSQL
{
    /*	Cabecera : public boolean checkUsuario(ConexionBaseDatos conexion,String nickName,String password)
     * 	Descripcion:comprobara si el nombre y la contrase�a son correctas
     * 	Entradas:la conexion ,el nombre y la contrase�a
     * 	Salidas:un boolean
     *  Postcondiciones:devolvera true si es correcto y falso si no lo es
     */
    public boolean checkUsuario(ConexionBaseDatos conexion,String nickName,String password)
    {
        boolean check = false;

        try {
            ResultSet resultado = conexion.getSentencia().executeQuery("Select dbo.ComprobarUsuario('"+nickName+"','"+password+"')");
            resultado.next();
            int num = resultado.getInt(1);
            if(num == 1){
                check = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en el check del usuario");
        }
        return (check);
    }

    /*		Cabecera : public void verPerfil(ConexionBaseDatos coneccionCliente,String nombreUsuario)
     * 	Descripcion:este pedira la informacion del perfil del usuario de la base de datos y lo pintara en pantalla
     * 	Entradas:la conexion con la base de datos , el nombre del usuario
     * 	Salidas:solo pinta
     *  Postcondiciones:pintara en pantalla una cadena con la informacion de perfil
     */
    public void verPerfil(ConexionBaseDatos coneccionCliente,String nombreUsuario){
        try {
            ResultSet res = coneccionCliente.getSentencia().executeQuery("Select Nombre , Apellidos , Direccion , Ciudad , Telefono1 , CorreoElectronico FROM dbo.perfil('"+nombreUsuario+"')");

            res.next();
            System.out.println();
            System.out.println("Este es su perfil :");
            System.out.println();
            System.out.println("	Nombre : "+res.getString(1)+" , Apellidos : "+res.getString(2));
            System.out.println("	Direccion : "+res.getString(3)+" , Ciudad : "+res.getString(4));
            System.out.println("    Telefono : "+res.getString(5)+" , Correo-Electronico : "+res.getString(6));
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /*		Cabecera : public void editarCiudad(ConexionBaseDatos coneccion)				--COMPLETAR METODO
 * 	Descripcion:le pedira al usuario si realmente desea cambiarla y le pedira una nueva y la cambiara
 * 	Entradas:la coneccion con la base de datos
 * 	Salidas:
 *  Postcondiciones:
 *
 *  Pseudocodigo:
 *  	Inicio
 *  		PintarCiudadYPreguntarSiQuiereCambiar
 *  		Si cambiar=Si
 *  			PreguntarNuevaCiudad
 *  			ModificarCiudad
             FinSi
         fin

 */
    public void editarCiudad(ConexionBaseDatos coneccion){
        //Inicio

        //Variables
        char respuesta = 'N';
        String ciudad = " ";
        Scanner	 teclado = new Scanner(System.in);


        //PintarCiudadYPreguntarSiQuiereCambiar
        do{
            System.out.println();
            try {
                System.out.println("Su ciudad es "+coneccion.getSentencia().executeQuery(""));	//CREAR LLAMADA EN  SQL
                System.out.println("Esta seguro que desea cabiar ? --> S o N");
                respuesta = teclado.next().toUpperCase().charAt(0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }while(respuesta!='S' && respuesta!='N');
        //Si cambiar=Si
        if(respuesta=='S'){
            //PreguntarNuevaCiudad
            System.out.println();
            System.out.print("Introduzca su nueva ciudad :");
            ciudad = teclado.next();
            //ModificarCiudad
            try {
                coneccion.getSentencia().executeQuery(" ");		//ÇREAR SENTENCIA EN SQL
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // FinSi
        }

        //fin

    }
}
