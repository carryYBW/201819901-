package oopSystem2.test;



import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class testCSV {
	public static void main(String[] args) throws IOException{
		int col = 0 ;

		String pathCSV = "D:\\01-studyData\\2020大三实验报告\\软件构造\\JavaCSV\\test.csv";
		String pathCSVWrite = "D:\\01-studyData\\2020大三实验报告\\软件构造\\JavaCSV\\write.csv";
		ArrayList<String[]> lstFile = new ArrayList<String[]>();
		//cvs文件读入部分
		try {
			CsvReader reader = new CsvReader(pathCSV,',',Charset.forName("gb2312"));
			reader.readHeaders();
			while(reader.readRecord()){
				//System.out.println(reader.getRawRecord());
				lstFile.add(reader.getValues());
			}

			reader.close();
			System.out.println(lstFile.size());
			System.out.println(lstFile.get(5)[0].toString());
			for(int row = 0 ; row < lstFile.size(); row ++ ){
				for(col=0;col<lstFile.get(row).length;col++){
					String cell = lstFile.get(row)[col];
					System.out.print(cell);
				}
				System.out.println();
			}
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//cvs文件写入部分
		try{
			CsvWriter csvWriter = new CsvWriter(pathCSVWrite,',',Charset.forName("gb2312"));
			String[] csvHeader = {"网点名称","省份","城市","地址","电话","主页","服务范围"};
			csvWriter.writeRecord(csvHeader);
			for(int i=0;i<lstFile.size();i++){
				String[] csvContent = lstFile.get(i);
				csvWriter.writeRecord(csvContent);
			}
			csvWriter.close();
			System.out.println("--------------------已完成写入操作--------------");
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

}
