// Dylan Sands
// 112396943
// R30

import java.util.GregorianCalendar;

public class Email implements java.io.Serializable{
	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String body;
	private GregorianCalendar timestamp;
	
	public Email(String to, String cc, String bcc, String subject, String body, GregorianCalendar timestamp) {
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
		this.body = body;
		this.timestamp = timestamp;
	}
	
	public void setTo(String to) {
		this.to = to;
	}
	
	public String getTo() {
		return to;
	}
	
	public void setCC(String cc) {
		this.cc = cc;
	}
	
	public String getCC() {
		return cc;
	}
	
	public void setBCC(String bcc) {
		this.bcc = bcc;
	}
	
	public String getBCC() {
		return bcc;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setTimestamp(GregorianCalendar timestamp) {
		this.timestamp = timestamp;
	}
	
	public GregorianCalendar getTimestamp() {
		return timestamp;
	}
}
