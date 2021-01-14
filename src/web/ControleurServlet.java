package web;

import java.io.IOException;
import java.util.List;

import dao.ILivreDao;
import dao.LivreDaoImp;
import entities.Livre;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ILivreDao metier;
	
	@Override
	public void init() throws ServletException {
		metier = new LivreDaoImp();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		  String path = req.getServletPath();
		  if (path.equals("/livresPaMC.php")) {		 
			   String mc = req.getParameter("mc");
			   LivreModel livreModel = new LivreModel();
			   livreModel.setMc(mc);
			   List<Livre> produits = metier.chercherLivresParMC("%"+mc+"%");
			   livreModel.setProduits(produits);
			   req.setAttribute("livreModel", livreModel);
			   req.getRequestDispatcher("livres.jsp").forward(req, resp);			
			} 
		    else if(path.equals("/addLivre.php")) { 
		    	  String nom = req.getParameter("nom"); 
		    	  String auteur = req.getParameter("auteur");
		    	  Double prix = Double.parseDouble(req.getParameter("prix")); 
		    	  int quantite = Integer.parseInt(req.getParameter("quantite")); 
		    	  metier.addLivre(new Livre(nom,auteur, prix, quantite));
				  resp.sendRedirect("livresPaMC.php?mc="); 
		    }
		    else if(path.equals("/suppProduit.php")) {
		    	Long id = Long.parseLong(req.getParameter("id")); 
		    	metier.deleteProduit(id);
		    	resp.sendRedirect("livresPaMC.php?mc=");  
			}
			else if(path.equals("/editProduit.php")) {
				  Long id = Long.parseLong(req.getParameter("id"));
				  String nom = req.getParameter("nom"); 
		    	  String auteur = req.getParameter("auteur");
		    	  Double prix = Double.parseDouble(req.getParameter("prix")); 
		    	  int quantite = Integer.parseInt(req.getParameter("quantite")); 
		    	  metier.updateProduit(new Livre(id,nom,auteur, prix, quantite));
		    	  resp.sendRedirect("livresPaMC.php?mc=");  
			}
			 
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          doGet(req, resp);
	}

	
	
	

}
