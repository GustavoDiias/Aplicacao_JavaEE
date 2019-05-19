package consultorio.dal.dao;

import javax.enterprise.context.RequestScoped;

import consultorio.dal.dao.interfaces.IAtendimentoDAO;
import consultorio.dal.entidade.Atendimento;
import consultorio.dal.generics.JPAGenericDAO;

@RequestScoped
public class AtendimentoDAO extends JPAGenericDAO<Atendimento, Integer> implements IAtendimentoDAO {

}
