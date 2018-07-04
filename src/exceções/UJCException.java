package exceções;

/**
 * Exceção levantada ao cadastrar um usuário que já está cadastrado.
 * @author Lucas Esteves Rocha
 *
 */
public class UJCException extends Exception{
	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public UJCException(String usuario) {
		super("Usuário já cadastrado!");
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
}
