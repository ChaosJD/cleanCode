public class b_MethodsOverload {
    // Example

    static int addiere(int x, int y) {
        System.out.println("addiere");
        return x + y;
    }

    static int addiere(double x, double y) {
        System.out.println("addiere");
        return (int) (x + y);
    }

    static int addiere(int a, int b, int c) {
        System.out.println("addiere");
        return a + b + c;
    }


    static int addiere(int a, int b, int c, int d) {
        System.out.println("addiere");
        return a + b + c + d;
    }


    public static void main(String[] args) {
        //addiere()
    }
}
