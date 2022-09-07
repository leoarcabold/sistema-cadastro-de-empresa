package erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nome_fantasia", nullable = false, length = 80)
	private String nomeFantasia;
	
	@Column(name = "razao_social", nullable = false, length = 120)
	private String razaoSocial;
	
	@Column(nullable = false, length = 18)
	private String cnpj;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_fundacao")
	private Date dateFundacao;
	
	@ManyToOne
	@JoinColumn(name = "ramo_atividade_id", nullable = false)
	@Column(name = "ramo_atividade")
	private String ramoAtividade;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private TipoEmpresa tipo;
	
		
}
