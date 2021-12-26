package aula09;
import java.util.*;

public class CollectionTester {

    public static void main(String[] args) {
        int[] DIM = {1000,5000,10000,20000,40000,100000};
        System.out.printf( "%10s %9d %9d %9d %9d %9d %9d \n","Collection",DIM[0],DIM[1],DIM[2],DIM[3],DIM[4],DIM[5]);

        Collection<Integer> col = new ArrayList<>();
        print(col, DIM);
        Collection<Integer> linked = new LinkedList<>();
        print(linked, DIM);
        Collection<Integer> hash = new HashSet<>();
        print(hash, DIM);
        Collection<Integer> tree = new TreeSet<>();
        print(tree, DIM);
    }

    private static double[] checkPerformance(Collection<Integer> col, int DIM) {
        double start, stop, delta;
        double [] lst=new double[3];
        // Add
        start = System.nanoTime(); // clock snapshot before
        for (int i = 0; i < DIM; i++)
            col.add(i);
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert to milliseconds
        lst[0]=delta;
        // Search
        start = System.nanoTime(); // clock snapshot before
        for (int i = 0; i < DIM; i++) {
            int n = (int) (Math.random() * DIM);
            if (!col.contains(n))
                System.out.println("Not found???" + n);
        }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert nanoseconds to milliseconds
        lst[1]=delta;
        // Remove
        start = System.nanoTime(); // clock snapshot before
        Iterator<Integer> iterator = col.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert nanoseconds to milliseconds
        lst[2]=delta;
        return lst;
    }

    private static void print(Collection<Integer> col, int[] DIM){
        System.out.println(col.getClass().getSimpleName());//print do nome da Collection
        double [][] tempos= new double [3][6];

        int c=0;
        for(int i:DIM){
            double [] lst=checkPerformance(col, i);
            tempos[0][c]=lst[0];
            tempos[1][c]=lst[1];
            tempos[2][c]=lst[2];
            c++;
        }

        c=0;
		String[] m= {"add","search","remove"};
		for (double n[]:tempos) {
			
			System.out.printf("%-10s %9.1f %9.1f %9.1f %9.1f %9.1f %9.1f%n",m[c],n[0],n[1],n[2],n[3],n[4],n[5]);
			c++;
		}
    }
}