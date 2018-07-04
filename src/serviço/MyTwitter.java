package serviço;

import java.util.Iterator;
import java.util.Vector;

import armazenamento.IRepositorioUsuario;
import exceções.MFPException;
import exceções.PDException;
import exceções.PEException;
import exceções.PIException;
import exceções.SIException;
import exceções.UJCException;
import exceções.UNCException;
import timeline.Tweet;
import usuario.Perfil;

public class MyTwitter implements ITwitter{

	private IRepositorioUsuario repositorio;
	
	public MyTwitter(IRepositorioUsuario repositorio) {
		this.repositorio = repositorio;	
	}

	@Override
	public void criarPerfil(Perfil usuario) throws PEException{
		try {
			repositorio.cadastrar(usuario);	
		}catch(UJCException ujc) {
			throw new PEException(usuario.getUsuario());
		}
		
	}

	@Override
	public void cancelarPerfil(String usuario) throws PIException, PDException, UNCException {
		Perfil perfil = repositorio.buscar(usuario);
		
		if(perfil != null) {
			if(perfil.isAtivo()) {
				perfil.setAtivo(false);
				repositorio.atualizar(perfil);
			}else {
				throw new PDException(usuario);
			}
		}else{
			throw new PIException(usuario);
		}
		
	}

	@Override
	public void tweetar(String usuario, String mensagem) throws PIException, MFPException, UNCException, PDException {
		Perfil perfil = repositorio.buscar(usuario);
		
		if(perfil != null) {
			
			if(perfil.isAtivo()) {
				
				if(mensagem.length() >= 1 && mensagem.length() <= 140) {
					Tweet tweet =  new Tweet();
					tweet.setUsuario(usuario);
					tweet.setMensagem(mensagem);
					
					perfil.addTweet(tweet);
					repositorio.atualizar(perfil);
					
					Vector<Perfil> seguidores = perfil.getSeguidores();
					
					for (Iterator<Perfil> iterator = seguidores.iterator(); iterator.hasNext();) {
						
						Perfil perfil2 = (Perfil) iterator.next();
						if(perfil2 != null) {
							if(perfil2.isAtivo()) {
								perfil2.addTweet(tweet);
								repositorio.atualizar(perfil2);
							}
							
						}
					}
				}else {
					throw new MFPException();
				}
			}else {
				throw new PDException(usuario);
			}
		}else {
			throw new PIException(usuario);
		}
	}

	@Override
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException {
		Perfil perfil = repositorio.buscar(usuario);
		
		if(perfil != null) {
			if(perfil.isAtivo()) {
				return perfil.getTimeline();
			}else {
				throw new PDException(usuario);
			}
			
		}else {
			throw new PIException(usuario);
		}
	}

	@Override
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException{

		Vector<Tweet> timeline = timeline(usuario);
		Vector<Tweet> tweets = new Vector<Tweet>();
		
		for(int i=0; i< timeline.size(); ++i) {
			if(timeline.get(i).getUsuario().equals(usuario)) {
				tweets.add(timeline.get(i));
			}
		}
		
		return tweets;
	}

	@Override
	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException, UNCException {
		Perfil perfilSeguidor = repositorio.buscar(seguidor);
		Perfil perfilSeguido = repositorio.buscar(seguido);
		
		if(perfilSeguidor != null) {
			if(perfilSeguido != null) {
				if(perfilSeguidor.isAtivo()) {
					if(perfilSeguido.isAtivo()) {
						if(!seguidor.equals(seguido)) {
							perfilSeguidor.addSeguido(perfilSeguido);
							perfilSeguido.addSeguidor(perfilSeguidor);
							repositorio.atualizar(perfilSeguidor);
							repositorio.atualizar(perfilSeguido);
							
						}else {
							throw new SIException(seguidor);
						}

					}else {
						throw new PDException(seguido);
					}
				}else {
					throw new PDException(seguidor);
				}
			}else {
				throw new PIException(seguido);
			}
		}else {
			throw new PIException(seguidor);
		}
		
	}

	@Override
	public int numeroSeguidores(String usuario) throws PIException, PDException {
		Perfil perfil = repositorio.buscar(usuario);
		
		if(perfil != null) {
			if(perfil.isAtivo()) {
				Vector<Perfil> seguidores = perfil.getSeguidores();
				int qntSeguidores = 0;
				
				for (Iterator<Perfil> iterator = seguidores.iterator(); iterator.hasNext();) {
					
					Perfil perfil2 = repositorio.buscar(((Perfil) iterator.next()).getUsuario());
					
					if(perfil2 != null && perfil2.isAtivo()) {
						qntSeguidores++;
					}
					
				}
				return qntSeguidores;
			}else {
				throw new PDException(usuario);
			}
			
		}else {
			throw new PIException(usuario);
		}
	}

	@Override
	public Vector<Perfil> seguidores(String usuario) throws PDException, PIException {
		Perfil perfil = repositorio.buscar(usuario);
		
		if(perfil != null) {
			if(perfil.isAtivo()) {
				Vector<Perfil> seguidores = perfil.getSeguidores();
				
				for (Iterator<Perfil> iterator = seguidores.iterator(); iterator.hasNext();) {
					
					Perfil perfil2 = repositorio.buscar(((Perfil) iterator.next()).getUsuario());
					
					if(perfil2 == null || !perfil2.isAtivo()) {
						seguidores.remove((Perfil) iterator.next());
					}
					
				}
				return seguidores;
			}else {
				throw new PDException(usuario);
			}
			
		}else {
			throw new PIException(usuario);
		}
	}

	@Override
	public Vector<Perfil> seguidos(String usuario) throws PDException, PIException {
		Perfil perfil = repositorio.buscar(usuario);
		
		if(perfil != null) {
			if(perfil.isAtivo()) {
				Vector<Perfil> seguidos = perfil.getSeguidos();
				
				for (Iterator<Perfil> iterator = seguidos.iterator(); iterator.hasNext();) {
					
					Perfil perfil2 = repositorio.buscar(((Perfil) iterator.next()).getUsuario());
					
					if(perfil2 == null || !perfil2.isAtivo()) {
						seguidos.remove((Perfil) iterator.next());
					}
				}
				
				return seguidos;
			}else {
				throw new PDException(usuario);
			}
			
		}else {
			throw new PIException(usuario);
		}
	}
	

}
