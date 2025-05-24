import java.security.InvalidParameterException;
import java.util.*;

public class Algoritimo_de_Dexter {

    public int vertices[][];

    public Algoritimo_de_Dexter(final int numVertices) {
        vertices = new int[numVertices][numVertices];
    }

    public void criarAresta(final int noOrigem, final int noDestino, final int peso) {

        if(peso >= 1) {
            vertices[noOrigem][noDestino] = peso;
            vertices[noDestino][noOrigem] = peso;
        }
        else {
            throw new InvalidParameterException("O peso do no origem["+noOrigem+"] para o no destino ["+noDestino+"] nao pode ser negativo!");
        }

    }

    private int getMaisProximo(final int listaCusto[], final Set<Integer> naoVisitados){

        int minDistancia = Integer.MAX_VALUE;
        int noProximo = 0;
        for(Integer i : naoVisitados){
            if(listaCusto[i] < minDistancia){
                minDistancia = listaCusto[i];
                noProximo = i;
            }
        }

        return noProximo;
    }

    private List<Integer> getVizinhos(final int no) {
        List<Integer> vizinhos = new ArrayList<Integer>();
        for(int i = 0; i < vertices.length; i++){
            if(vertices[no][i] > 0){
                vizinhos.add(i);
            }
        }
        return vizinhos;
    }

    private int getCusto(final int noOrigem, final int noDestino) {
        return vertices[noOrigem][noDestino];
    }

    public List<Integer> caminhoMinimo(final int noOrigem, final int noDestino) {

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

    public List<Integer> caminhoMaisProximo(final int antecessor[], int noMaisProximo) {

        List<Integer> caminho = new ArrayList<Integer>();
        caminho.add(noMaisProximo);

        while(antecessor[noMaisProximo] != -1){
            caminho.add(antecessor[noMaisProximo]);
            noMaisProximo = antecessor[noMaisProximo];
        }

        Collections.reverse(caminho);
        return caminho;
    }

    public int custoDaRota(List<Integer> caminho) {
        int custoTotal = 0;
        for (int i = 0; i < caminho.size() - 1; i++) {
            int origem = caminho.get(i);
            int destino = caminho.get(i + 1);
            custoTotal += vertices[origem][destino];
        }
        return custoTotal;
    }

}
