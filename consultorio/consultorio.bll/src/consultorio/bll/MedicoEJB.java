package consultorio.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import consultorio.bll.interfaces.IMedicoEJB;
import consultorio.bll.util.Mensagem;
import consultorio.bll.util.TipoMensagem;
import consultorio.dal.dao.interfaces.IMedicoDAO;
import consultorio.dal.entidade.Medico;

@Stateless
public class MedicoEJB implements IMedicoEJB{

	@Inject
	private IMedicoDAO medicoDAO;
	
	public Mensagem salvar(Medico medico) {

		try {
			medicoDAO.insertOrUpdate(medico);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),TipoMensagem.erro);
		}
		
		return new Mensagem("Salvo com sucesso.", TipoMensagem.sucesso);
	}

	public Mensagem excluir(Integer idMedico) {
		
		
		try {
			
			Medico medico = medicoDAO.findById(idMedico);
			
			if(medico == null) {
				throw new Exception("Medico inexistente.");
			}
			
			if(medico.getAtendimentos().size() > 0) {
				throw new Exception("Existem medicos vinculados a um atendimento");
			}
			
			medicoDAO.delete(medico);
			
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir: " 
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
		return new Mensagem("Excluído com sucesso.",
				TipoMensagem.sucesso);
		
	}


	public List<Medico> listar() {
		return medicoDAO.findAll();
	}

}
