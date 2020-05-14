import java.io.*;
public class Big_CSV_Sort {


    public Big_CSV_Sort(){}

    public void Sort() throws IOException {
        String row;
        BufferedReader csv_reader = new BufferedReader(new FileReader("data.tsv"));
        FileWriter csv_writer = new FileWriter("movie_OMDB.tsv");

        while ((row = csv_reader.readLine()) != null) {
            //data[0] -> OMDb ID
            //data[1] ->
            //data[2] -> Title
            //data[3] -> Original Title
            //data[4]
            //data[5] -> year

            String[] data = row.split("\t");
            if(!(data[1].contains("Series") || data[1].contains("Episode") || data[1].contains("Game") || data[1].equals("video"))){
                csv_writer.append(data[0]);
                csv_writer.append("\t");
                csv_writer.append(data[5]);
                csv_writer.append("\t");
                csv_writer.append(data[2]);
                csv_writer.append("\t");
                csv_writer.append(data[3]);
                csv_writer.append("\t");
                csv_writer.append(data[1]);
                csv_writer.append("\n");
            }
        }
        csv_reader.close();
        csv_writer.close();
    }

    public static void main(String[] args) throws Exception {
        Big_CSV_Sort C = new Big_CSV_Sort();
        C.Sort();
    }
}
