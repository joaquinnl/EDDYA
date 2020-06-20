import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
class ChainExplosive{
     static class Graph{
        private int fila;
        private int columna;  
        public Graph(int fila,int columna){
            this.fila=fila;
            this.columna=columna;
        }
        public int getColumna() {
            return columna;
        }
        public int getFila() {
            return fila;
        }
        public void setColumna(int columna) {
            this.columna = columna;
        }
        public void setFila(int fila) {
            this.fila = fila;
        }
        public boolean Restricciones(int false_matrix[][], int false_fila, int false_columna,  boolean visitados[][]) { 
            if(false_fila<0)
                return false;
            else if(false_columna<0)
                return false;
            else if(false_fila >= getFila())
                return false;
            else if(false_columna>= getColumna())
                return false;

            return false_matrix[false_fila][false_columna]==1 && !visitados[false_fila][false_columna];
            
        } 
        public void crear_dfs(int false_matrix[][], int false_fila, int false_columna, boolean visitados[][]) { 
            int  Fila[] =new int[] { -1, -1, -1, 0, 0, 1, 1, 1 }; 
            int Columna[] =new int[] { -1, 0, 1, -1, 1, -1, 0, 1 }; 
            visitados[false_fila][false_columna] = true; 
            Queue<Graph> queue=new LinkedList<Graph>();
            Graph tmp=new Graph(false_fila,false_columna);
            int tmp1,tmp2;
            queue.add(tmp);
            while (!queue.isEmpty()){ 
                tmp1=queue.peek().getFila();
                tmp2=queue.peek().getColumna();
                queue.remove();
            for (int i = 0; i < 8; ++i){
                if (Restricciones(false_matrix, tmp1 + Fila[i], tmp2 + Columna[i], visitados)){
                    visitados[tmp1+Fila[i]][tmp2+Columna[i]]=true;
                    tmp=new Graph(tmp1+Fila[i],tmp2+Columna[i]);
                    queue.add(tmp);
                } 
            }
        }      
    }
        public void Islas(int false_matrix[][]) { 
            boolean visitados[][] = new boolean[getFila()][getColumna()]; 
            int cont = 0; 
            for (int i = 0; i < getFila(); ++i){
                for (int j = 0; j < getColumna(); ++j) {
                    if (false_matrix[i][j] == 1 && !visitados[i][j]){
                        crear_dfs(false_matrix, i, j, visitados); 
                        ++cont; 
                    } 
                }       
            }
            System.out.println(cont); 
        }
    }
       
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),m=scanner.nextInt();
        
        int matrix[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                matrix[i][j]=scanner.nextInt();
        }
        Graph I=new Graph(n,m);
        I.Islas(matrix);
        scanner.close();
    }
}
