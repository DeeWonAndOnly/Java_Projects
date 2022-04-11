// Dylan Sands
// 112396943
// R30

import java.util.ArrayList;

public class Folder {
	private ArrayList<Email> emails = new ArrayList<Email>();
	private String name;
	private String currentSortingMethod;
	
	public Folder(String name) {
		this.name = name;
		currentSortingMethod = "date_descending";
	}
	
	public void addEmail(Email email) {
		emails.add(email);
	}
	
	public Email removeEmail(int index) throws NotFoundException{
		if(size() == 0) {
			throw new NotFoundException("Email not found!");
		}
		return emails.remove(index);
	}
	
	public Email getEmail(int index) {
		return emails.get(index);
	}
	
	public void simpleSort() {
		if(currentSortingMethod.equals("date_descending")) {
			sortByDateDescending();
		}
		else if(currentSortingMethod.equals("date_ascending")) {
			sortByDateAscending();
		}
		else if(currentSortingMethod.equals("subject_decending")) {
			sortBySubjectDescending();
		}
		else if(currentSortingMethod.equals("subject_ascending")) {
			sortBySubjectAscending();
		}
	}
	
	public void sortBySubjectAscending() {
		boolean isSorted = true;
		for(int i = 0; i < emails.size()-1; i++) {
			if(emails.get(i).getSubject().compareTo(emails.get(i+1).getSubject()) > 0) {
				isSorted = false;
				Email temp = emails.get(i);
				emails.remove(i);
				emails.add(temp);
			}
		}
		if(isSorted) {
			return;
		}
		sortBySubjectAscending();
	}
	
	public void sortBySubjectDescending() {
		boolean isSorted = true;
		for(int i = 0; i < emails.size()-1; i++) {
			if(emails.get(i).getSubject().compareTo(emails.get(i+1).getSubject()) < 0) {
				isSorted = false;
				Email temp = emails.get(i);
				emails.remove(i);
				emails.add(temp);
			}
		}
		if(isSorted) {
			return;
		}
		sortBySubjectDescending();
	}
	
	public void sortByDateAscending() {
		boolean isSorted = true;
		for(int i = 0; i < emails.size()-1; i++) {
			if(emails.get(i).getTimestamp().compareTo(emails.get(i+1).getTimestamp()) > 0) {
				isSorted = false;
				Email temp = emails.get(i);
				emails.remove(i);
				emails.add(temp);
			}
		}
		if(isSorted) {
			return;
		}
		sortByDateAscending();
	}
	
	public void sortByDateDescending() {
		boolean isSorted = true;
		for(int i = 0; i < emails.size()-1; i++) {
			if(emails.get(i).getTimestamp().compareTo(emails.get(i+1).getTimestamp()) < 0) {
				isSorted = false;
				Email temp = emails.get(i);
				emails.remove(i);
				emails.add(temp);
			}
		}
		if(isSorted) {
			return;
		}
		sortByDateDescending();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCurrentSortingMethod(String current) {
		currentSortingMethod = current;
	}
	
	public String getCurrentSortigMethod() {
		return currentSortingMethod;
	}
	
	public int size() {
		return emails.size();
	}
	
	public void printFolderInfo() {
		System.out.println(String.format("%-7s%-1s%-28s%-1s%-11s", "-Index-", "|", "------------Time------------", "|", "--Subject--"));
		System.out.println("------------------------------------------------");
		
		for(int i = 0; i < emails.size(); i++) {
			System.out.println(String.format("%-7s%-1s%-28s%-1s%-11s", (i+1), "|", 
					emails.get(i).getTimestamp().getTime(), "|", emails.get(i).getSubject()));
		}
		System.out.println();
	}
}
