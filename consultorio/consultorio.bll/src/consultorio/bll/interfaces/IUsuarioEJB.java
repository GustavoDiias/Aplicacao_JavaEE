package consultorio.bll.interfaces;

import java.util.List;

import consultorio.bll.util.Mensagem;
import consultorio.dal.entidade.Usuario;

public interface IUsuarioEJB {

	public Mensagem salvar(Usuario usuario);
	public Mensagem excluir(Integer idUsuario);
	public List<Usuario> listar();
}
