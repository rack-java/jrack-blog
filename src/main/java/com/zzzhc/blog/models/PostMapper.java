package com.zzzhc.blog.models;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface PostMapper {

	@Select("SELECT * FROM post")
	List<Post> getPosts();

	@Select("select * from post where id=#{id}")
	Post getPost(int id);
}
