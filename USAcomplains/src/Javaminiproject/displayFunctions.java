package Javaminiproject;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class displayFunctions {

	CSVfileread cv = new CSVfileread();
	
	void loadData() {
		cv.fileLoad();
	}
	void basedOnYear(String year ) {
		for(Map.Entry<String,complains> entry : cv.getBankObj().entrySet()) {
			if(entry.getValue().dateReceived.contains(year)) {
				System.out.println(entry.getValue().issue);
			}
			else {
				System.out.println("invalid year");
			}
		}
	}
	
	void basedOnCompany(String company) {
		for(Map.Entry<String , complains> m1 : cv.getBankObj().entrySet()) {
			if(m1.getValue().company.trim().contains(company.trim())) {
				System.out.println(m1.getValue().issue);
			}
			else {
				System.out.println("Company Not Found");
			}
		}
	}
	
	void basedOnComplaintID(String id) {
		if (cv.getBankObj().containsKey(id)) {
			System.out.println(cv.getBankObj().get(id).dateReceived + " "
					+ cv.getBankObj().get(id).product + " "
					+ cv.getBankObj().get(id).subProduct + " "
					+ cv.getBankObj().get(id).issue + " "
					+ cv.getBankObj().get(id).subIssue + " "
					+ cv.getBankObj().get(id).company + " "
					+ cv.getBankObj().get(id).ZIPcode + " "
					+ cv.getBankObj().get(id).state + " "
					+ cv.getBankObj().get(id).submittedVia + " "
					+ cv.getBankObj().get(id).dateSentToCompany + " "
					+ cv.getBankObj().get(id).companyResponseToConsumer + " "
					+ cv.getBankObj().get(id).timelyResponse + " "
					+ cv.getBankObj().get(id).consumerDisputed);
		} else {
			System.out.println("Complaint ID does not exists.");
		}
	}
	
	void NoOfDaysTOCloseComplaint(String id) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

			if (cv.getBankObj().containsKey(id)) {
				Date date1 = sdf.parse(cv.getBankObj().get(id).dateReceived);
				Date date2 = sdf.parse(cv.getBankObj().get(id).dateSentToCompany);
				long timeDiff = Math.abs(date2.getTime() - date1.getTime());
				long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
				System.out.println("Days taken to close the complaint: " + daysDiff);

			} else {
				System.out.println("Complaint ID does not exists.");
			}
		} catch (ParseException error) {
			System.out.println("Something went wrong");
		}
	}
	
	
	void complaintsClosed() {
		for (Map.Entry<String, complains> entry : cv.getBankObj().entrySet()) {
			String compResp = entry.getValue().companyResponseToConsumer;

			if (compResp.equalsIgnoreCase("Closed") || compResp.equalsIgnoreCase("Closed with explanation")) {
				System.out.println(entry.getValue().dateReceived + " " 
						+ entry.getValue().product + " "
						+ entry.getValue().subProduct + " " 
						+ entry.getValue().issue + " " + 
						entry.getValue().subIssue
						+ " " + entry.getValue().company + 
						" " + entry.getValue().ZIPcode + " " +
						entry.getValue().state
						+ " " + entry.getValue().submittedVia + " " + 
						entry.getValue().dateSentToCompany + " "
						+ entry.getValue().companyResponseToConsumer + " " +
						entry.getValue().timelyResponse + " "
						+ entry.getValue().consumerDisputed);
			}
			
		}
	}
		
		void ReceivingTimelyResponse() {
			for (Map.Entry<String, complains> entry : cv.getBankObj().entrySet()) {
				if (entry.getValue().timelyResponse.equals("Yes")) {
					System.out.println(entry.getValue().dateReceived + " " + entry.getValue().product + " "
							+ entry.getValue().subProduct + " " + entry.getValue().issue + " " + entry.getValue().subIssue
							+ " " + entry.getValue().company + " " + entry.getValue().ZIPcode + " " + entry.getValue().state
							+ " " + entry.getValue().submittedVia + " " + entry.getValue().dateSentToCompany + " "
							+ entry.getValue().companyResponseToConsumer + " " + entry.getValue().timelyResponse + " "
							+ entry.getValue().consumerDisputed);
				}
			}
	}
		public displayFunctions() {
			super();
		}
	
	
	
}
