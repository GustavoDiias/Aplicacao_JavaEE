package consultorio.bll.interfaces;

import java.util.List;

import consultorio.bll.util.Mensagem;
import consultorio.dal.entidade.Medico;

public interface IMedicoEJB {

	public Mensagem salvar(Medico medico);
	public Mensagem excluir(Integer idMedico);
	public List<Medico> listar();
	
	
}
