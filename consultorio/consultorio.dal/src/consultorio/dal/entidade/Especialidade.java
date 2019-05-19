package consultorio.dal.entidade;

import javax.persistence.*;
import java.util.*;
import com.sun.istack.NotNull;

@Entity
@Table(name = "especialidade")
@NamedQuery(name="especialidade.count",
	query = "select count(e) from Especialidade as e")
public class Especialidade {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecialidade;
	
	@Column(name = "descricao")
	@NotNull
	private String descricao;
	
	@OneToMany(mappedBy = "especialidade", fetch = FetchType.LAZY)
	private List<Medico> medicos;

	public Integer getIdEspecialidade() {
		return idEspecialidade;
	}

	public void setIdEspecialidade(Integer idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEspecialidade == null) ? 0 : idEspecialidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especialidade other = (Especialidade) obj;
		if (idEspecialidade == null) {
			if (other.idEspecialidade != null)
				return false;
		} else if (!idEspecialidade.equals(other.idEspecialidade))
			return false;
		return true;
	}
	
	

}
