package njuics.demos.pipefilter;


import org.springframework.batch.item.ItemWriter;
import java.io.*;
import java.util.List;



public class LumpyWriter implements ItemWriter<Report>{

    @Override
    public void write(List<? extends Report> list) throws Exception{
        File file = new File("xml/outputs/outputs.txt");
        FileWriter fileWriter = new FileWriter(file);
        try{
            for(int i = 0;i < list.size();i++){
                Report report = list.get(i);
                fileWriter.write(report.toTxt() + "\r\n");
                fileWriter.flush();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            fileWriter.close();
        }
    }
}
