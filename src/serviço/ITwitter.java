package serviço;

import java.util.Vector;

import exceções.MFPException;
import exceções.PDException;
import exceções.PEException;
import exceções.PIException;
import exceções.SIException;
import exceções.UNCException;
import timeline.Tweet;
import usuario.Perfil;

public interface ITwitter {
	/**
	 * Método responsável por cadastrar o pefil passado como argumento 
	 * 
	 * @param usuario 	   Recebe o perfil a ser cadastrado
	 * @throws PEException O perfil passado como argumento já está cadastrado
	 */
	public void criarPerfil(Perfil usuario) throws PEException;
	
	/**
	 * Método responsável por desativar o perfil passado como argumento
	 * 
	 * @param usuario       Recebe o perfil a ser desativado
	 * @throws PIException  Perfil passado como argumento não existe
	 * @throws PDException  Perfil passado como argumento já está desativado
	 * @throws UNCException Perfil passado como argumento não está cadastrado
	 */
	public void cancelarPerfil(String usuario) throws PIException, PDException, UNCException;
	
	/**
	 * Método responsável pela postagem de mensagens no micro-blog
	 * 
	 * @param usuario 		Recebe o usuário que está tweetando
	 * @param mensagem 		Recebe a mensagem a ser tweetada
	 * 
	 * @throws PIException  O perfil do usuário passado como argumento não existe
	 * @throws MFPException A mensagem está no limiar entre 1 e 140 caracteres
	 * @throws UNCException	O usuário passado como argumento não está cadastrado
	 * @throws PDException  O perfil do usuário passado como argumento está desativado
	 */
	public void tweetar(String usuario, String mensagem) throws PIException, MFPException, UNCException, PDException;
	
	/**
	 * Método responsável por recuperar todos os tweets da timeline do usuário passado como argumento
	 * 
	 * @param usuario      O usuario que se deseja recuperar todos os tweets da timeline
	 * @return 		       Um Vector<Tweet> com todos os tweets da timeline
	 * 
	 * @throws PIException O perfil do usuário passado como argumento não existe
	 * @throws PDException O perfil do usuário passado como argumento está desativado
	 */
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException;
	
	/**
	 * Método responsável por recuperar todos os tweets do usuário passado como argumento
	 * 
	 * @param usuario      O usuario que se deseja recuperar todos os tweets
	 * @return 		       Um Vector<Tweet> com todos os tweets do usuario
	 * 
	 * @throws PIException O perfil do usuário passado como argumento não existe
	 * @throws PDException O perfil do usuário passado como argumento está desativado
	 */
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException;
	
	/**
	 * Método responsável por incluir o perfil do usuário seguidor na lista de seguidores do perfil do usuário seguido e incluir o perfil do usuário seguido na lista de seguidos do perfil seguidor. 
	 * 
	 * @param seguidor      O usuário que está seguindo
	 * @param seguido       O usuário que está sendo seguido
	 * @throws PIException  O perfil do usuário passado como argumento não existe
	 * @throws PDException  O perfil do usuário passado como argumento está desativado
	 * @throws SIException  Os argumentos passados são iguais
	 * @throws UNCException Os usuários passados como argumento não estão cadastrados
	 */
	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException, UNCException;
	
	/**
	 * Método responsável por retornar o número de seguidores do perfil do usuário informado como argumento que existem e estão ativos
	 * 
	 * @param usuario      O usuário que desejamos saber o número de seguidores
	 * @return 	           O número de seguidores
	 * @throws PIException O perfil do usuário passado como argumento não existe
	 * @throws PDException O perfil do usuário passado como argumento está desativado
	 */
	public int numeroSeguidores(String usuario) throws PIException, PDException;
	/**
	 * Método responsável por recuperar todos os seguidores do perfil do usuário passado como argumento que existem e estão ativos
	 * 
	 * @param usuario      O usuário que desejamos recuperar os seguidores
	 * @return 			   Um Vector<Perfil> com os seguidores do usuário passado como argumento que existem e estão ativos
	 * @throws PDException O perfil do usuário passado como argumento está desativado
	 * @throws PIException O perfil do usuário passado como argumento não existe
	 */
	public Vector<Perfil> seguidores(String usuario) throws PDException, PIException;
	
	/**
	 * Método responsável por recuperar todos os seguidos do perfil do usuário passado como argumento que existem e estão ativos
	 * @param usuario      O usuário que desejamos recuperar os seguidos
	 * @return             Um Vector<Perfil> com os seguidos do usuário passado como argumento que existem e estão ativos
	 * @throws PDException O perfil do usuário passado como argumento está desativado
	 * @throws PIException O perfil do usuário passado como argumento não existe
	 */
	public Vector<Perfil> seguidos(String usuario) throws PDException, PIException;
}
