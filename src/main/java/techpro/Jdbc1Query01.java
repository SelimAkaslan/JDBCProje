package techpro;

import java.sql.*;

public class Jdbc1Query01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1. DRIVER (SÜRÜCÜ) EKLEME
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. VERİTABANI BAĞLANTISI OLUŞTURMA
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain","system","Oradoc_db1");
		
		// 3. SQL İFADESİ OLUŞTURMA VE ÇALIŞTIRMA
		Statement st = con.createStatement();
		
		// 4. SQL IFADELERI YAZABILIR VE CALISTIRABILIRIZ
		 //ResultSet rs = st.executeQuery("SELECT bolum_isim FROM bolumler WHERE bolum_id=20");
		 ResultSet rs1 = st.executeQuery("SELECT personel_isim, maas FROM personel WHERE personel_id=7369");
		 
		 
		 // 5. SONUCLARI ALDIK VE ISLEDIK
		/*
		while(rs.next()) {
		System.out.println("Bolum Adi:" + rs.getString("bolum_isim"));
		}*/
		 
		while(rs1.next()) {
			System.out.println("Personel Adi: " + rs1.getString("personel_isim"));
			System.out.println("Personel Adi: " + rs1.getString(1)+", " + "Maas: "+ rs1.getInt(2));
		}
		
		// 6. OLUSTURULAN NESNELERI BELLEKTEN KALDIRALIM
		con.close();
		st.close();
		rs1.close();
		
		
	}
	
	

}
