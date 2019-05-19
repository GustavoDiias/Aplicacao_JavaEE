package consultorio.test;

import java.util.*;
import javax.ejb.embeddable.*;
import javax.naming.*;

import consultorio.dal.entidade.*;
import consultorio.dal.dao.interfaces.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Properties p = new Properties();
		p.put("consultorioDB", "new://Resource?type=DataSource");
		p.put("consultorioDB.JdbcDriver", "com.mysql.jdbc.Driver");
		p.put("consultorioDB.JdbcUrl","jdbc:mysql://localhost:3306/consultorio");
		p.put("consultorioDB.userName","root");
		p.put("consultorioDB.password","root");
		
		
		Context context = EJBContainer.createEJBContainer(p).getContext();
		
		IEspecialidadeDAO especialidadeDAO = (IEspecialidadeDAO) context
				.lookup("java:global/consultorio.dal/EspecialidadeDAO");
	
		
		Especialidade especialidade = new Especialidade();
		especialidade.setDescricao("Cirurgião");
		especialidadeDAO.insert(especialidade);
		
		
		List<Especialidade> especialidades = especialidadeDAO.findAll();
		
		for (Especialidade e : especialidades) {
			System.out.println(e.getDescricao());
		}
	
	}
}
