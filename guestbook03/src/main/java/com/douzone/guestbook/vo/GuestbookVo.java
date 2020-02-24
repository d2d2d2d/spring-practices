package com.douzone.guestbook.vo;

public class GuestbookVo {
		private Long no;
		private String name;
		private String contents;
		private String regDate;
		private String password;
		
		public String getRegDate() {
			return regDate;
		}
		public void setRegDate(String regDate) {
			this.regDate = regDate;
		}
		@Override
		public String toString() {
			return "GuestbookVo [no=" + no + ", name=" + name + ", contents=" + contents + ", legDate=" + regDate
					+ ", password=" + password + "]";
		}
		public Long getNo() {
			return no;
		}
		public void setNo(Long no) {
			this.no = no;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getContents() {
			return contents;
		}
		public void setContents(String contents) {
			this.contents = contents;
		}
		public String getPassword() {
			
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
}
