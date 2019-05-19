package consultorio.dal.dao;

import javax.enterprise.context.RequestScoped;

import consultorio.dal.dao.interfaces.IEspecialidadeDAO;
import consultorio.dal.entidade.Especialidade;
import consultorio.dal.generics.JPAGenericDAO;

@RequestScoped
public class EspecialidadeDAO extends JPAGenericDAO<Especialidade,Integer> implements IEspecialidadeDAO{

}
