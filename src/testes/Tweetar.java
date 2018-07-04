package testes;

import java.io.IOException;

import armazenamento.RepositorioVector;
import armazenamento.RepositorioXStream;
import exce��es.MFPException;
import exce��es.PDException;
import exce��es.PEException;
import exce��es.PIException;
import exce��es.UNCException;
import servi�o.MyTwitter;
import usuario.PessoaFisica;

public class Tweetar {
	public static void main(String[] args) {
		//RepositorioVector db = new RepositorioVector();
		RepositorioXStream db = null;
		try {
			db = new RepositorioXStream(".\\data\\", "data.xml");
		
		
			MyTwitter myTwitter = new MyTwitter(db);
			
			
			try {
				myTwitter.tweetar("@lesteves", "Hi");
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (MFPException e) {
				System.out.println(e.getMessage());
			} catch (UNCException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				myTwitter.tweetar("@lucasesteves", "Hi");
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (MFPException e) {
				System.out.println(e.getMessage());
			} catch (UNCException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				myTwitter.tweetar("@lrock", "Hello");
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (MFPException e) {
				System.out.println(e.getMessage());
			} catch (UNCException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
}
