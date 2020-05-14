import java.io.*;

public class TSV_FILL_ID_GAPS {

    public TSV_FILL_ID_GAPS(){}

    public void ADD_ID() throws IOException {
        String row;
        BufferedReader tsv_reader = new BufferedReader(new FileReader("movie_list_02.tsv"));
        FileWriter tsv_writer = new FileWriter("movie_list_03.tsv");

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
                tsv_writer.append(Find_IMDB_ID(data[0], data[4]));
            }

            tsv_writer.append("\n");

        }

        tsv_reader.close();
        tsv_writer.close();

    }

    private String Find_IMDB_ID(String year, String title) throws IOException {
        String row, year0, year1, year2, year3;
        int iyear = 0;
        BufferedReader csv_reader2 = new BufferedReader(new FileReader("movie_OMDB.tsv"));
        while ((row = csv_reader2.readLine()) != null) {
            //data[0] -> OMBD ID
            //data[1] ->
            //data[2] -> Title
            //data[3] -> Original Title
            //data[4]
            //data[5] -> year

            //movie_OMDB.tsv
            //data[0] -> ID
            //data[1] -> year
            //data[2] -> Title
            //data[3] -> Original Title


            String[] data = row.split("\t");

            try{
                iyear = Integer.parseInt(year);
            }
            catch(NumberFormatException e){
                iyear = 0;
            }

            year0 = ""+(iyear-2);
            year1 = ""+(iyear-1);
            year2 = ""+(iyear+1);
            year3 = ""+(iyear+2);


            if(
                (
                    data[1].equals(year) ||
                    data[1].equals(year0) ||
                    data[1].equals(year1) ||
                    data[1].equals(year2) ||
                    data[1].equals(year3)
                    || iyear == 0
                ) &&
                (
                    data[2].equals(title) ||
                    data[3].equals(title)
                )
            ){
                csv_reader2.close();
                return data[0];
            }
        }
        csv_reader2.close();
        return "";
    }

    public static void main(String[] args) throws Exception {
        TSV_FILL_ID_GAPS C = new TSV_FILL_ID_GAPS();
        C.ADD_ID();
    }
}
