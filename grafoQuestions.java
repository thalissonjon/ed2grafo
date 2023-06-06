import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GrafoQuestions {
    private static Boolean visitou[];
    private static Double distancia[];
    private static Integer vertexdistancia[];
    private static Integer predecessor[];
    private static ArrayList<Integer[]> pontes;

    /**
	 * Q2 A
	 * @param grafo
     * @param source
     * @param dest
	 * @return
	 */
    public static int BFS_distanciaDest(grafo g, Integer source, Integer dest){
        validate(g, source, dest);
        BFS(g, source);
        return vertexdistancia[dest];
    }

    /**
	 * Q2 B
	 * @param grafo
  * @param source
	 * @return
	 */
    public static Integer[] BFS_sourcetoDest(grafo g, Integer source, Integer dest){
        validate(g, source, dest);
        BFS(g, source);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int auxPredecessor = dest;
        ans.add(auxPredecessor);
        while(auxPredecessor != predecessor[auxPredecessor]){
            auxPredecessor = predecessor[auxPredecessor];
            ans.add(auxPredecessor);
        }
        Collections.reverse(ans);
        Integer[] r = new Integer[ans.size()];

        return ans.toArray(r);
    }

    /**
	 * Q3 B
	 * @param grafo
   * @param source
  * @param distanciaToCheck
	 * @return
	 */
    public static Integer[] BFS_vertDist(grafo g, Integer source, double distanciaToCheck){
        validate(g, source);
        BFS(g, source);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=1; i<=g.getNumComponentes(); i++)
            if(distancia[i] == distanciaToCheck)
                ans.add(i);

        Integer[] r = new Integer[ans.size()];
        return ans.toArray(r);
    }


  //funçoes de validaçao, revisar e refazer>> log. prop.
    private static void validate(grafo g){
        if(g==null)
            throw new NullPointerException("Grafo nulo.");
    }

    private static void validate(grafo g, Integer source, Integer dest){
        validate(g);
        if(source<0 || dest<0 || source>g.getNumComponentes() || dest>g.getNumComponents())
            throw new IllegalArgumentException("Grafo inválido.");
    }

    private static void validate(Grafo g, Integer source){
        validate(g);
        if(source<0 || source>g.getNumComponentes())
            throw new IllegalArgumentException("Grafo inválido.");
    }

  **
	 * Q3
	 * @param graph
	 * @return menor circ
	 */

     public static Double circunferencia(grafo g){
        validate(g); //validaçao
        Double menorCircunferencia = Double.POSITIVE_INFINITY;
        for(int i=1; i<=g.getNumComponentes(); i++)
                menorCircunferencia = Math.min(menorCircunferencia, DFS_GetMenorCiclo(g, i));
        return menorCircunferencia;
    }

//refazer, analisar, refazer com propria log. 
// v1 - codigo analisado > passar relat refeito 21/04
    private static double DFS_MenorCiclo(grafo g, Integer source){
   
        visitou[source] = true;
        distancia[source] = 0.0;
        vertexDistance[source] = 0;
        predecessor[source] = source;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(source);
        double smallerCycle = Double.POSITIVE_INFINITY;
        
        while(!q.isEmpty()){
            Integer u = q.remove();
            for(Graph.Adjacencia v : g.getAdjacencia(u)){
                if(visitou[v.dest] && predecessor[u] != v.dest)
                    menorCiclo = Math.min(smallerCycle, distancia[v.dest] + distancia[u] + v.peso);
                

                if(visitou[v.dest]==false){
                    visitou[v.dest] = true;
                    vertexDistance[v.dest] = vertexDistance[u] + 1;
                    distancia[v.dest] = distancia[u] + v.peso;
                    predecessor[v.dest] = u;
                    q.add(v.dest);
                }
            }
        }
        return menorCiclo;
    }

}