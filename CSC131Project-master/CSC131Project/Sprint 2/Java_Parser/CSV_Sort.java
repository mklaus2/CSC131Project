import java.io.*;
public class CSV_Sort {

    public CSV_Sort(){}

    public void Sort() throws IOException {
        String row;
        BufferedReader csv_reader = new BufferedReader(new FileReader("Oscar_Winner_data_csv.csv"));
        FileWriter movie_writer = new FileWriter("movie_list.csv");
        FileWriter non_movie_writer = new FileWriter("non-movie_list.csv");

        while ((row = csv_reader.readLine()) != null) {
            //data[0] -> year
            //data[1] -> category
            //data[2] -> winner
            //data[3] -> entity

            String[] data = row.split(",");
/*
            if(data[3].contains("Ã")){
                System.out.println("true\n");
                data[3] = data[3].replace("Ã«", "ë");
                data[3] = data[3].replace("Ã©", "é");
                data[3] = data[3].replace("Ãœ", "ü");
                data[3] = data[3].replace("Ã‰", "É");
                data[3] = data[3].replace("Ã¨", "è");
                data[3] = data[3].replace("Ã€", "À");
                data[3] = data[3].replace("Ã±", "ñ");
                data[3] = data[3].replace("Ãª", "ê");
                data[3] = data[3].replace("Ã…", "Å");
                data[3] = data[3].replace("Ã¤", "ä");
                data[3] = data[3].replace("Ã¶", "ö");
                data[3] = data[3].replace("Ã", "à");
            }
*/
            if(purge(data[0], data[1], data[3])){
                non_movie_writer.append(data[0]);
                non_movie_writer.append(",");
                non_movie_writer.append(data[1]);
                non_movie_writer.append(",");
                non_movie_writer.append(data[2]);
                non_movie_writer.append(",");
                non_movie_writer.append(data[3]);

                if(data.length > 4){
                    for(int i=4; i < data.length ; i++){
                        non_movie_writer.append(",");
                        non_movie_writer.append(data[i]);
                    }
                }

                non_movie_writer.append("\n");
            }else{
                movie_writer.append(data[0]);
                movie_writer.append(",");
                movie_writer.append(data[1]);
                movie_writer.append(",");
                movie_writer.append(data[2]);
                movie_writer.append(",");
                movie_writer.append(data[3]);

                if(data.length > 4){
                    for(int i=4; i < data.length ; i++){
                        movie_writer.append(",");
                        movie_writer.append(data[i]);
                    }
                }

                movie_writer.append("\n");
            }
        }
        csv_reader.close();
        movie_writer.close();
        non_movie_writer.close();
    }

    private boolean purge(String year, String category, String entity){
        /*
        ACT
        SCIENTIFIC
        HONORARY
        COMMENDATION
        GORDON
        MEMORIAL
        HUMANITARIAN
        AWARD
         */
        if(year.equals("1927") || year.equals("1928")) return true;

        if(
            entity.contains("To Benjamin Burtt") ||
            entity.contains("To Richard Williams") ||
            entity.contains("To John Lasseter")
        ) return true;

        if(category.contains("SPECIAL ACHIEVEMENT AWARD")) return false;

        if(
            category.contains("ACT") ||
            category.contains("SCIENTIFIC") ||
            category.contains("HONORARY") ||
            category.contains("COMMENDATION") ||
            category.contains("GORDON") ||
            category.contains("MEMORIAL") ||
            category.contains("HUMANITARIAN") ||
            category.contains("AWARD") ||
            category.contains("DANCE")
        ) return true;

        if(year.equals("1929") && category.contains("DIRECTING")) return true;

        if(
                (year.equals("1930") || year.equals("1931"))
                && category.contains("SOUND RECORDING")
        ) return true;

        if(year.equals("1932") && category.contains("ASSISTANT")) return true;


        return false;
    }

    public static void main(String[] args) throws Exception {
        CSV_Sort C = new CSV_Sort();
        C.Sort();
    }


}
