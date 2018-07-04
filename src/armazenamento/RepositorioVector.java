package armazenamento;

import java.util.Iterator;
import java.util.Vector;

import exceções.UJCException;
import exceções.UNCException;
import usuario.Perfil;

public class RepositorioVector implements IRepositorioUsuario{
	private Vector<Perfil> repositorio;
	
	public RepositorioVector() {
		repositorio = new Vector<Perfil>();
	}
		
	@Override
	public void cadastrar(Perfil usuario) throws UJCException{
		Perfil perfil = buscar(usuario.getUsuario());
		
		if(perfil == null) {
			repositorio.add(usuario);
		}else {
			throw new UJCException(usuario.getUsuario());
		}
	
	}

	@Override
	public Perfil buscar(String usuario) {
		
		for (Iterator<Perfil> iterator = repositorio.iterator(); iterator.hasNext();) {
			Perfil perfil = (Perfil) iterator.next();
			if(perfil != null) {
				if(perfil.getUsuario().equals(usuario)) {
					return perfil;
				}
			}
			
		}
		return null;
	}

	@Override
	public void atualizar(Perfil usuario) throws UNCException {
		Perfil perfilAtual = buscar(usuario.getUsuario());
		
		if(perfilAtual != null) {
			int indexUsuario = repositorio.indexOf(perfilAtual);
			repositorio.setElementAt(usuario, indexUsuario);
		}else {
			throw new UNCException(usuario.getUsuario());
		}
		
		
	}

}
