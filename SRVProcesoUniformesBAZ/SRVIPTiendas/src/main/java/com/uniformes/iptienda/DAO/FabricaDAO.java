package com.uniformes.iptienda.DAO;

import org.springframework.stereotype.Component;

import com.uniformes.iptienda.config.ConfigIPTiendas;

import javax.naming.Context;
import javax.sql.DataSource;
import java.sql.Connection;
import javax.naming.InitialContext;
import org.springframework.beans.factory.annotation.Autowired;


@Component
public class FabricaDAO {
	
	@Autowired
    private ConfigIPTiendas config;
	private Context contexto;
    private Connection conexion;
    private DataSource dataSource;

    public Connection getConexion() throws Exception {
        try {

            if (dataSource == null) {
                contexto = new InitialContext();
                dataSource = ((DataSource) contexto.lookup(config.DATASORACLE));
            }
            if (dataSource != null) {
                conexion = dataSource.getConnection();

            }
        } catch (Exception ne) {
            throw new Exception("FabricaDAO: Ocurrio un Error en la conexion " + ne.getMessage());
        }
        return conexion;
    }

    public void setContexto(Context contex) {
        contexto = contex;
    }

	
}
