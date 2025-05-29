import java.util.*;
import java.util.Scanner;

public class Main {

    /*
    * Comecamos criando as variveis do tipo inteiro que respresentam as localidades no mapa que foram representados no grafo
    * */

    private static final int dirtmounth = 0;
    private static final int encruzilhadaEsquecida = 1;
    private static final int picoDeCristal = 2;
    private static final int penhascosUivantes = 3;
    private static final int caminhoVerde = 4;
    private static final int terraDoDescanso = 5;
    private static final int jardinsDaRainha = 6;
    private static final int canionDaNevoa = 7;
    private static final int ermosFungicos = 8;
    private static final int cidadeDasLagrimas = 9;
    private static final int bordaDoReino = 10;
    private static final int ninhoProfundo = 11;
    private static final int hidroviaReal = 12;
    private static final int colmeia = 13;
    private static final int baciaAntiga = 14;

    public static void main(String[] args) {

        Algoritmo_de_Djikstra ADD = new Algoritmo_de_Djikstra(15);

        /*
         * Apos criar o objeto ADD, chamamos o metodo criarAresta para poder atribuir os pesos entre cada conexao dos vertices
         * */

        ADD.criarAresta(encruzilhadaEsquecida, dirtmounth, 5);
        ADD.criarAresta(encruzilhadaEsquecida, picoDeCristal, 90);
        ADD.criarAresta(encruzilhadaEsquecida, penhascosUivantes, 150);
        ADD.criarAresta(encruzilhadaEsquecida, caminhoVerde, 120);
        ADD.criarAresta(encruzilhadaEsquecida, terraDoDescanso, 60);
        ADD.criarAresta(encruzilhadaEsquecida, ermosFungicos, 100);

        ADD.criarAresta(caminhoVerde, jardinsDaRainha, 80);
        ADD.criarAresta(caminhoVerde, canionDaNevoa, 130);

        ADD.criarAresta(terraDoDescanso, cidadeDasLagrimas, 30);

        ADD.criarAresta(jardinsDaRainha, canionDaNevoa, 80);
        ADD.criarAresta(jardinsDaRainha, ninhoProfundo, 90);

        ADD.criarAresta(canionDaNevoa, ermosFungicos, 140);

        ADD.criarAresta(ermosFungicos, ninhoProfundo, 100);
        ADD.criarAresta(ermosFungicos, hidroviaReal, 70);
        ADD.criarAresta(ermosFungicos, cidadeDasLagrimas, 80);

        ADD.criarAresta(hidroviaReal, baciaAntiga, 70);
        ADD.criarAresta(hidroviaReal, cidadeDasLagrimas, 20);

        ADD.criarAresta(cidadeDasLagrimas, baciaAntiga, 20);
        ADD.criarAresta(cidadeDasLagrimas, bordaDoReino, 20);

        ADD.criarAresta(ninhoProfundo, baciaAntiga, 20);

        ADD.criarAresta(baciaAntiga, bordaDoReino, 20);

        ADD.criarAresta(bordaDoReino, colmeia, 120);


        Scanner in = new Scanner(System.in); //Classe responsavel por ler o imput do usuario

        while(true){

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Seja bem vindo ao mapa de Hollow Knight");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("00 - Dirtmouth");
        System.out.println("01 - Encruzilhada Esquecida");
        System.out.println("02 - Pico de Cristal");
        System.out.println("03 - Penhascos Uivantes");
        System.out.println("04 - Caminho Verde");
        System.out.println("05 - Terra do Descanso");
        System.out.println("06 - Jardins da Rainha");
        System.out.println("07 - Cânion da Névoa");
        System.out.println("08 - Ermos Fúngicos");
        System.out.println("09 - Cidade das Lágrimas");
        System.out.println("10 - Borda do Reino");
        System.out.println("11 - Ninho Profundo");
        System.out.println("12 - Hidrovia Real");
        System.out.println("13 - Colmeia");
        System.out.println("14 - Bacia Antiga");
        System.out.println("------------------------------------------------------------------------");


        System.out.println("Por favor, entre com a sua rota ou pressione ENTER para sair do programa");
        System.out.println("------------------------------------------------------------------------");

        System.out.print("Insira o local de origem: ");
        int origem = in.nextInt();

        System.out.print("Insira o local de Destino: ");
        int destino = in.nextInt();
        System.out.println("------------------------------------------------------------------------\n");

        List<Integer> caminho = ADD.caminhoMinimo(origem, destino); //chamamos o metodo que nos retorna uma lista com os vertices que representam o caminho mais curto entre a origem e destino informado pelo usuario

        for (Integer estacao : caminho) {
            System.out.print(estacao + " --> ");
        }
        System.out.println("fim da rota!");

        int custoTotal = ADD.custoDaRota(caminho); //chamamos o metodo custoDaRota para poder informar o usuario o custo total da rota em segundos
        System.out.println("\nCusto total da rota: " + custoTotal + " segundos!");
        System.out.println("\n------------------------------------------------------------------------");

    }
    }
}
