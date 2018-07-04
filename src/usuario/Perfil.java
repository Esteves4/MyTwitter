package usuario;

import java.util.Iterator;
import java.util.Vector;

import timeline.Tweet;

/**
 * Classe responsável por encapsular os seguidos, seguidores, o status do perfil e o usuário do perfil.
 * 
 * @author Lucas Esteves Rocha
 *
 */


public abstract class Perfil {
	private String usuario;
	private Vector<Perfil> seguidos;
	private Vector<Perfil> seguidores;
	private Vector<Tweet> timeline;
	private boolean ativo;
	
	public Perfil(String usuario) {
		setUsuario(usuario);
		this.seguidos = new Vector<Perfil>();
		this.seguidores = new Vector<Perfil>();
		this.timeline = new Vector<Tweet>();
		this.ativo = true;
	}
	
	public void addSeguido(Perfil usuario) {
		seguidos.add(usuario);
	}
	
	
	public void addSeguidor(Perfil usuario) {
		seguidores.add(usuario);
	}
	
	public void addTweet(Tweet tweet) {
		timeline.add(tweet);
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getUsuario() { 
		return this.usuario;
	}
	
	public Vector<Perfil> getSeguidos() { 
		return this.seguidos;
	}
	
	public Vector<Perfil> getSeguidores(){
		return this.seguidores;
	}
	
	public Vector<Tweet> getTimeline(){
		return this.timeline;
	}
	
	public void setAtivo(boolean valor) {
		this.ativo = valor;
	}
	
	public boolean isAtivo() {
		return this.ativo;
	}

}
