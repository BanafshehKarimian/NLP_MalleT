import java.io.*;

/**
 * Created by banafshbts on 18. 5. 21.
 */
public class Reader {

    String read(String name){


        InputStream in = getClass().getResourceAsStream("./"+name);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        String res = "";
        int i=0;
        try {
            while ((line = reader.readLine()) != null) {
                res+=line+"\n";
                i++;
                //System.out.print(line.charAt(0));
                if (line.charAt(0)=='-'){

                    BufferedWriter writer = null;
                    writer = new BufferedWriter(new FileWriter("2/"+i));
                    writer.write(line.replace("-1 | ",""));
                    System.out.print(line.replace("-1 | ","")+"\n");
                    writer.close();

                }
                else{


                    BufferedWriter writer = null;
                    writer = new BufferedWriter(new FileWriter("1/"+i));
                    writer.write(line.replace("1 | ",""));
                    writer.close();

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    String read2(String name){


        InputStream in = getClass().getResourceAsStream("./"+name);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        String res = "";
        int i=0;

        try {
            BufferedWriter writer = null;
            writer = new BufferedWriter(new FileWriter("train"));

            BufferedWriter writer2 = null;
            writer2 = new BufferedWriter(new FileWriter("train2"));

            while ((line = reader.readLine()) != null) {
                res+=line+"\n";
                i++;
                //System.out.print(line.charAt(0));
                String label ="";
                if(line.contains("-1 |"))
                    label="2";
                else
                    label= "1";

                String line2 = line.replace("-1 |","").replace("1 |","").trim();
                //line2 = line2.replace("//","/").replace("//","/");
                String s[] = line2.split(" ");
                String min=s[s.length-1],max=s[s.length-1];
                int minl=s[s.length-1].length(),maxl=s[s.length-1].length();
                for (int j=0;j<s.length;j++){

                    if (s[j].length()<minl){

                        minl=s[j].length();
                        min=s[j];

                    }
                    if (s[j].length()>maxl){

                        maxl=s[j].length();
                        max=s[j];

                    }

                }
                writer.write("l"+i+" "+label+" "+"f1 "+line2.split(" ")[0]);
                writer.newLine();
                writer2.write("l"+i+" "+label+" "+"f1 "+line2.split(" ")[0]+" f2 "+min+" f3 "+max);
                writer2.newLine();
                System.out.print(line2.split(" ")[0]+"\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }


}
