// Dylan Sands
// 112396943
// R30

import java.util.ArrayList;
import java.util.Scanner;
import java.util.GregorianCalendar;

public class Mailbox {

	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String body;
	
	private Folder inbox = new Folder("inbox");
	private Folder trash = new Folder("trash");
	private ArrayList<Folder> folders = new ArrayList<Folder>();
	public static Mailbox mailbox;
	Scanner stdin = new Scanner(System.in);
	
	public static void main(String[] args) throws NotFoundException{
		mailbox = new Mailbox();
		mailbox.addFolder(mailbox.inbox);
		mailbox.addFolder(mailbox.trash);
		
		String menuAnswer;
		String menuAnswer2;
		String folderName;
		String folderName2;
		Scanner stdin = new Scanner(System.in);
		
		System.out.println("A - Add Folder");
		System.out.println("R - Remove Folder");
		System.out.println("C - Compose email");
		System.out.println("F - Open folder");
		System.out.println("I - Open Inbox");
		System.out.println("T - Open Trash");
		System.out.println("E - Empty Trash");
		System.out.println("Q - Quit");
		System.out.println("Enter a user option:");
		
		menuAnswer = stdin.nextLine().toUpperCase();
		
		while(menuAnswer.equals("Q") == false) {
			if(menuAnswer.equals("A")) {
				System.out.println("Enter folder name: ");
				mailbox.addFolder(new Folder(stdin.nextLine()));
				mailbox.displayFolders();
			}
			else if(menuAnswer.equals("R")) {
				System.out.println("Enter the name of the folder you would like to remove: ");
				mailbox.deleteFolder(stdin.nextLine());
				mailbox.displayFolders();
			}
			else if(menuAnswer.equals("C")) {
				mailbox.composeEmail();
				mailbox.displayFolders();
			}
			else if(menuAnswer.equals("F")) {
				System.out.println("Enter folder name: ");
				folderName = stdin.nextLine();
				mailbox.getFolder(folderName).printFolderInfo();
				
				System.out.println("M - Move email");
				System.out.println("D - Delete email");
				System.out.println("V - View email contents");
				System.out.println("SA - Sort by subject ascending");
				System.out.println("SD - Sort by subject descending");
				System.out.println("DA - Sort by date ascending");
				System.out.println("DD - Sort by date descending");
				System.out.println("R - Return to main menu");
				System.out.println("Enter a user option:");
				
				menuAnswer2 = stdin.nextLine().toUpperCase();
				
				while(menuAnswer2.equals("R") == false) {
					if(menuAnswer2.equals("M")) {
						System.out.println("Select the index of the email you want to move: ");
						int index = stdin.nextInt() - 1;
						mailbox.displayFolders();
						System.out.println("Select a folder to move \"" + 
						mailbox.getFolder(folderName).getEmail(index).getSubject() + "\" to: ");
						folderName2 = stdin.nextLine();
						mailbox.getFolder(folderName2).addEmail(mailbox.getFolder(folderName).removeEmail(index));
						System.out.println("Email moved successfully");
					}
					else if(menuAnswer2.equals("D")) {
						System.out.println("Select the index of the email you want to move: ");
						int index = stdin.nextInt() - 1;
						mailbox.deleteEmail(mailbox.getFolder("trash").removeEmail(index));
						
					}
					else if(menuAnswer2.equals("V")) {
						System.out.println("Enter email index: ");
						int index = stdin.nextInt() - 1;
						System.out.println("To: " + mailbox.getFolder(folderName).getEmail(index).getTo() + 
								", " + mailbox.getFolder(folderName).getEmail(index).getCC());
						System.out.println("CC: " + mailbox.getFolder(folderName).getEmail(index).getCC());
						System.out.println("BCC: " + mailbox.getFolder(folderName).getEmail(index).getBCC());
						System.out.println("Subject: " + mailbox.getFolder(folderName).getEmail(index).getSubject());
						System.out.println(mailbox.getFolder(folderName).getEmail(index).getBody());
					}
					else if(menuAnswer2.equals("SA")) {
						mailbox.getFolder(folderName).sortBySubjectAscending();
						mailbox.getFolder(folderName).printFolderInfo();
					}
					else if(menuAnswer2.equals("SD")) {
						mailbox.getFolder(folderName).sortBySubjectDescending();
						mailbox.getFolder(folderName).printFolderInfo();
					}
					else if(menuAnswer2.equals("DA")) {
						mailbox.getFolder(folderName).sortByDateAscending();
						mailbox.getFolder(folderName).printFolderInfo();
					}
					else if(menuAnswer2.equals("DD")) {
						mailbox.getFolder(folderName).sortByDateDescending();
						mailbox.getFolder(folderName).printFolderInfo();
					}
					else if(menuAnswer2.equals("")) {
					}
					else {
						System.out.println("Please select a valid menu option!");
					}
					
					stdin.nextLine();
					
					System.out.println("M - Move email");
					System.out.println("D - Delete email");
					System.out.println("V - View email contents");
					System.out.println("SA - Sort by subject ascending");
					System.out.println("SD - Sort by subject descending");
					System.out.println("DA - Sort by date ascending");
					System.out.println("DD - Sort by date descending");
					System.out.println("R - Return to main menu");
					System.out.println("Enter a user option:");
					
					menuAnswer2 = stdin.nextLine().toUpperCase();
				}
				
				break;
			}
			else if(menuAnswer.equals("I")) {
				mailbox.getFolder("inbox").printFolderInfo();
				
				System.out.println("M - Move email");
				System.out.println("D - Delete email");
				System.out.println("V - View email contents");
				System.out.println("SA - Sort by subject ascending");
				System.out.println("SD - Sort by subject descending");
				System.out.println("DA - Sort by date ascending");
				System.out.println("DD - Sort by date descending");
				System.out.println("R - Return to main menu");
				System.out.println("Enter a user option:");
				
				menuAnswer2 = stdin.nextLine().toUpperCase();
				
				while(menuAnswer2.equals("R") == false) {
					if(menuAnswer2.equals("M")) {
						System.out.println("Select the index of the email you want to move: ");
						int index = stdin.nextInt() - 1;
						mailbox.displayFolders();
						System.out.println("Select a folder to move \"" + 
						mailbox.getFolder("inbox").getEmail(index).getSubject() + "\" to: ");
						folderName2 = stdin.nextLine();
						mailbox.getFolder(folderName2).addEmail(mailbox.getFolder("inbox").removeEmail(index));
						System.out.println("Email moved successfully");
					}
					else if(menuAnswer2.equals("D")) {
						System.out.println("Select the index of the email you want to move: ");
						int index = stdin.nextInt() - 1;
						System.out.println("\"" + mailbox.getFolder("inbox").getEmail(index).getSubject() +
								"\"" + "successfully moved to trash");
						mailbox.getFolder("trash").addEmail(mailbox.getFolder("inbox").removeEmail(index));
						
					}
					else if(menuAnswer2.equals("V")) {
						System.out.println("Enter email index: ");
						int index = stdin.nextInt() - 1;
						System.out.println("To: " + mailbox.getFolder("inbox").getEmail(index).getTo() + 
								", " + mailbox.getFolder("inbox").getEmail(index).getCC());
						System.out.println("CC: " + mailbox.getFolder("inbox").getEmail(index).getCC());
						System.out.println("BCC: " + mailbox.getFolder("inbox").getEmail(index).getBCC());
						System.out.println("Subject: " + mailbox.getFolder("inbox").getEmail(index).getSubject());
						System.out.println(mailbox.getFolder("inbox").getEmail(index).getBody());
					}
					else if(menuAnswer2.equals("SA")) {
						mailbox.getFolder("inbox").sortBySubjectAscending();
						mailbox.getFolder("inbox").printFolderInfo();
					}
					else if(menuAnswer2.equals("SD")) {
						mailbox.getFolder("inbox").sortBySubjectDescending();
						mailbox.getFolder("inbox").printFolderInfo();
					}
					else if(menuAnswer2.equals("DA")) {
						mailbox.getFolder("inbox").sortByDateAscending();
						mailbox.getFolder("inbox").printFolderInfo();
					}
					else if(menuAnswer2.equals("DD")) {
						mailbox.getFolder("inbox").sortByDateDescending();
						mailbox.getFolder("inbox").printFolderInfo();
					}
					else if(menuAnswer2.equals("")) {
					}
					else {
						System.out.println("Please select a valid menu option!");
					}
					
					stdin.nextLine();
					
					System.out.println("M - Move email");
					System.out.println("D - Delete email");
					System.out.println("V - View email contents");
					System.out.println("SA - Sort by subject ascending");
					System.out.println("SD - Sort by subject descending");
					System.out.println("DA - Sort by date ascending");
					System.out.println("DD - Sort by date descending");
					System.out.println("R - Return to main menu");
					System.out.println("Enter a user option:");
					
					menuAnswer2 = stdin.nextLine().toUpperCase();
				}
				
				break;
			}
			else if(menuAnswer.equals("T")) {
				mailbox.getFolder("trash").printFolderInfo();
				
				System.out.println("M - Move email");
				System.out.println("D - Delete email");
				System.out.println("V - View email contents");
				System.out.println("SA - Sort by subject ascending");
				System.out.println("SD - Sort by subject descending");
				System.out.println("DA - Sort by date ascending");
				System.out.println("DD - Sort by date descending");
				System.out.println("R - Return to main menu");
				System.out.println("Enter a user option:");
				
				menuAnswer2 = stdin.nextLine().toUpperCase();
				
				while(menuAnswer2.equals("R") == false) {
					if(menuAnswer2.equals("M")) {
						System.out.println("Select the index of the email you want to move: ");
						int index = stdin.nextInt() - 1;
						mailbox.displayFolders();
						System.out.println("Select a folder to move \"" + 
						mailbox.getFolder("trash").getEmail(index).getSubject() + "\" to: ");
						folderName2 = stdin.nextLine();
						mailbox.getFolder(folderName2).addEmail(mailbox.getFolder("trash").removeEmail(index));
						System.out.println("Email moved successfully");
					}
					else if(menuAnswer2.equals("D")) {
						System.out.println("Select the index of the email you want to move: ");
						int index = stdin.nextInt() - 1;
						System.out.println("\"" + mailbox.getFolder("trash").getEmail(index).getSubject() +
								"\"" + "has been permanently deleted");
						mailbox.getFolder("trash").removeEmail(index);
						
					}
					else if(menuAnswer2.equals("V")) {
						System.out.println("Enter email index: ");
						int index = stdin.nextInt() - 1;
						System.out.println("To: " + mailbox.getFolder("trash").getEmail(index).getTo() + 
								", " + mailbox.getFolder("trash").getEmail(index).getCC());
						System.out.println("CC: " + mailbox.getFolder("trash").getEmail(index).getCC());
						System.out.println("BCC: " + mailbox.getFolder("trash").getEmail(index).getBCC());
						System.out.println("Subject: " + mailbox.getFolder("trash").getEmail(index).getSubject());
						System.out.println(mailbox.getFolder("trash").getEmail(index).getBody());
					}
					else if(menuAnswer2.equals("SA")) {
						mailbox.getFolder("trash").sortBySubjectAscending();
						mailbox.getFolder("trash").printFolderInfo();
					}
					else if(menuAnswer2.equals("SD")) {
						mailbox.getFolder("trash").sortBySubjectDescending();
						mailbox.getFolder("trash").printFolderInfo();
					}
					else if(menuAnswer2.equals("DA")) {
						mailbox.getFolder("trash").sortByDateAscending();
						mailbox.getFolder("trash").printFolderInfo();
					}
					else if(menuAnswer2.equals("DD")) {
						mailbox.getFolder("trash").sortByDateDescending();
						mailbox.getFolder("trash").printFolderInfo();
					}
					else if(menuAnswer2.equals("")) {
					}
					else {
						System.out.println("Please select a valid menu option!");
					}
					
					stdin.nextLine();
					
					System.out.println("M - Move email");
					System.out.println("D - Delete email");
					System.out.println("V - View email contents");
					System.out.println("SA - Sort by subject ascending");
					System.out.println("SD - Sort by subject descending");
					System.out.println("DA - Sort by date ascending");
					System.out.println("DD - Sort by date descending");
					System.out.println("R - Return to main menu");
					System.out.println("Enter a user option:");
					
					menuAnswer2 = stdin.nextLine().toUpperCase();
				}
				
				break;
			}
			else if(menuAnswer.equals("E")) {
				mailbox.clearTrash();
				System.out.println("Trash folder emptied successfully");
			}
			else if(menuAnswer.equals("")) {
			}
			else {
				System.out.println("Please select a valid menu option!");
			}
			
			stdin.nextLine();
			
			System.out.println("A - Add Folder");
			System.out.println("R - Remove Folder");
			System.out.println("C - Compose email");
			System.out.println("F - Open folder");
			System.out.println("I - Open Inbox");
			System.out.println("T - Open Trash");
			System.out.println("E - Empty Trash");
			System.out.println("Q - Quit");
			System.out.println("Enter a user option:");
			
			menuAnswer = stdin.nextLine().toUpperCase();
		}
		
		stdin.close();
		System.out.println("Goodbye!");
		System.exit(0);
	}
	
