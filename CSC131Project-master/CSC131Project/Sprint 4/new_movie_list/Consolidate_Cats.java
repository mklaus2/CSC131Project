import java.io.*;

public class Consolidate_Cats {

        public Consolidate_Cats(){}

        public void Consol() throws IOException {
            String row;
            BufferedReader csv_reader = new BufferedReader(new FileReader("movie_list.csv"));
            FileWriter csv_writer = new FileWriter("new_movie_list.csv");

            while ((row = csv_reader.readLine()) != null) {
                //data[0] -> year
                //data[1] -> category
                //data[2] -> winner
                //data[3] -> entity

                //new
                //data[0] -> year
                //data[1] -> new category
                //data[2] -> category
                //data[3] -> winner
                //data[4] -> entity

                String[] data = row.split(",");

                csv_writer.append(data[0]);
                csv_writer.append(",");
                csv_writer.append(new_cat(data[1]));
                csv_writer.append(",");
                csv_writer.append(data[1]);
                csv_writer.append(",");
                csv_writer.append(data[2]);
                csv_writer.append(",");
                csv_writer.append(data[3]);

                if(data.length > 4){
                    for(int i=4; i < data.length ; i++){
                        csv_writer.append(",");
                        csv_writer.append(data[i]);
                    }
                }

                csv_writer.append("\n");

            }

            csv_reader.close();
            csv_writer.close();
        }

        private String new_cat(String cat){

            if(cat.contains("ART DIRECTION"))
                return "ART DIRECTION";

            if(cat.contains("BEST MOTION PICTURE") || cat.contains("OUTSTANDING"))
                return "BEST PICTURE";

            if(cat.contains("CINEMATOGRAPHY"))
                return "CINEMATOGRAPHY";

            if(cat.contains("COSTUME DESIGN"))
                return "COSTUME DESIGN";

            if(cat.contains("DOCUMENTARY"))
                return "DOCUMENTARY";

            if(cat.contains("MAKEUP"))
                return "MAKEUP";

            if(cat.contains("MUSIC"))
                return "MUSIC";

            if(cat.contains("SHORT FILM") || cat.contains("SHORT SUBJECT"))
                return "SHORT FILM";

            if(cat.contains("SOUND"))
                return "SOUND";

            if(cat.contains("SPECIAL ACHIEVEMENT AWARD"))
                return "SPECIAL ACHIEVEMENT AWARD";

            if(cat.contains("VISUAL EFFECTS"))
                return "SPECIAL EFFECTS";

            if(cat.contains("WRITING"))
                return "WRITING";

            return cat;
        }

        public static void main(String[] args) throws Exception {
            Consolidate_Cats C = new Consolidate_Cats();
            C.Consol();
        }



}
