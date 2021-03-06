package easymapping.mapping;

import java.util.Date;

import easymapping.annotation.DateFormat;

public class Schedule {

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", date=" + date + ", userId=" + userId + ", type=" + type + ", time=" + time + ", term=" + term + ", head="
				+ head + ", body=" + body + "]";
	}

	private int id;
	@DateFormat("yyyy-mm-dd")
	private Date date;
	private String userId;
	private String type;
	private int time;
	private int term;
	private String head;
	private String body;

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}
}
