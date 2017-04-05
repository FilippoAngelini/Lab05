package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammiDAO {
	
	public boolean controllaAnagramma(String anagramma) {

		final String sql = "SELECT * FROM parole";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			
			boolean trovata = false;

			while (rs.next()) {
				
				if(anagramma.equals(rs.getString("nome"))){
					trovata = true;
					break;
				}
				

			}
			
			//conn.close();

			return trovata;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}

}
