package edu.continental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.continental.util.ToJSON;
import edu.continental.util.conexion;
import org.codehaus.jettison.json.JSONArray;



public class ciudadesDAO {

	public JSONArray listaCiudades()
	{
		conexion cn=new conexion();
		Connection con = cn.getConnection();
		
		String sql="select id,nombre,altitud,estado from ciudad where estado='A'";
		Statement st=null;
		ResultSet rs=null;
		ToJSON convertidor =new ToJSON();
		JSONArray arreglo =new JSONArray();
		
		
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			arreglo=convertidor.toJSONArray(rs);
			st.close();
			
		} catch(Exception ex){
			System.out.println("error" +ex.getMessage());
			return null;
		}
		return arreglo;
		
	}
}
