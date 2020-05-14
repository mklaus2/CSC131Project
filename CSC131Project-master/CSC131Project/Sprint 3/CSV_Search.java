import java.io.*;
import java.util.*;

public class CSV_Search {
    public CSV_Search(){}

    public void Search() throws IOException {
        String row;
        Scanner Scan = new Scanner(System.in);
        BufferedReader csv_reader = new BufferedReader(new FileReader("movie_list.csv"));
        boolean winner;

        System.out.println("Search only for winners? (y/n)");
        String S = Scan.nextLine();

        if(S.equals("y")){
            winner = true;
        }else{
            winner = false;
        }
        System.out.println("Type the category: ");

        S = Scan.nextLine();

        while ((row = csv_reader.readLine()) != null) {
            //data[0] -> year
            //data[1] -> category
            //data[2] -> winner
            //data[3] -> entity

            String[] data = row.split(",");
            if(data[1].equals(S) && (winner?data[2].equals("True"):true)){
                System.out.print(data[0]+" "+data[1]+" "+data[2]+" "+data[3]);

                if(data.length > 4){
                    for(int i=4; i < data.length ; i++){ System.out.print(","+data[i]); }
                }

                System.out.print("\n");
            }

        }
        csv_reader.close();

    }

    public static void main(String[] args) throws Exception {
        CSV_Search C = new CSV_Search();
        C.Search();
    }

}
