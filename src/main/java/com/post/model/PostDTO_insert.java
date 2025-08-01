package com.post.model;

import org.springframework.web.multipart.MultipartFile;

public class PostDTO_insert {

	    
	    private Integer userId;
	    private String title;
	    private String content;
	    private MultipartFile img;
	    
	    
		public PostDTO_insert() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
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
		public MultipartFile getImg() {
			return img;
		}
		public void setImg(MultipartFile img) {
			this.img = img;
		}
	   
	
}
