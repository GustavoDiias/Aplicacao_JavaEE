package consultorio.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import consultorio.bll.interfaces.IDoencaEJB;
import consultorio.bll.util.Mensagem;
import consultorio.bll.util.TipoMensagem;
import consultorio.dal.dao.interfaces.IDoencaDAO;
import consultorio.dal.entidade.Doenca;

@Stateless
public class DoencaEJB implements IDoencaEJB{

	@Inject
	private IDoencaDAO doencaDAO;
	
	@Override
	public Mensagem salvar(Doenca doenca) {
		
		try {

			doencaDAO.insertOrUpdate(doenca);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}finally {
		}
	}

	@Override
	public Mensagem excluir(Integer idDoenca) {
		
		try {
			
			Doenca doenca = doencaDAO.findById(idDoenca);
			
			if(doenca == null) {
				throw new Exception("Doença já foi excluída.");
			}
			
			if(doenca.getPacientes().size() > 0) {
				throw new Exception("Essa Doença ja  possui pacientes vinculados");
			}
			
			doencaDAO.delete(doenca);
			
			return new Mensagem("Doença excluída.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Doenca> listar() {
		return doencaDAO.findAll();
	}

}
