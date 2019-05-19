package consultorio.dal.dao;

import javax.enterprise.context.RequestScoped;

import consultorio.dal.dao.interfaces.IConvenioDAO;
import consultorio.dal.entidade.Convenio;
import consultorio.dal.generics.JPAGenericDAO;

@RequestScoped
public class ConvenioDAO extends JPAGenericDAO<Convenio, Integer> implements IConvenioDAO{


	

}
