package com.uniformes.distribucionSPPI.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniformes.distribucionSPPI.DTO.PendientesSPPI;
import com.uniformes.distribucionSPPI.config.ConfigSPPI;

import oracle.jdbc.OracleTypes;

@Component
public class DistribucionSPPIDAO {
	
	@Autowired
    private ConfigSPPI config;
	
	@Autowired
    private FabricaDAOSPPI fabricaDAO;
	
	public ArrayList<PendientesSPPI> consulta() throws Exception {
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        ArrayList<PendientesSPPI> sppi = null;
        try {
            conn = fabricaDAO.getConexion();

            if (conn == null) {
                throw new Exception("La conexion no se creo.");
            }
            cs = conn.prepareCall(config.SPCONSULTAPENDIENTESSPPI);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            sppi = new ArrayList<PendientesSPPI>();
            while(rs.next()) {
            	PendientesSPPI s = new PendientesSPPI();
            	s.setEmpleado(rs.getInt("FIEMPLEADO"));
            	s.setPedido(rs.getInt("FIPEDIDO"));
            	s.setMonto(150);
            	sppi.add(s);
            }

        } catch (Exception e) {
            throw new Exception("ERROR en : " + this.getClass() + " metodo: getCoberturaDesglose " + e.getMessage());
        } finally {
            close(conn, cs, rs);
        }
        return sppi;
    }

	
	
	private void close(Connection conn, CallableStatement cs, ResultSet rs) throws SQLException {

        if (cs != null) {
            cs.close();
            cs = null;
        }
        if (conn != null) {
            conn.close();
            conn = null;
        }
        if (rs != null) {
            rs.close();
            rs = null;
        }

    }

}
