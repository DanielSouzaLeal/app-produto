package com.app_produto.app_produto;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*") // Permite requisições de qualquer origem
public class ProdutoRestController {
    
    @Autowired
    private ArquivoService arquivoService;

    @PostMapping("/salvar2")
    public String salvar(@ModelAttribute ProdutoDTO produto) {
        System.out.println("produto: " + produto.toString() + " - processando...");
        
        // Salva em arquivo .txt
        String caminhoArquivo = arquivoService.salvarProdutoEmArquivo(produto);
        
        System.out.println("Arquivo salvo em: " + caminhoArquivo);
        
        return "Produto " + produto.getCod() + " recebido e salvo em arquivo com sucesso.";
    }

    @PostMapping("/json")
    public String dado(@RequestBody Map<String, Object> dado) {
        System.out.println("JSON recebido: " + dado);

        Object nome = dado.get("nome");
        System.out.println("Nome extraído: " + nome);
        
        return "Dado JSON recebido com sucesso.";
    }
    
}