	public void addFolder(Folder folder) {
		for(int i = 0; i < folders.size(); i++) {
			if(folders.get(i).getName().equals(folder.getName())) {
				System.out.println("Existing folder is already using that name!");
				return;
			}
		}
		folders.add(folder);
	}
	
	public void deleteFolder(String name) {
		if(name.equals("inbox") || name.equals("trash")) {
			System.out.println("That folder cannot be removed!");
		}
		else {
			for(int i = 0; i < folders.size(); i++) {
				if(folders.get(i).getName().equals(name)) {
					folders.remove(i);
					System.out.println("\"" + name +"\"" + "folder successfully removed");
					break;
				}
			}
		}
	}
	
	public void composeEmail() {
		System.out.println("Enter recipient (To): ");
		to = stdin.nextLine();
		System.out.println("Enter carbon copy recipients (CC): ");
		cc = stdin.nextLine();
		System.out.println("Enter blind carbon copy recipients (BCC): ");
		bcc = stdin.nextLine();
		System.out.println("Enter subject line: ");
		subject = stdin.nextLine();
		System.out.println("Enter body: ");
		body = stdin.nextLine();
		inbox.addEmail(new Email(to, cc, bcc, subject, body, new GregorianCalendar()));
		System.out.println("Email successfully added to Inbox.");
	}
	
	public void deleteEmail(Email email) {
		trash.addEmail(email);
		System.out.println("\"" + email.getSubject() + "\"" + "has been successfully moved to the trash.");
	}
	
	public void clearTrash() throws NotFoundException{
		for(int i = 0; i < trash.size(); i++) {
			trash.removeEmail(0);
		}
	}
	
	public void moveEmail(Email email, Folder target) {
		target.addEmail(email);
	}
	
	public Folder getFolder(String name) throws NotFoundException{
		int i = 0;
		boolean folderExists = false;
		
		while(i < folders.size()) {
			if(folders.get(i).getName().equals(name)) {
				folderExists = true;
				break;
			}
			i++;
		}
		if(folderExists) {
			return folders.get(i);
		}
		else {
			throw new NotFoundException("There is no folder with that name!");
		}
	}
	
	public void displayFolders() {
		System.out.println("Mailbox:");
		System.out.println("------------");
		for(int i = 0; i < folders.size(); i++) {
			System.out.println(folders.get(i).getName());
		}
	}

}
