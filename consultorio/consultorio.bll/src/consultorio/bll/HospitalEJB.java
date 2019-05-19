package consultorio.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import consultorio.bll.interfaces.IHospitalEJB;
import consultorio.bll.util.Mensagem;
import consultorio.bll.util.TipoMensagem;
import consultorio.dal.dao.interfaces.IHospitalDAO;
import consultorio.dal.entidade.Hospital;

@Stateless
public class HospitalEJB implements IHospitalEJB{
	
	@Inject
	private IHospitalDAO hospitalDAO;
	
	@Override
	public Mensagem salvar(Hospital hospital) {
		
		try {

			hospitalDAO.insertOrUpdate(hospital);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}finally {
		}
	}

	@Override
	public Mensagem excluir(Integer idHospital) {
		
		try {
			
			Hospital hospital = hospitalDAO.findById(idHospital);
			
			if(hospital == null) {
				throw new Exception("Hospital já foi excluída.");
			}
			
			if(hospital.getMedicos().size() > 0) {
				throw new Exception("Esse hospital ja possui medicos vinculados");
			}
			
			hospitalDAO.delete(hospital);
			
			return new Mensagem("Hospital excluído.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Hospital> listar() {
		return hospitalDAO.findAll();
	}

}
