package consultorio.dal.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import consultorio.dal.dao.interfaces.IPacienteDAO;
import consultorio.dal.entidade.Paciente;
import consultorio.dal.generics.JPAGenericDAO;

@RequestScoped
public class PacienteDAO extends JPAGenericDAO<Paciente, Integer> implements IPacienteDAO{
	
	@Override
	public List<Paciente> findByDoenca(String nomeDoenca) {
		
		TypedQuery<Paciente> query =
					em.createQuery("select p from Paciente as p where p.doenca.descricao = :nomeDoenca order by p.doenca.descricao",Paciente.class);
		
		query.setParameter("nomeDoenca", nomeDoenca);
		
		return query.getResultList();
	}
}
