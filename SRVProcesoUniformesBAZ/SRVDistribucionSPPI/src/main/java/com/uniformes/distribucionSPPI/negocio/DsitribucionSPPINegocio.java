package com.uniformes.distribucionSPPI.negocio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniformes.distribucionSPPI.DAO.DistribucionSPPIDAO;
import com.uniformes.distribucionSPPI.DTO.PendientesSPPI;

@Service
public class DsitribucionSPPINegocio {
	
	@Autowired
    private DistribucionSPPIDAO dao;
	
	public String ejecuta() throws Exception {
		ArrayList<PendientesSPPI> pnd = dao.consulta();
		System.out.println("Se obtuvieron : " + pnd.size() + " pendientes de SPPI");
		for (PendientesSPPI p :  pnd) {
			System.out.println(p.toString());
		}
		return "fin SPPI SERVICES";
	}
}
