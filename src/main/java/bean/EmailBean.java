package bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;


import javax.faces.context.FacesContext;

import dao.EmailDao;
import entidades.Email;
import static util.MessageUtil.*;

@ManagedBean
public class EmailBean {
	private Email email = new Email();
	private List<Email> lista;
	
	public String salvar() {
		try {
			EmailDao.salvar(email);
			sucesso("Sucesso", "Email enviado com sucesso! :)");
			email = new Email();
		} catch (Exception e) {
			erro("Erro", "Não foi possível enviar o email :(");
		}
		return null;
	}
	
	public String excluir() {
		try {
			EmailDao.excluir(email);
			email = new Email();
			sucesso("Sucesso", "Email excluído com sucesso!");
			return "";
		} catch (Exception e) {
			erro("Erro", "Não foi possível excluir a mensagem!");
			return null;
		}
		
	}
	
	public String editar() {
		try {
			EmailDao.editar(email);
			sucesso("Sucesso", "Email alterado com sucesso!");
			return "";
		} catch (Exception e) {
			erro("Erro", "Não foi possível editar o email");
			return null;
		}
	}
	
    public void visualizar() {
        sucesso("Visualização", this.email.toString());
    }
    
    
	public Email getEmail() {
		return email;
	}
	
	public void setEmail(Email e) {
		this.email = e;
	}
	
	public List<Email> getLista() {
		if (lista == null) {
			lista = EmailDao.listar(email);
		}
		return lista;
	}
	
	public void setLista(List<Email> l) {
		this.lista = l;
	}
	
}