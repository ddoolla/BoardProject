package model.dto;

public class MemberDTO {

		private String nNum;
		private String userId;
		private String userPass;
		private String name;
		private String phone;
		private String email;
		
		public String getnNum() {
			return nNum;
		}
		public void setnNum(String nNum) {
			this.nNum = nNum;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserPass() {
			return userPass;
		}
		public void setUserPass(String userPass) {
			this.userPass = userPass;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
}
