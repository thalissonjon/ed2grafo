public class grafoNaoDirecionado extends grafo{
    
    /**
	 * Criando o grafo
	 * @param n
	 * @return
	 */
    public grafoNaoDirecionado(int n) {
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
        super.connect(dest, source, peso);

    }

    /**
	 * Adiciona uma adjac�ncia sem peso ao grafo
	 * @param source
     * @param dest
	 * @return
	 */
    @Override
    public void connect(Integer source, Integer dest){
        super.connect(source, dest);
        super.connect(dest, source);
    }
    
}