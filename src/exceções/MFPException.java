package exce��es;

/**
* Exce��o levantada quando a mensangem n�o est� no limiar entre 1 e 140 caracteres
* @author Lucas Esteves Rocha
*
*/
public class MFPException extends Exception{
	private static final long serialVersionUID = 1L;

	public MFPException() {
		super("Mensagem fora do padr�o!");
	}

}
