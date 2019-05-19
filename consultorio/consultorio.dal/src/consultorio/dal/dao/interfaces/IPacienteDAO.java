package consultorio.dal.dao.interfaces;

import java.util.List;

import consultorio.dal.entidade.*;
import consultorio.dal.generics.*;

public interface IPacienteDAO extends IGenericDAO<Paciente,Integer>{

	public List<Paciente> findByDoenca(String nomeDoenca);
}
