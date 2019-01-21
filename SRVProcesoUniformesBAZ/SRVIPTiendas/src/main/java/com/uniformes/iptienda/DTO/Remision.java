package com.uniformes.iptienda.DTO;

public class Remision {
	
	int sucursal;
	int pedido;
	int remision;
	int sku;
	
	
	public int getSucursal() {
		return sucursal;
	}
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	public int getPedido() {
		return pedido;
	}
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
	public int getRemision() {
		return remision;
	}
	public void setRemision(int remision) {
		this.remision = remision;
	}
	public int getSku() {
		return sku;
	}
	public void setSku(int sku) {
		this.sku = sku;
	}
	
	@Override
	public String toString() {
		return "Remision [sucursal=" + sucursal + ", pedido=" + pedido + ", remision=" + remision + ", sku=" + sku
				+ "]";
	}
}
