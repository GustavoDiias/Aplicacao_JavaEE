package consultorio.bll.interfaces;

import java.util.List;

import consultorio.bll.util.Mensagem;
import consultorio.dal.entidade.Doenca;

public interface IDoencaEJB {

	public Mensagem salvar(Doenca doenca);
	public Mensagem excluir(Integer idDoenca);
	public List<Doenca> listar();
}
