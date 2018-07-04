package exceções;

/**
* Exceção levantada ao usar um perfil desativado
* @author Lucas Esteves Rocha
*
*/

public class PDException extends Exception{
	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public PDException(String usuario) {
		super("Perfil desativado!");
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
}
