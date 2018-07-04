package armazenamento;

import exceções.UJCException;
import exceções.UNCException;
import usuario.Perfil;

public interface IRepositorioUsuario {
	/**
	 * Esse método é responsável por cadastrar perfis de usuários.
	 * 
	 * @param usuario       Recebe o perfil a ser cadastrado
	 * @throws UJCException Perfil passado como argumento já está cadastrado
	 */
	public void cadastrar (Perfil usuario) throws UJCException;
	
	/**
	 * Esse método é responsável por buscar perfis de usuários.
	 * 
	 * @param usuario   Recebe o usuário que se deseja buscar
	 * @return          O objeto Perfil referente ao usuário passado como argumento
	 */
	public Perfil buscar(String usuario);
	
	/**
	 * Esse método é responsável por atualizar perfis de usuários no repositório.
	 * @param usuario 		Recebe o perfil do usuário que se deseja atualizar
	 * @throws UNCException O usuário passado como argumento não está cadastrado
	 */
	public void atualizar(Perfil usuario) throws UNCException;
}
