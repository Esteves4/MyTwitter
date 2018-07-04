package servi�o;

import java.util.Vector;

import exce��es.MFPException;
import exce��es.PDException;
import exce��es.PEException;
import exce��es.PIException;
import exce��es.SIException;
import exce��es.UNCException;
import timeline.Tweet;
import usuario.Perfil;

public interface ITwitter {
	/**
	 * M�todo respons�vel por cadastrar o pefil passado como argumento 
	 * 
	 * @param usuario 	   Recebe o perfil a ser cadastrado
	 * @throws PEException O perfil passado como argumento j� est� cadastrado
	 */
	public void criarPerfil(Perfil usuario) throws PEException;
	
	/**
	 * M�todo respons�vel por desativar o perfil passado como argumento
	 * 
	 * @param usuario       Recebe o perfil a ser desativado
	 * @throws PIException  Perfil passado como argumento n�o existe
	 * @throws PDException  Perfil passado como argumento j� est� desativado
	 * @throws UNCException Perfil passado como argumento n�o est� cadastrado
	 */
	public void cancelarPerfil(String usuario) throws PIException, PDException, UNCException;
	
	/**
	 * M�todo respons�vel pela postagem de mensagens no micro-blog
	 * 
	 * @param usuario 		Recebe o usu�rio que est� tweetando
	 * @param mensagem 		Recebe a mensagem a ser tweetada
	 * 
	 * @throws PIException  O perfil do usu�rio passado como argumento n�o existe
	 * @throws MFPException A mensagem est� no limiar entre 1 e 140 caracteres
	 * @throws UNCException	O usu�rio passado como argumento n�o est� cadastrado
	 * @throws PDException  O perfil do usu�rio passado como argumento est� desativado
	 */
	public void tweetar(String usuario, String mensagem) throws PIException, MFPException, UNCException, PDException;
	
	/**
	 * M�todo respons�vel por recuperar todos os tweets da timeline do usu�rio passado como argumento
	 * 
	 * @param usuario      O usuario que se deseja recuperar todos os tweets da timeline
	 * @return 		       Um Vector<Tweet> com todos os tweets da timeline
	 * 
	 * @throws PIException O perfil do usu�rio passado como argumento n�o existe
	 * @throws PDException O perfil do usu�rio passado como argumento est� desativado
	 */
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException;
	
	/**
	 * M�todo respons�vel por recuperar todos os tweets do usu�rio passado como argumento
	 * 
	 * @param usuario      O usuario que se deseja recuperar todos os tweets
	 * @return 		       Um Vector<Tweet> com todos os tweets do usuario
	 * 
	 * @throws PIException O perfil do usu�rio passado como argumento n�o existe
	 * @throws PDException O perfil do usu�rio passado como argumento est� desativado
	 */
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException;
	
	/**
	 * M�todo respons�vel por incluir o perfil do usu�rio seguidor na lista de seguidores do perfil do usu�rio seguido e incluir o perfil do usu�rio seguido na lista de seguidos do perfil seguidor. 
	 * 
	 * @param seguidor      O usu�rio que est� seguindo
	 * @param seguido       O usu�rio que est� sendo seguido
	 * @throws PIException  O perfil do usu�rio passado como argumento n�o existe
	 * @throws PDException  O perfil do usu�rio passado como argumento est� desativado
	 * @throws SIException  Os argumentos passados s�o iguais
	 * @throws UNCException Os usu�rios passados como argumento n�o est�o cadastrados
	 */
	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException, UNCException;
	
	/**
	 * M�todo respons�vel por retornar o n�mero de seguidores do perfil do usu�rio informado como argumento que existem e est�o ativos
	 * 
	 * @param usuario      O usu�rio que desejamos saber o n�mero de seguidores
	 * @return 	           O n�mero de seguidores
	 * @throws PIException O perfil do usu�rio passado como argumento n�o existe
	 * @throws PDException O perfil do usu�rio passado como argumento est� desativado
	 */
	public int numeroSeguidores(String usuario) throws PIException, PDException;
	/**
	 * M�todo respons�vel por recuperar todos os seguidores do perfil do usu�rio passado como argumento que existem e est�o ativos
	 * 
	 * @param usuario      O usu�rio que desejamos recuperar os seguidores
	 * @return 			   Um Vector<Perfil> com os seguidores do usu�rio passado como argumento que existem e est�o ativos
	 * @throws PDException O perfil do usu�rio passado como argumento est� desativado
	 * @throws PIException O perfil do usu�rio passado como argumento n�o existe
	 */
	public Vector<Perfil> seguidores(String usuario) throws PDException, PIException;
	
	/**
	 * M�todo respons�vel por recuperar todos os seguidos do perfil do usu�rio passado como argumento que existem e est�o ativos
	 * @param usuario      O usu�rio que desejamos recuperar os seguidos
	 * @return             Um Vector<Perfil> com os seguidos do usu�rio passado como argumento que existem e est�o ativos
	 * @throws PDException O perfil do usu�rio passado como argumento est� desativado
	 * @throws PIException O perfil do usu�rio passado como argumento n�o existe
	 */
	public Vector<Perfil> seguidos(String usuario) throws PDException, PIException;
}
