package exce��es;

/**
* Exce��o levantada ao usar um perfil que n�o existe
* @author Lucas Esteves Rocha
*
*/

public class PIException extends Exception {
	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public PIException(String usuario) {
		super("Perfil inexistente!");
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
}
