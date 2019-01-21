package com.uniformes.distribucionSPPI.DTO;

public class PendientesSPPI {
	
	int pedido;
	int empleado;
	int monto;
	
	public int getPedido() {
		return pedido;
	}
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
	public int getEmpleado() {
		return empleado;
	}
	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	
	@Override
	public String toString() {
		return "Pendientes MOD ********SPPI [pedido=" + pedido + ", empleado=" + empleado + ", monto=" + monto + "]";
	}
}
