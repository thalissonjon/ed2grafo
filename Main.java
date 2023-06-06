import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insira");
        Integer v = in.nextInt();

        grafoDirecionado graph = new grafoDirecionado(v);

        System.out.println("Insira");
        for(int i=0; i<v; i++)
            graph.connect(in.nextInt(), in.nextInt());
        
        System.out.println(distanciaDest(graph));
        
        System.out.println(graph);

        //GraphUtils.DFS_Pontes(graph);

        in.close();
    }
}