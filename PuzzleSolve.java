import java.util.ArrayList;

public class PuzzleSolve {

    static int counter = 0;
    public static void main(String[] args) {
        ArrayList<Integer> seq = new ArrayList<>();
        ArrayList<Integer> univ = new ArrayList<>();


        for (int i = 1; i <=8;i++)
        {
            univ.add(i);
        }

        solve(8,seq,univ,new Tester());


        System.out.println(counter);
    }
    public static <E> void solve(int k, ArrayList<E> S, ArrayList<E> U, PuzzleTest<E> t) {

        for (int i = 0; i < U.size(); i++) {
            E e = U.remove(i);
            S.add(e);
            if (k == 1) {
                if (t.test(S)) {
                    t.foundSolution(S);
                }
            } else {
                solve(k - 1, S, U, t);
            }
            U.add(i, e);
            S.remove(S.size() - 1);
        }
    }
}