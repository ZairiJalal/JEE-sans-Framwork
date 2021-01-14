package dao;

import java.util.List;

import entities.Livre;

public class TestDao {

	public static void main(String[] args) {
		
		/*
		 * Test la méthode save de la classe ProduitDaoImp.
		 */		
		LivreDaoImp dao = new LivreDaoImp();
		dao.addLivre(new Livre("Samsung","Samsung", (double) 50000, 4));
		dao.addLivre(new Livre("Iphone","Iphone", (double) 60000, 7));
		dao.addLivre(new Livre("Nokia","Nokia", (double) 70000, 2));
		
		/*
		 * Test la méthode save de la classe ProduitDaoImp.
		 */
		List<Livre> produits = dao.chercherLivresParMC("%%");
		for (Livre p:produits) {	
			System.out.println(p.toString());
		}
		
	}

}
