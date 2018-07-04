package exceções;

/**
 * Exceção levantada quando o nome de usuário do seguidor é o mesmo do seguido
 * @author Lucas Esteves Rocha
 *
 */

public class SIException extends Exception{
	private static final long serialVersionUID = 1L;
	private String seguidor;
	
	public SIException(String seguidor) {
		super("Seguidor inválido!");
		this.seguidor = seguidor;
	}
	
	public String getSeguidor() {
		return this.seguidor;
	}

}
