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
import usuario.PessoaFisica;

public class Tweets {
	public static void main(String[] args) {
		//RepositorioVector db = new RepositorioVector();
		RepositorioXStream db = null;
		try {
			db = new RepositorioXStream(".\\data\\", "data.xml");
		
			MyTwitter myTwitter = new MyTwitter(db);
								
			try {
				Vector<Tweet> timeline = myTwitter.tweets("@lesteves");
				for (Iterator<Tweet> iterator = timeline.iterator(); iterator.hasNext();) {
					Tweet tweet = (Tweet) iterator.next();
					System.out.println("Usuario: " + tweet.getUsuario() + " " + "Mensagem: " + tweet.getMensagem());
				}
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				Vector<Tweet> timeline = myTwitter.tweets("@lucasesteves");
				for (Iterator<Tweet> iterator = timeline.iterator(); iterator.hasNext();) {
					Tweet tweet = (Tweet) iterator.next();
					System.out.println("Usuario: " + tweet.getUsuario() + " " + "Mensagem: " + tweet.getMensagem());
				}
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				Vector<Tweet> timeline = myTwitter.tweets("@lrock");
				for (Iterator<Tweet> iterator = timeline.iterator(); iterator.hasNext();) {
					Tweet tweet = (Tweet) iterator.next();
					System.out.println("Usuario: " + tweet.getUsuario() + " " + "Mensagem: " + tweet.getMensagem());
				}
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				Vector<Tweet> timeline = myTwitter.tweets("@esteves");
				for (Iterator<Tweet> iterator = timeline.iterator(); iterator.hasNext();) {
					Tweet tweet = (Tweet) iterator.next();
					System.out.println("Usuario: " + tweet.getUsuario() + " " + "Mensagem: " + tweet.getMensagem());
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
