import java.util.ArrayList;
import java.util.Iterator;

public abstract class grafo {
	
    private ArrayList<Adjacencia>[] componentes;
    private Adjacencia ultAdjacencia = null;
    private Integer numcomponentes;
    private Integer actDesativPos = 1;
    private Iterator<Adjacencia> actDesativIt = null;

    public class Adjacencia{
      Integer dest;
      double peso;
      boolean on;

      public Adjacencia(Integer dest, double peso){            
    	this.dest = dest;
        this.peso = peso;
        this.on = true;
        }
        public void setAtiv(Boolean newValue){ 
          this.on = newValue;
        }
    }

    public class Connection{ //conec de/para. aplicar do rasc. nao esquecer de comentar do doc. aplic tostring
        Integer from;
        Integer to;

        public Connection(Integer from, Integer to){
            this.from = from;
            this.to = to;
        }

        public String toString() {
            return from + " para " + to;
        }
    }

    public Connection getActConnection(){
        return new Connection(actDesativPos, ultAdjacencia.dest);
    }

    public Boolean desativProx(){
        if(actDesativPos>this.getNumcomponentes())
            return false;
        if(actDesativIt == null)
            actDesativIt = componentes[actDesativPos].iterator();
        
        if(actDesativIt.hasNext()){
            if(ultAdjacencia!=null)
                ultAdjacencia.setAtiv(true);
            Adjacencia adj = actDesativIt.next();
            ultAdjacencia = adj;
            adj.setAtiv(false);
            return true;
        }else{
            actDesativPos++;
            if(actDesativPos<=numcomponentes)
                actDesativIt = componentes[actDesativPos].iterator();
            
            desativProx();
        }
        return true;

    }

    /**
	 * Criando o grafo
	 * @param n
	 * @return
	 */
    public grafo(Integer n){
        componentes = (ArrayList<Adjacencia>[]) new ArrayList[n+1];
        this.numcomponentes = n;
        for(int i=1; i<=n; i++)
            componentes[i] = new ArrayList<Adjacencia>();
    }

    /**
	 * Adjacencia com peso do grafo /OBS!
	 * @param source
     * @param dest
     * @param double
	 * @return
	 */
    public void connect(Integer source, Integer dest, double peso){
        componentes[source].add(new Adjacencia(dest, peso));

    }

    /**
	 * Adjacencia sem peso do grafo
	 * @param source
     * @param dest
	 * @return
	 */
    public void connect(Integer source, Integer dest){
        componentes[source].add(new Adjacencia(dest, 1));

    }

    public Integer getNumcomponentes(){
        return this.numcomponentes;
    }

    public ArrayList<Adjacencia> getAdjacencia(Integer i){
        return componentes[i];
    }

    @Override
    public String toString() {
        String ans = "";
        for(int i=1; i<componentes.length; i++)
            for(Adjacencia adj : componentes[i])
                ans += i + " -> " + adj.dest + " - peso: " + adj.peso + "\n";

        return ans;
    }
    
}