package consultorio.bll.interfaces;

import java.util.List;

import consultorio.bll.util.Mensagem;
import consultorio.dal.entidade.Atendimento;

public interface IAtendimentoEJB {

	public Mensagem salvar(Atendimento atendimento);
	public Mensagem excluir(Integer idAtendimento);
	public List<Atendimento> listar();
}
