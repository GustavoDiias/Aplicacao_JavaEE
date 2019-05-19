package consultorio.bll.interfaces;

import java.util.List;

import consultorio.bll.util.Mensagem;
import consultorio.dal.entidade.Especialidade;

public interface IEspecialidadeEJB {

	public Mensagem salvar(Especialidade especialidade);
	public Mensagem excluir(Integer idEspecialidade);
	public List<Especialidade> listar();
	
}
