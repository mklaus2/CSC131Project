public class Client {
    public static void main(String[] args) throws Exception {
        Nominee N0 = new Nominee("Titanic");
        Nominee N1 = new Nominee("Avengers");
        Nominee N2 = new Nominee("Shawshank");
        Nominee N3 = new Nominee("Matrix");
        Nominee N4 = new Nominee("Lord of the Rings");
        Nominee N5 = new Nominee("Fight Club");

        User U0 = new User("Jeremy", false);

        System.out.println(U0);

        U0.add_watchlist(N0);
        System.out.print(U0.total_watched() + " ");
        for(int i=0; i < U0.get_watchlist().length; i++){
            System.out.print(U0.get_watchlist()[i] + " ");
        }
        System.out.println();

        U0.add_watchlist(N1);
        System.out.print(U0.total_watched() + " ");
        for(int i=0; i < U0.get_watchlist().length; i++){
            System.out.print(U0.get_watchlist()[i] + " ");
        }
        System.out.println();

        U0.add_watchlist(N2);
        System.out.print(U0.total_watched() + " ");
        for(int i=0; i < U0.get_watchlist().length; i++){
            System.out.print(U0.get_watchlist()[i] + " ");
        }
        System.out.println();

        U0.add_watchlist(N3);
        System.out.print(U0.total_watched() + " ");
        for(int i=0; i < U0.get_watchlist().length; i++){
            System.out.print(U0.get_watchlist()[i] + " ");
        }
        System.out.println();

        U0.add_watchlist(N4);
        System.out.print(U0.total_watched() + " ");
        for(int i=0; i < U0.get_watchlist().length; i++){
            System.out.print(U0.get_watchlist()[i] + " ");
        }
        System.out.println();

        U0.add_watchlist(N5);
        System.out.print(U0.total_watched() + " ");
        for(int i=0; i < U0.get_watchlist().length; i++){
            System.out.print(U0.get_watchlist()[i] + " ");
        }
        System.out.println();

        U0.change_admin();
        System.out.println(U0);
    }
}