package consultorio.bll.interfaces;

import java.util.List;

import consultorio.bll.util.Mensagem;
import consultorio.dal.entidade.Convenio;

public interface IConvenioEJB {

	public Mensagem salvar(Convenio convenio);
	public Mensagem excluir(Integer idConvenio);
	public List<Convenio> listar();
}
