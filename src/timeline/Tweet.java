package timeline;

/**
 * Classe responsável por encapsular o nome de usuário de um perfil e uma mensagem postada por esse usuário
 * @author Lucas Esteves Rocha
 *
 */

public class Tweet {
	private String usuario;
	private String mensagem;
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getUsuario() {
		return this.usuario;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getMensagem() {
		return this.mensagem;
	}

}
