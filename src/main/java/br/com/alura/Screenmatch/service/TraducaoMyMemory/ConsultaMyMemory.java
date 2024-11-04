package br.com.alura.Screenmatch.service.TraducaoMyMemory;

import br.com.alura.Screenmatch.service.ConsumoAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URLEncoder;

public class ConsultaMyMemory {

    //obtendo a tradução de um texto usando a API MyMemory
    public static String obterTraducao(String text) {
        ObjectMapper mapper = new ObjectMapper();  //instancia o ObjectMapper para converter JSON para objeto Java

        ConsumoAPI consumo = new ConsumoAPI();  //Instanciando a classe que lida com o consumo de APIs

        //codifica o texto a ser traduzido para garantir que caracteres especiais sejam tratados corretamente
        String texto = URLEncoder.encode(text);

        //Define os idiomas de origem e destino (inglês para português)
        String langpair = URLEncoder.encode("en|pt-br");

        //faz a requisição à API com o texto e os idiomas especificados
        String url = "https://api.mymemory.translated.net/get?q=" + texto + "&langpair=" + langpair;

        //armazena a resposta JSON em uma string
        String json = consumo.obterDados(url);

        DadosTraducao traducao;  //armazena o objeto com a tradução

        try {
            //Converte o JSON da resposta em um objeto da classe DadosTraducao
            traducao = mapper.readValue(json, DadosTraducao.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //Retorna o texto traduzido
        return traducao.dadosResposta().textoTraduzido();
    }
}

