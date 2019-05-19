package consultorio.bll;

import javax.ejb.Stateless;
import java.util.List;
import javax.inject.Inject;
import consultorio.bll.interfaces.IPacienteEJB;
import consultorio.bll.util.Mensagem;
import consultorio.bll.util.TipoMensagem;
import consultorio.dal.dao.interfaces.IPacienteDAO;
import consultorio.dal.entidade.Paciente;

@Stateless
public class PacienteEJB implements IPacienteEJB{
	@Inject
	private IPacienteDAO pacienteDAO;
	
	@Override
	public Mensagem salvar(Paciente paciente) {
		
		try {
		
			pacienteDAO.insertOrUpdate(paciente);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}
	}

	@Override
	public Mensagem excluir(Integer idPaciente) {
		
		try {
			
			Paciente paciente = pacienteDAO.findById(idPaciente);
			
			if(paciente == null) {
				throw new Exception("Paciente inexistente.");
			}
			
			if(paciente.getAtendimentos().size() > 0) {
				throw new Exception("Existem atendimentos vinculados a esse paciente");
			}
			
			if(paciente.getConvenios().size() > 0) {
				throw new Exception("Esse paciente possui convenios vinculados");
			}
			
			pacienteDAO.delete(paciente);
			
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir: " 
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
		return new Mensagem("Excluído com sucesso.",
				TipoMensagem.sucesso);
		
	}

	@Override
	public List<Paciente> listar() {
		return pacienteDAO.findAll();
	}

}
