package consultorio.dal.dao;

import javax.enterprise.context.RequestScoped;

import consultorio.dal.dao.interfaces.IDoencaDAO;
import consultorio.dal.entidade.Doenca;
import consultorio.dal.generics.JPAGenericDAO;

@RequestScoped
public class DoencaDAO extends JPAGenericDAO<Doenca,Integer> implements IDoencaDAO{

}
