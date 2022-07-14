package Javaminiproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class CSVfileread {
	
	String path = "C:\\Users\\Dell\\Downloads\\complaints.csv";
	String line = "";
	Map<String , complains> FileObj = new HashMap<>();
	
	public void fileLoad() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((line=(br.readLine()))!= null)
			{
				String attribute [] = line.split(",");
				complains comp = new complains();
				comp.dateReceived = attribute[0];
				comp.product = attribute[1];
				comp.subProduct= attribute[2];
				comp.issue= attribute[3]; 
				comp.subIssue= attribute[4];
				comp.company= attribute[5];
				comp.state= attribute[6];
				comp.ZIPcode= attribute[7];
				comp.submittedVia= attribute[8];
				comp.dateSentToCompany= attribute[9];
				comp.companyResponseToConsumer= attribute[10];
				comp.timelyResponse= attribute[11];
				comp.consumerDisputed= attribute[12];
				comp.consumerDisputed= attribute[12];
				
				FileObj.put(attribute[13], comp); 
				
			}
			br.close();
		}
		catch(FileNotFoundException f) {
			System.out.println(f);
		}
		catch(IOException e) {
			//System.out.pritnln(e);
			e.printStackTrace();
		}
		
	}
		
		Map<String,complains> getBankObj(){
			
			return FileObj;
		}
		
		
	}
	
	
