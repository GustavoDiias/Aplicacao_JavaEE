package consultorio.dal.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import consultorio.dal.dao.interfaces.IMedicoDAO;
import consultorio.dal.entidade.Medico;
import consultorio.dal.generics.JPAGenericDAO;

@RequestScoped
public class MedicoDAO extends JPAGenericDAO<Medico,Integer> implements IMedicoDAO {

	@Override
	public List<Medico> findByEspecialidade(String nomeEspecialidade) {
	
	TypedQuery<Medico> query =
				em.createQuery("select m from Medico as m where m.especialidade.descricao = :nomeEspecialidade order by m.especialidade.descricao",Medico.class);
	
	query.setParameter("nomeEspecialidade", nomeEspecialidade);
	
	return query.getResultList();
	}
	
	@Override
	public List<Medico> findByHospital(String nomeHospital) {
	
	TypedQuery<Medico> query =
				em.createQuery("select m from Medico as m where m.hospital.nome = :nomeHospital order by m.hospital.nome",Medico.class);
	
	query.setParameter("nomeHospital", nomeHospital);
	
	return query.getResultList();
	}
}
