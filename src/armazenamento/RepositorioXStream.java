package armazenamento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import exce��es.UJCException;
import exce��es.UNCException;
import usuario.Perfil;

public class RepositorioXStream implements IRepositorioUsuario{
	private XStream db;
	private File caminho;
	private File arquivo;
	private FileOutputStream arquivoSaida;
	private FileInputStream arquivoEntrada;
	
	private RepositorioVector vector;
	
	/**
	 * M�todo construtor da classe, respons�vel por verficar se o caminho passado como argumento existe e cri�-lo caso n�o exista;
	 * verificar se o arquivo passado como argumento existe e cri�-lo caso n�o exista;
	 * caso o arquivo exista, os dados salvos s�o carregados para o atributo vector.
	 * 
	 * @param caminhoArquivo Caminho onde os dados est�o/ser�o salvos
	 * @param nomeArquivo    Nome do arquivo onde os dados est�o/ser�o salvos
	 * @throws IOException	 Lan�ada quando algum problema de escrita ou leitura ocorre
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
