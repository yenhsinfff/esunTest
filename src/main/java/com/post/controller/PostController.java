package com.post.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiResponse;
import com.post.model.PostDTO_insert;
import com.post.model.PostService;
import com.post.model.PostVO;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService postSvc;

	// 列出所有文章
	// http://localhost:8081/post/getPost
	@GetMapping("/getPost")
	public ResponseEntity<List<PostVO>> getPost() {
		List<PostVO> posts = postSvc.getAll();
		return ResponseEntity.ok(posts);
	}

	// 新增文章
	// http://localhost:8081/post/addPost
	@PostMapping("/addPost")
	public ResponseEntity<?> addPost(@ModelAttribute PostDTO_insert dto) throws IOException{
		
		byte[] imageBytes = dto.getImg() != null ? dto.getImg().getBytes() : null;

		PostVO post = new PostVO();
		post.setUserId(dto.getUserId());
		post.setTitle(dto.getTitle());
		post.setContent(dto.getContent());
		post.setImg(imageBytes);
		
		PostVO saved = postSvc.addPost(post);
		
		ApiResponse<PostVO> successResponse = new ApiResponse<>("success", saved, "儲存成功");
		return ResponseEntity.ok(successResponse);
	}
	


}
