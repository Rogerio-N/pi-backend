package io.github.rogerion.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class AcessaDisco {

	@Value("${contato.disco.raiz}")
	private String raiz;

//	@Value("${contato.disco.diretorio-imagens}")
//	private String diretorioImagens;

//	public void salvarImagem(MultipartFile imagem) {
//		this.salvar(this.diretorioImagens, imagem);
//	}

	public void salvar(String diretorio, MultipartFile imagem) {

		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(imagem.getOriginalFilename());

		try {
			Files.createDirectories(diretorioPath);
			imagem.transferTo(arquivoPath.toFile());
		} catch (IOException e) {
			throw new RuntimeException("Problemas para salvar imagem.", e);
		}

	}

	public void excluir(String diretorio, String nomeImagem) {
		
		if (diretorio != null && nomeImagem != null) { 
			Path arquivoPath = Paths.get(this.raiz, diretorio+"/"+nomeImagem);
			//String arquivoPath = diretorioPath.resolve(imagem.getOriginalFilename());
			System.out.println(arquivoPath);
			try {
				
				//Files.delete(arquivoPath);
				Files.deleteIfExists(arquivoPath);
			}
			catch (IOException e) {
				throw new RuntimeException("Problemas para excluir imagem.", e);
			}
		
		}
	}

}