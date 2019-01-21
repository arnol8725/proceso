package com.uniformes.distribucionSPPI.DAO;
import org.springframework.stereotype.Component;
import com.uniformes.distribucionSPPI.config.ConfigSPPI;
import javax.naming.Context;
import javax.sql.DataSource;
import java.sql.Connection;
import javax.naming.InitialContext;
import org.springframework.beans.factory.annotation.Autowired;


@Component
public class FabricaDAOSPPI {
	
	@Autowired
    private ConfigSPPI config;
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
