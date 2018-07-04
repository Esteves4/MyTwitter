package exce��es;

/**
 * Exce��o levantada quando o nome de usu�rio do seguidor � o mesmo do seguido
 * @author Lucas Esteves Rocha
 *
 */

public class SIException extends Exception{
	private static final long serialVersionUID = 1L;
	private String seguidor;
	
	public SIException(String seguidor) {
		super("Seguidor inv�lido!");
		this.seguidor = seguidor;
	}
	
	public String getSeguidor() {
		return this.seguidor;
	}

}
