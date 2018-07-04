package exceções;

/**
* Exceção levantada quando ao criar um perfil com um nome de usuário já existente
* @author Lucas Esteves Rocha
*
*/

public class PEException extends Exception{
	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public PEException(String usuario) {
		super("Perfil já cadastrado!");
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
}
