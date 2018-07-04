package exceções;

/**
 * Exceção levantada ao atualizar um usuário que não está cadastrado.
 * @author Lucas Esteves Rocha
 *
 */

public class UNCException extends Exception {
	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public UNCException(String usuario) {
		super("Usuário não cadastrado!");
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
}
