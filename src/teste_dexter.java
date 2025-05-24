import java.util.List;
import java.util.Scanner;

public class teste_dexter {

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

        Algoritimo_de_Dexter fds = new Algoritimo_de_Dexter(15);

        fds.criarAresta(encruzilhadaEsquecida, dirtmounth, 5);
        fds.criarAresta(encruzilhadaEsquecida, picoDeCristal, 90);
        fds.criarAresta(encruzilhadaEsquecida, penhascosUivantes, 150);
        fds.criarAresta(encruzilhadaEsquecida, caminhoVerde, 120);
        fds.criarAresta(encruzilhadaEsquecida, terraDoDescanso, 60);
        fds.criarAresta(encruzilhadaEsquecida, ermosFungicos, 100);

        fds.criarAresta(caminhoVerde, jardinsDaRainha, 80);
        fds.criarAresta(caminhoVerde, canionDaNevoa, 130);

        fds.criarAresta(terraDoDescanso, cidadeDasLagrimas, 30);

        fds.criarAresta(jardinsDaRainha, canionDaNevoa, 80);
        fds.criarAresta(jardinsDaRainha, ninhoProfundo, 90);

        fds.criarAresta(canionDaNevoa, ermosFungicos, 140);

        fds.criarAresta(ermosFungicos, ninhoProfundo, 100);
        fds.criarAresta(ermosFungicos, hidroviaReal, 70);
        fds.criarAresta(ermosFungicos, cidadeDasLagrimas, 80);

        fds.criarAresta(hidroviaReal, baciaAntiga, 70);
        fds.criarAresta(hidroviaReal, cidadeDasLagrimas, 20);

        fds.criarAresta(cidadeDasLagrimas, baciaAntiga, 20);
        fds.criarAresta(cidadeDasLagrimas, bordaDoReino, 20);

        fds.criarAresta(ninhoProfundo, baciaAntiga, 20);

        fds.criarAresta(baciaAntiga, bordaDoReino, 20);

        fds.criarAresta(bordaDoReino, colmeia, 120);


        Scanner in = new Scanner(System.in);
        while(true) {
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

        List<Integer> caminho = fds.caminhoMinimo(origem, destino);

        for (Integer estacao : caminho) {
            System.out.print(estacao + " --> ");
        }
        System.out.println("fim da rota!");

        int custoTotal = fds.custoDaRota(caminho);
        System.out.println("\nCusto total da rota: " + custoTotal + " segundos!");
        System.out.println("\n------------------------------------------------------------------------");


        }

    }
}
