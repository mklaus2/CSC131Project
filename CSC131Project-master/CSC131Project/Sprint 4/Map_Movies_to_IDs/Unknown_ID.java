import java.io.*;

public class Unknown_ID {

    public Unknown_ID(){}

    public void ADD_ID() throws IOException {
        String row;
        BufferedReader tsv_reader = new BufferedReader(new FileReader("movie_list_03.tsv"));
        FileWriter tsv_writer = new FileWriter("movie_list_04.tsv");

        while ((row = tsv_reader.readLine()) != null) {
            //new
            //data[0] -> year
            //data[1] -> category
            //data[2] -> sub_category
            //data[3] -> winner
            //data[4] -> entity
            //data[5] -> id

            String[] data = row.split("\t");

            tsv_writer.append(data[0]);
            tsv_writer.append("\t");
            tsv_writer.append(data[1]);
            tsv_writer.append("\t");
            tsv_writer.append(data[2]);
            tsv_writer.append("\t");
            tsv_writer.append(data[3]);
            tsv_writer.append("\t");
            tsv_writer.append(data[4]);
            tsv_writer.append("\t");

            if(data.length > 5){
                tsv_writer.append(data[5]);
            }else{
                tsv_writer.append("missing");
            }

            tsv_writer.append("\n");

        }

        tsv_reader.close();
        tsv_writer.close();

    }

    public static void main(String[] args) throws Exception {
        Unknown_ID C = new Unknown_ID();
        C.ADD_ID();
    }
}
