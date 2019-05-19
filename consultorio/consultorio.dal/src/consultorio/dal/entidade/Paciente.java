package consultorio.dal.entidade;

import javax.persistence.*;
import com.sun.istack.NotNull;
import java.util.*;

@Entity
public class Paciente{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	
	@NotNull
	private String nome;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDoenca")
	@NotNull
	private Doenca doenca;
	
	@OneToMany(mappedBy = "paciente")
	private List<Atendimento> atendimentos;
	
	@ManyToMany
	@JoinTable(name = "PacienteConvenio",
			joinColumns = @JoinColumn(name = "idPaciente"),
			inverseJoinColumns = @JoinColumn(name = "idConvenio"))
	private List<Convenio> convenios;

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Doenca getDoenca() {
		return doenca;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}
	
	public List<Convenio> getConvenios() {
		return convenios;
	}

	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPaciente == null) ? 0 : idPaciente.hashCode());
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
		Paciente other = (Paciente) obj;
		if (idPaciente == null) {
			if (other.idPaciente != null)
				return false;
		} else if (!idPaciente.equals(other.idPaciente))
			return false;
		return true;
	}


	
	

	
}
