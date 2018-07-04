package testes;

import java.io.IOException;

import armazenamento.RepositorioVector;
import armazenamento.RepositorioXStream;
import exceções.PDException;
import exceções.PEException;
import exceções.PIException;
import exceções.UNCException;
import serviço.MyTwitter;
import usuario.PessoaFisica;

public class Add {
	public static void main(String[] args) {
		
		RepositorioXStream db = null;
		
		try {
			//db = new RepositorioVector();
			db = new RepositorioXStream(".\\data\\", "data.xml");
			
			MyTwitter myTwitter = new MyTwitter(db);
			
			try {
				myTwitter.criarPerfil(new PessoaFisica("@lesteves"));
			} catch (PEException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				myTwitter.criarPerfil(new PessoaFisica("@lucasesteves"));
			} catch (PEException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				myTwitter.criarPerfil(new PessoaFisica("@lucasesteves"));
			} catch (PEException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
			try {
				myTwitter.criarPerfil(new PessoaFisica("@lrock"));
			} catch (PEException e) {
				System.out.println(e.getMessage() +": " +e.getUsuario());
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		
		
		
		
		
		
		
		
		
	}
}
