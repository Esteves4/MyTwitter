package exceções;

/**
* Exceção levantada quando a mensangem não está no limiar entre 1 e 140 caracteres
* @author Lucas Esteves Rocha
*
*/
public class MFPException extends Exception{
	private static final long serialVersionUID = 1L;

	public MFPException() {
		super("Mensagem fora do padrão!");
	}

}
