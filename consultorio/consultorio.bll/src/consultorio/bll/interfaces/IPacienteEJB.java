package consultorio.bll.interfaces;

import java.util.List;

import consultorio.bll.util.Mensagem;
import consultorio.dal.entidade.Paciente;

public interface IPacienteEJB {

	public Mensagem salvar(Paciente paciente);
	public Mensagem excluir(Integer idPaciente);
	public List<Paciente> listar();
}
