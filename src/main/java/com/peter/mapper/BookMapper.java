package com.peter.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.peter.entity.Book;

@Mapper
public interface BookMapper {
	public List<Book> selectAll();
	public Book selectOne(long id);
	public void insertOne(Book book);
	public void deleteOne(Book book);
	public void updateOne(@Param("id") long id, @Param("title") String title,@Param("author") String author, @Param("sn") long sn);
}
