package entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;

@Entity
@Table(name = "email")
public class Email {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String destinatario;
	private String corpo;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_envio")
	private Date dataEnvio;
	@Column(name = "confirma_leitura")
	private boolean confirmaLeitura;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	
	public Date getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	
	public boolean isConfirmaLeitura() {
		return confirmaLeitura;
	}
	public void setConfirmaLeitura(boolean confirmaLeitura) {
		this.confirmaLeitura = confirmaLeitura;
	}
	
    @Override
    public String toString() {
        return "Destinatário: " + destinatario +
                ", Corpo: " + corpo +
                ", Data de envio: " + dataEnvio.toString() +
                ", Confirmação de Leitura: " + confirmaLeitura;
    }
	
	
}