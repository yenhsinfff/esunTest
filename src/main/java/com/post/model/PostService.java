package com.post.model;

import java.io.IOException;
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

	// 列出單一發文
	public PostVO getByPostId(Integer postId) {
	    return postRepo.findById(postId)
	            .orElseThrow(() -> new RuntimeException("找不到該貼文"));
	}

	// 新增文章
	public PostVO addPost(PostDTO_insert dto) throws IOException {

		byte[] imageBytes = dto.getImg() != null ? dto.getImg().getBytes() : null;

		PostVO post = new PostVO();
		post.setUserId(dto.getUserId());
		post.setTitle(dto.getTitle());
		post.setContent(dto.getContent());
		post.setImg(imageBytes);
		return postRepo.save(post);
	}

	// 修改文章
	public PostVO updatePost(PostDTO_update dto) throws IOException {
		byte[] imageBytes = dto.getImg() != null ? dto.getImg().getBytes() : null;
		System.out.println("OKK");
		PostVO post = postRepo.findById(dto.getPostId()).orElseThrow(() -> new RuntimeException("找不到發文"));
		post.setUserId(dto.getUserId());
		post.setTitle(dto.getTitle());
		post.setContent(dto.getContent());
		post.setImg(imageBytes);

		return postRepo.save(post);
	}

	// 刪除文章
	public void deletePost(Integer postId) {

		if (postRepo.existsById(postId))
			postRepo.deleteById(postId);
	}

}
