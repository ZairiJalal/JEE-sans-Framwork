package web;

import java.util.List;

import entities.Livre;

public class LivreModel  {
	private String mc;
	private List<Livre> produits;
	
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public List<Livre> getProduits() {
		return produits;
	}
	public void setProduits(List<Livre> produits) {
		this.produits = produits;
	}
	
	

}
