package exce��es;

/**
 * Exce��o levantada ao cadastrar um usu�rio que j� est� cadastrado.
 * @author Lucas Esteves Rocha
 *
 */
public class UJCException extends Exception{
	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public UJCException(String usuario) {
		super("Usu�rio j� cadastrado!");
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
}
