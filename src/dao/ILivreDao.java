package dao;

import java.util.List;

import entities.Livre;

public interface ILivreDao {
	
	public void addLivre(Livre l);
	public List<Livre> chercherLivresParMC(String mc);
	public Livre getProduit(Long id);
	public void updateProduit(Livre l);
	public void deleteProduit(Long id);

}
