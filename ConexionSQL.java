package com.frtsoft;

import java.sql.*;

public class ConexionSQL
{

    private Connection conexion;
    private Statement sentencia;
    private String sourceURL;
    private String user;
    private String password;

    //Constructores
    //Contructor por defecto
    public ConexionSQL()
    {
        conexion = null;
        sentencia = null;
        sourceURL = " ";
        user = " ";
        password = " ";
    }

    //Contructor con parametros
    public ConexionSQL(Connection conexion, Statement sentencia, String sourceURl,String user , String password)
    {
        this.conexion = conexion;
        this.sentencia = sentencia;
        this.sourceURL = sourceURl;
        this.user = user;
        this.password = password;
    }

    //Contructor de copia
    public ConexionSQL(ConexionSQL c)
    {
        this.conexion = c.getConexion();
        sentencia = c.getSentencia();
        sourceURL = c.getSourceURL();
        user = c.getUser();
        password = c.getPassword();
    }

    //Metodos Consultores
    public Connection getConexion() {
        return conexion;
    }
    public Statement getSentencia() {
        return sentencia;
    }
    public String getSourceURL() {
        return sourceURL;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }

    //Metodos Modificadores
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    public void setSentencia(Statement sentencia) {
        this.sentencia = sentencia;
    }
    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void conectar()
    {
        try
        {
            conexion = DriverManager.getConnection(sourceURL, user, password);
            sentencia = conexion.createStatement();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void desconectar()
    {
        try
        {
            sentencia.close();
            conexion.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error al realizar la desconexion");
        }
    }

    public boolean estadoConexionSQL()
    {
        boolean estadoConexion = false;

        if(conexion != null)
        {
            estadoConexion = true;
        }
        return(estadoConexion);
    }
}
