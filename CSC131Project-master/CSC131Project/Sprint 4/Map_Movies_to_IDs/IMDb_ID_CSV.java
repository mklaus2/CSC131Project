import java.io.*;

public class IMDb_ID_CSV {

    public IMDb_ID_CSV(){}

    public void ADD_ID() throws IOException {
        String row, title="";
        BufferedReader csv_reader = new BufferedReader(new FileReader("new_sort_movie_list.csv"));
        FileWriter csv_writer = new FileWriter("movie_list.tsv");

        while ((row = csv_reader.readLine()) != null) {
            //data[0] -> year
            //data[1] -> category
            //data[2] -> winner
            //data[3] -> entity

            //new
            //data[0] -> year
            //data[1] -> category
            //data[2] -> sub_category
            //data[3] -> winner
            //data[4] -> entity

            String[] data = row.split(",");

            title = data[4];
            if(data.length > 5){
                for(int i=5; i < data.length ; i++){
                    title = title.concat(",");
                    title = title.concat(data[i]);
                }
            }

            csv_writer.append(data[0]);
            csv_writer.append("\t");
            csv_writer.append(data[1]);
            csv_writer.append("\t");
            csv_writer.append(data[2]);
            csv_writer.append("\t");
            csv_writer.append(data[3]);
            csv_writer.append("\t");
            csv_writer.append(title);
            csv_writer.append("\t");
            csv_writer.append(Find_IMDB_ID(data[0], title));

            csv_writer.append("\n");

        }

        csv_reader.close();
        csv_writer.close();

    }

    private String Find_IMDB_ID(String year, String title) throws IOException {
        String row;
        BufferedReader csv_reader2 = new BufferedReader(new FileReader("movie_OMDB.tsv"));
        while ((row = csv_reader2.readLine()) != null) {
            //data[0] -> OMBD ID
            //data[1] ->
            //data[2] -> Title
            //data[3] -> Original Title
            //data[4]
            //data[5] -> year

            //new
            //data[0] -> ID
            //data[1] -> year
            //data[2] -> Title
            //data[3] -> Original Title


            String[] data = row.split("\t");

            if(data[1].equals(year) && ((data[2].equals(title)) || data[3].equals(title))){
                csv_reader2.close();
                return data[0];
            }
        }
            csv_reader2.close();
            return "";
    }

    public static void main(String[] args) throws Exception {
        IMDb_ID_CSV C = new IMDb_ID_CSV();
        C.ADD_ID();
    }
}
