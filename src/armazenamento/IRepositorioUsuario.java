package armazenamento;

import exce��es.UJCException;
import exce��es.UNCException;
import usuario.Perfil;

public interface IRepositorioUsuario {
	/**
	 * Esse m�todo � respons�vel por cadastrar perfis de usu�rios.
	 * 
	 * @param usuario       Recebe o perfil a ser cadastrado
	 * @throws UJCException Perfil passado como argumento j� est� cadastrado
	 */
	public void cadastrar (Perfil usuario) throws UJCException;
	
	/**
	 * Esse m�todo � respons�vel por buscar perfis de usu�rios.
	 * 
	 * @param usuario   Recebe o usu�rio que se deseja buscar
	 * @return          O objeto Perfil referente ao usu�rio passado como argumento
	 */
	public Perfil buscar(String usuario);
	
	/**
	 * Esse m�todo � respons�vel por atualizar perfis de usu�rios no reposit�rio.
	 * @param usuario 		Recebe o perfil do usu�rio que se deseja atualizar
	 * @throws UNCException O usu�rio passado como argumento n�o est� cadastrado
	 */
	public void atualizar(Perfil usuario) throws UNCException;
}
