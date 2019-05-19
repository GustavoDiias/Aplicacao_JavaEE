package consultorio.dal.dao;

import javax.enterprise.context.RequestScoped;

import consultorio.dal.dao.interfaces.IUsuarioDAO;
import consultorio.dal.entidade.Usuario;
import consultorio.dal.generics.JPAGenericDAO;

@RequestScoped
public class UsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements IUsuarioDAO{



}
