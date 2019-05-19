package consultorio.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import consultorio.bll.interfaces.IEspecialidadeEJB;
import consultorio.bll.util.Mensagem;
import consultorio.bll.util.TipoMensagem;
import consultorio.dal.dao.interfaces.IEspecialidadeDAO;
import consultorio.dal.entidade.Especialidade;

@Stateless
public class EspecialidadeEJB implements IEspecialidadeEJB{
	
	@Inject
	private IEspecialidadeDAO especialidadeDAO;
	
	@Override
	public Mensagem salvar(Especialidade especialidade) {
		
		try {
			
			especialidadeDAO.insertOrUpdate(especialidade);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}
	}

	@Override
	public Mensagem excluir(Integer idEspecialidade) {
		
		try {
			
			Especialidade especialidade = especialidadeDAO.findById(idEspecialidade);
			
			if(especialidade == null) {
				throw new Exception("Especialidade já foi excluída.");
			}
			
			if(especialidade.getMedicos().size() > 0) {
				throw new Exception("Essa especialidade ja possui medicos vinculados");
			}
			
			especialidadeDAO.delete(especialidade);
			
			return new Mensagem("Especialidade excluída.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Especialidade> listar() {
		return especialidadeDAO.findAll();
	}

}
