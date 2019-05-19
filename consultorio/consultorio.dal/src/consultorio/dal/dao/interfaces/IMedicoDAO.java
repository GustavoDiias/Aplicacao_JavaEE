package consultorio.dal.dao.interfaces;

import java.util.*;

import consultorio.dal.entidade.*;
import consultorio.dal.generics.*;

public interface IMedicoDAO extends IGenericDAO<Medico, Integer>{

	public List<Medico> findByEspecialidade(String nomeEspecialidade);
	public List<Medico> findByHospital(String nomeHospital);
}
