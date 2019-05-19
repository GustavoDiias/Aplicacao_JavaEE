package consultorio.dal.dao;

import javax.enterprise.context.RequestScoped;

import consultorio.dal.dao.interfaces.IHospitalDAO;
import consultorio.dal.entidade.Hospital;
import consultorio.dal.generics.JPAGenericDAO;

@RequestScoped
public class HospitalDAO extends JPAGenericDAO<Hospital,Integer> implements IHospitalDAO{

}
