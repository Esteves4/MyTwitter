package exce��es;

/**
 * Exce��o levantada ao atualizar um usu�rio que n�o est� cadastrado.
 * @author Lucas Esteves Rocha
 *
 */

public class UNCException extends Exception {
	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public UNCException(String usuario) {
		super("Usu�rio n�o cadastrado!");
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
}
