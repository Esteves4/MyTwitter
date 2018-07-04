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

public class NumSeguidores {
	public static void main(String[] args) {
		//RepositorioVector db = new RepositorioVector();
		RepositorioXStream db = null;
		try {
			db = new RepositorioXStream(".\\data\\", "data.xml");
		
			MyTwitter myTwitter = new MyTwitter(db);
				
			try {
				int num = myTwitter.numeroSeguidores("@lesteves");
				System.out.println("Numero seguidores: " + num);
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				int num = myTwitter.numeroSeguidores("@lucasesteves");
				System.out.println("Numero seguidores: " + num);
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				int num = myTwitter.numeroSeguidores("@lrock");
				System.out.println("Numero seguidores: " + num);
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
