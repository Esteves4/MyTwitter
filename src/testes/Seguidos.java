package testes;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import armazenamento.RepositorioVector;
import armazenamento.RepositorioXStream;
import exceções.MFPException;
import exceções.PDException;
import exceções.PEException;
import exceções.PIException;
import exceções.UNCException;
import serviço.MyTwitter;
import timeline.Tweet;
import usuario.Perfil;
import usuario.PessoaFisica;

public class Seguidos {
	public static void main(String[] args) {
		//RepositorioVector db = new RepositorioVector();
		RepositorioXStream db = null;
		try {
			db = new RepositorioXStream(".\\data\\", "data.xml");
		
			MyTwitter myTwitter = new MyTwitter(db);
			
				
			try {
				Vector<Perfil> timeline = myTwitter.seguidos("@lesteves");
				for (Iterator<Perfil> iterator = timeline.iterator(); iterator.hasNext();) {
					Perfil perfil = (Perfil) iterator.next();
					System.out.println("Usuario: " + perfil.getUsuario());
				}
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				Vector<Perfil> timeline = myTwitter.seguidos("@lucasesteves");
				for (Iterator<Perfil> iterator = timeline.iterator(); iterator.hasNext();) {
					Perfil perfil = (Perfil) iterator.next();
					System.out.println("Usuario: " + perfil.getUsuario());
				}
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				Vector<Perfil> timeline = myTwitter.seguidos("@lrock");
				for (Iterator<Perfil> iterator = timeline.iterator(); iterator.hasNext();) {
					Perfil perfil = (Perfil) iterator.next();
					System.out.println("Usuario: " + perfil.getUsuario());
				}
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
}
