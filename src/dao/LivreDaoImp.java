package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Livre;

public class LivreDaoImp implements ILivreDao {

	@Override
	public void addLivre(Livre l) {
		
		  Connection connection = SingletonConnection.getConnection(); try {
		  PreparedStatement ps = connection.
		  prepareStatement("INSERT INTO LIVRES (NOM,AUTEUR,PRIX,QUANTITE) VALUES(?,?,?,?)"
		  ); ps.setString(1, l.getNom()); ps.setString(2, l.getAuteur());
		  ps.setDouble(3, l.getPrix()); ps.setInt(4, l.getQuantite());
		  ps.executeUpdate(); PreparedStatement ps2 =
		  connection.prepareStatement("SELECT MAX(ID) as MAXID FROM LIVRES"); ResultSet
		  rs = ps2.executeQuery();
		  
		  if(rs.next()) { l.setId(rs.getLong("MAXID")); } ps.close(); } catch
		  (SQLException e) { e.printStackTrace(); }
		 
	}

	@Override
	public List<Livre> chercherLivresParMC(String mc) {
		List<Livre> livres = new ArrayList<Livre>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM LIVRES WHERE NOM LIKE ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				Livre l = new Livre() ;
				l.setId(rs.getLong("ID"));
				l.setNom(rs.getString("NOM"));
				l.setAuteur(rs.getString("AUTEUR"));
				l.setPrix(rs.getDouble("PRIX"));
				l.setQuantite(rs.getInt("QUANTITE"));
				livres.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livres;
	}

	@Override
	public Livre getProduit(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduit(Livre l) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE LIVRES set NOM = ?,AUTEUR = ?,PRIX = ?, QUANTITE = ? where ID = ?");
		    ps.setString(1, l.getNom());
		    ps.setString(2, l.getAuteur());
		    ps.setDouble(3, l.getPrix());
		    ps.setInt(4, l.getQuantite());
		    ps.setLong(5, l.getId());
		    ps.executeUpdate();
		    ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduit(Long id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM LIVRES WHERE ID=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

}
