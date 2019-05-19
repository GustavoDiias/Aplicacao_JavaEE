package consultorio.bll.interfaces;

import java.util.List;

import consultorio.bll.util.Mensagem;
import consultorio.dal.entidade.Hospital;

public interface IHospitalEJB {

	public Mensagem salvar(Hospital hospital);
	public Mensagem excluir(Integer idHospital);
	public List<Hospital> listar();
}
