package com.app_produto.app_produto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class ArquivoService {
    
    private static final String DIRETORIO = "produtos/";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    
    public ArquivoService() {
        // Cria o diretório se não existir
        new java.io.File(DIRETORIO).mkdirs();
    }
    
    public String salvarProdutoEmArquivo(ProdutoDTO produto) {
        String nomeArquivo = DIRETORIO + "produto_" + 
                             LocalDateTime.now().format(FORMATTER) + ".txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("=== DADOS DO PRODUTO ===\n");
            writer.write("Data/Hora: " + LocalDateTime.now() + "\n");
            writer.write("Código: " + produto.getCod() + "\n");
            writer.write("Descrição: " + produto.getDescricao() + "\n");
            writer.write("Quantidade: " + produto.getQuantidade() + "\n");
            writer.write("Preço: R$ " + String.format("%.2f", produto.getPreco()) + "\n");
            writer.write("========================\n");
            
            return nomeArquivo;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}