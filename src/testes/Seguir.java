package testes;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import armazenamento.RepositorioVector;
import armazenamento.RepositorioXStream;
import exce��es.MFPException;
import exce��es.PDException;
import exce��es.PEException;
import exce��es.PIException;
import exce��es.SIException;
import exce��es.UNCException;
import servi�o.MyTwitter;
import timeline.Tweet;
import usuario.PessoaFisica;

public class Seguir {
	public static void main(String[] args) {
		//RepositorioVector db = new RepositorioVector();
		RepositorioXStream db = null;
		try {
			db = new RepositorioXStream(".\\data\\", "data.xml");
		
			MyTwitter myTwitter = new MyTwitter(db);
			

			try {
				myTwitter.seguir("@lesteves", "@lesteves");
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (SIException e) {
				System.out.println(e.getMessage());
			} catch (UNCException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			try {
				myTwitter.seguir("@lesteves", "@lucasesteves");
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (SIException e) {
				System.out.println(e.getMessage());
			} catch (UNCException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				myTwitter.seguir("@esteves", "@lesteves");
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (SIException e) {
				System.out.println(e.getMessage());
			} catch (UNCException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				myTwitter.seguir("@lrock", "@lesteves");
			} catch (PIException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (PDException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			} catch (SIException e) {
				System.out.println(e.getMessage());
			} catch (UNCException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}	
			
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
}
