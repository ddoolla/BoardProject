package model.dto;

public class BoardDTO {
	
	private String cNum;
	private String uNum;
	private String title;
	private String content;
	private String writeDate;
	private String visitNum;
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getcNum() {	
		return cNum;
	}
	public void setcNum(String cNum) {
		this.cNum = cNum;
	}
	public String getuNum() {
		return uNum;
	}
	public void setuNum(String uNum) {
		this.uNum = uNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getVisitNum() {
		return visitNum;
	}
	public void setVisitNum(String visitNum) {
		this.visitNum = visitNum;
	}
	
}
