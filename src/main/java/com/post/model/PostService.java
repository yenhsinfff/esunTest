package com.post.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("postService")
public class PostService {

	@Autowired
	PostRepository postRepo;

	// 列出所有發文
	public List<PostVO> getAll() {
		return postRepo.findAll();
	}

	// 新增文章
	public PostVO addPost(PostVO postVO) {
		System.out.println("OKK");
		return postRepo.save(postVO);
	}

	// 修改文章
	public PostVO updatePost(PostVO postVO) {
		return postRepo.save(postVO);
	}
	
	// 刪除文章
		public void deletePost(Integer postId) {
			if(postRepo.existsById(postId))
			postRepo.deleteById(postId);
		}

}
