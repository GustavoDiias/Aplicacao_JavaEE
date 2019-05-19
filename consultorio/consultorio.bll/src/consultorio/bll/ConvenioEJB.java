package consultorio.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import consultorio.bll.interfaces.IConvenioEJB;
import consultorio.bll.util.Mensagem;
import consultorio.bll.util.TipoMensagem;
import consultorio.dal.dao.interfaces.IConvenioDAO;
import consultorio.dal.entidade.Convenio;

@Stateless
public class ConvenioEJB implements IConvenioEJB{

	@Inject
	private IConvenioDAO convenioDAO;
	
	@Override
	public Mensagem salvar(Convenio convenio) {
		
		try {

			convenioDAO.insertOrUpdate(convenio);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}finally {
		}
	}

	@Override
	public Mensagem excluir(Integer idConvenio) {
		
		try {
			
			Convenio convenio = convenioDAO.findById(idConvenio);
			
			if(convenio == null) {
				throw new Exception("Convenio já foi excluída.");
			}
			
			if(convenio.getAtendimentos().size() > 0) {
				throw new Exception("Esse convenio possui atendimentos vinculados");
			}
			
			if(convenio.getPacientes().size() > 0) {
				throw new Exception("Esse convenio possui atendimentos vinculados");
			}
			
			convenioDAO.delete(convenio);
			
			return new Mensagem("Convenio excluído.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Convenio> listar() {
		return convenioDAO.findAll();
	}
}
