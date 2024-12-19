package br.com.alura.Screenmatch.service;


import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

//Caso haja problemas com o ChatGPT, Utilize o outro meio de tradução com o MyMemory, O que implementarei para funcionar agora nessa Branch
public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_APIKEY")); //Informando a API por meio de variavel de ambiente

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}

