package consultorio.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import consultorio.bll.interfaces.IUsuarioEJB;
import consultorio.bll.util.Mensagem;
import consultorio.bll.util.TipoMensagem;
import consultorio.dal.dao.interfaces.IUsuarioDAO;
import consultorio.dal.entidade.Usuario;

@Stateless
public class UsuarioEJB implements IUsuarioEJB{

	@Inject
	private IUsuarioDAO usuarioDAO;
	
	@Override
	public Mensagem salvar(Usuario usuario) {
		
		try {
		
			usuarioDAO.insertOrUpdate(usuario);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}
	}

	@Override
	public Mensagem excluir(Integer idUsuario) {
		
		try {
			
			Usuario usuario = usuarioDAO.findById(idUsuario);
			
			if(usuario == null) {
				throw new Exception("Usuario já foi excluído.");
			}
			
	
			
			usuarioDAO.delete(usuario);
			
			return new Mensagem("Usuario excluído.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Usuario> listar() {
		return usuarioDAO.findAll();
	}

}
