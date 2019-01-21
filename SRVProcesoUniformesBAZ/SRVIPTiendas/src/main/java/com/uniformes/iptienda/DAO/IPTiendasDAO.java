package com.uniformes.iptienda.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniformes.iptienda.DTO.Remision;
import com.uniformes.iptienda.config.ConfigIPTiendas;

import oracle.jdbc.OracleTypes;

@Component
public class IPTiendasDAO {
	
	@Autowired
    private ConfigIPTiendas config;
	
	@Autowired
    private FabricaDAO fabricaDAO;
	
	public ArrayList<Remision> consulta() throws Exception {
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        ArrayList<Remision> rem = null;
        try {
            conn = fabricaDAO.getConexion();

            if (conn == null) {
                throw new Exception("La conexion no se creo.");
            }
            cs = conn.prepareCall(config.FN_CONS_REM);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
            rem = new ArrayList<Remision>();
            while(rs.next()) {
            	Remision r = new Remision();
            	r.setSucursal(rs.getInt("FISUCURSAL"));
            	r.setPedido(rs.getInt("FIPEDIDO"));
            	r.setRemision(rs.getInt("FINUMREMISION"));
            	r.setSku(rs.getInt("FISKU"));
            	rem.add(r);
            }

        } catch (Exception e) {
            throw new Exception("ERROR en : " + this.getClass() + " metodo: getCoberturaDesglose " + e.getMessage());
        } finally {
            close(conn, cs, rs);
        }
        return rem;
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
