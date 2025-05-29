import java.security.InvalidParameterException;
import java.util.*;

public class Algoritmo_de_Djikstra {                                                                                     //Classe onde estao todos os metodos por tras da logica do Algoritmo de Djikstra

    private int vertices[][];

    public Algoritmo_de_Djikstra(final int numVertices) {
        vertices = new int[numVertices][numVertices];
    }

    public void criarAresta(final int noOrigem, final int noDestino, final int peso) {

        if(peso >= 1) {
            vertices[noOrigem][noDestino] = peso;
            vertices[noDestino][noOrigem] = peso;                                                                       //Metodo responsavel por adicionar o peso do noOrigem ao noDestino
        }
        else {
            throw new InvalidParameterException("O peso do no origem["+noOrigem+"] para o no destino ["+noDestino+"] nao pode ser negativo!");
        }

    }

    private int getMaisProximo(final int listaCusto[], final Set<Integer> naoVisitados){

        int minDistancia = Integer.MAX_VALUE;
        int noProximo = 0;
        for(Integer i : naoVisitados){
            if(listaCusto[i] < minDistancia){                                                                           //Responsavel por encontrar o vertice ainda nao visitado com o menor custo acumulado, ele e usado para decidir qual vai ser o proximo no a ser visitado.
                minDistancia = listaCusto[i];
                noProximo = i;
            }
        }

        return noProximo;
    }

    private List<Integer> getVizinhos(final int no) {
        List<Integer> vizinhos = new ArrayList<Integer>();
        for(int i = 0; i < vertices.length; i++){
            if(vertices[no][i] > 0){                                                                                    //Retorna uma lista dos vertices que estao conectados diretamente ao vertice informado.
                vizinhos.add(i);
            }
        }
        return vizinhos;
    }

    private int getCusto(final int noOrigem, final int noDestino) {                                                     //Retorna uma lista dos vertices que estao conectados diretamente ao vertice informado.
        return vertices[noOrigem][noDestino];
    }

    public List<Integer> caminhoMinimo(final int noOrigem, final int noDestino) {                                       //Calcula o menor caminho entre um vertice de origem e destino, e retorna uma lista com a sequencia de vertices que compem esse caminho.


        int custo[] = new int[vertices.length];
        int antecessor[] = new int[vertices.length];
        Set<Integer> naoVisitados = new HashSet<Integer>();

        custo[noOrigem] = 0;

        for(int v = 0; v < vertices.length; v++){
            if(v != noOrigem){
                custo[v] = Integer.MAX_VALUE;
            }
            antecessor[v] = -1;
            naoVisitados.add(v);
        }

        while(!naoVisitados.isEmpty()){

            int noMaisProximo = getMaisProximo(custo,naoVisitados);

            naoVisitados.remove(noMaisProximo);

            for(Integer vizinhos : getVizinhos(noMaisProximo)){
                int custoTotal = custo[noMaisProximo] + getCusto(noMaisProximo, vizinhos);
                if(custoTotal < custo[vizinhos]){
                    custo[vizinhos] = custoTotal;
                    antecessor[vizinhos] = noMaisProximo;
                }
            }

            if(noMaisProximo == noDestino){
                return caminhoMaisProximo(antecessor, noMaisProximo);
            }

        }

        return null;
    }

    public List<Integer> caminhoMaisProximo(final int antecessor[], int noMaisProximo) {                                //Reconstroi o caminho de destino a origem usando os vertores de antecessores e inverte a ordem deles do incio ao fim.

        List<Integer> caminho = new ArrayList<Integer>();
        caminho.add(noMaisProximo);

        while(antecessor[noMaisProximo] != -1){
            caminho.add(antecessor[noMaisProximo]);
            noMaisProximo = antecessor[noMaisProximo];
        }

        Collections.reverse(caminho);
        return caminho;
    }
    public int custoDaRota(List<Integer> caminho) {                                                                     //Soma todos os pesos das conexoes ao longo do caminho e retorna o valor total da rota.
        int custoTotal = 0;
        for (int i = 0; i < caminho.size() - 1; i++) {
            int origem = caminho.get(i);
            int destino = caminho.get(i + 1);
            custoTotal += vertices[origem][destino];
        }
        return custoTotal;
    }

}
