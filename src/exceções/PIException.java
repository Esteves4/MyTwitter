package exceções;

/**
* Exceção levantada ao usar um perfil que não existe
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
