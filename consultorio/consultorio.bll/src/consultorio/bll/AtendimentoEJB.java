package consultorio.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import consultorio.bll.interfaces.IAtendimentoEJB;
import consultorio.bll.util.Mensagem;
import consultorio.bll.util.TipoMensagem;
import consultorio.dal.dao.interfaces.IAtendimentoDAO;
import consultorio.dal.entidade.Atendimento;

@Stateless
public class AtendimentoEJB implements IAtendimentoEJB{

	@Inject
	private IAtendimentoDAO atendimentoDAO;
	
	@Override
	public Mensagem salvar(Atendimento atendimento) {
		
		try {
		
			atendimentoDAO.insertOrUpdate(atendimento);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}
	}

	@Override
	public Mensagem excluir(Integer idAtendimento) {
		
		try {
			
			Atendimento atendimento = atendimentoDAO.findById(idAtendimento);
			
			if(atendimento == null) {
				throw new Exception("Atendimento já foi excluído.");
			}
			
	
			
			atendimentoDAO.delete(atendimento);
			
			return new Mensagem("Atendimento excluído.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Atendimento> listar() {
		return atendimentoDAO.findAll();
	}

}
