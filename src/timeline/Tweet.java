package timeline;

/**
 * Classe respons�vel por encapsular o nome de usu�rio de um perfil e uma mensagem postada por esse usu�rio
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
