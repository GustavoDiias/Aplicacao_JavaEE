package consultorio.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.*;

@Entity
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAtendimento;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataAtendimento;
	
	@NotNull
	private Double valor;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idConvenio")
	private Convenio convenio;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idPaciente")
	private Paciente paciente;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idMedico")
	private Medico medico;

	public Integer getIdAtendimento() {
		return idAtendimento;
	}

	public void setIdAtendimento(Integer idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAtendimento == null) ? 0 : idAtendimento.hashCode());
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
		Atendimento other = (Atendimento) obj;
		if (idAtendimento == null) {
			if (other.idAtendimento != null)
				return false;
		} else if (!idAtendimento.equals(other.idAtendimento))
			return false;
		return true;
	}

	
}
