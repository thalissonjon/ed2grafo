public class grafoDirecionado extends grafo{
    
    /**
	 * Criando o grafo
	 * @param n
	 * @return
	 */
    public grafoDirecionado(int n){
        super(n);

    }
    

    /**
	 * Adjacencia com peso do grafo /OBS!
	 * @param source
     * @param dest
     * @param double
	 * @return
	 */
    @Override
    public void connect(Integer source, Integer dest, double peso){
        super.connect(source, dest, peso);

    }

    /**
	 * Adjacencia sem peso do grafo
	 * @param source
     * @param dest
	 * @return
	 */
    @Override
    public void connect(Integer source, Integer dest){
        super.connect(source, dest);
    }
}