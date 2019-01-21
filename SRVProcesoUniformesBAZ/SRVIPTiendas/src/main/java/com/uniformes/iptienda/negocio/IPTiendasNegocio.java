package com.uniformes.iptienda.negocio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniformes.iptienda.DAO.IPTiendasDAO;
import com.uniformes.iptienda.DTO.Remision;

@Service
public class IPTiendasNegocio {
	
	@Autowired
    private IPTiendasDAO dao;
	
	public String ejecuta() throws Exception {
		ArrayList<Remision> rem = dao.consulta();
		System.out.println("Se obtuvieron : " + rem.size() + " remisiones");
		for (Remision r :  rem) {
			System.out.println(r.toString());
		}
		return "Hola desde service";
	}
}
