package armazenamento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import exceções.UJCException;
import exceções.UNCException;
import usuario.Perfil;

public class RepositorioXStream implements IRepositorioUsuario{
	private XStream db;
	private File caminho;
	private File arquivo;
	private FileOutputStream arquivoSaida;
	private FileInputStream arquivoEntrada;
	
	private RepositorioVector vector;
	
	/**
	 * Método construtor da classe, responsável por verficar se o caminho passado como argumento existe e criá-lo caso não exista;
	 * verificar se o arquivo passado como argumento existe e criá-lo caso não exista;
	 * caso o arquivo exista, os dados salvos são carregados para o atributo vector.
	 * 
	 * @param caminhoArquivo Caminho onde os dados estão/serão salvos
	 * @param nomeArquivo    Nome do arquivo onde os dados estão/serão salvos
	 * @throws IOException	 Lançada quando algum problema de escrita ou leitura ocorre
	 */
	public RepositorioXStream(String caminhoArquivo, String nomeArquivo) throws IOException {
		db = new XStream();

		caminho = new File(caminhoArquivo);
		
		if(!caminho.exists()) {
			caminho.mkdirs();
		}
		
		arquivo = new File(caminho, nomeArquivo);
				
		arquivoSaida = new FileOutputStream(arquivo, true);
		arquivoEntrada = new FileInputStream(arquivo);
		
		if(arquivo.length() != 0) {
			vector = (RepositorioVector) db.fromXML(arquivoEntrada);	
		}else {
			vector =  new RepositorioVector();
		}
		
		arquivoSaida.close();
		arquivoEntrada.close();
		
	}
	@Override
	public void cadastrar(Perfil usuario) throws UJCException {
		
		vector.cadastrar(usuario);
		
		gravarArquivo();
		
	}

	@Override
	public Perfil buscar(String usuario) {
		return vector.buscar(usuario);
	
	}

	@Override
	public void atualizar(Perfil usuario) throws UNCException {
		vector.atualizar(usuario);
		gravarArquivo();
		
	}
	
	private void gravarArquivo() {
		try {
			arquivoSaida = new FileOutputStream(arquivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		db.toXML(vector, arquivoSaida);
		
		try {
			arquivoSaida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
