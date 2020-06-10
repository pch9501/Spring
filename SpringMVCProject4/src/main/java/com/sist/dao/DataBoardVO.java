package com.sist.dao;

import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/*
 * 		<input type="text" name="names[0]"/>
 * 		<input type="text" name="names[1]"/>
 * 		<input type="text" name="names[2]"/>
 * 		<input type="text" name="names[3]"/>
 * 		<input type="text" name="names[4]"/>
 * 
 * 		==> List<String> names;
 */

public class DataBoardVO {
	private int no;
	private String name;
	private String subject;
	private String content;
	private String pwd;
	private Date regdate;
	private int hit;
	private String filename;
	private String filesize;
	private int filecount;
	private List<MultipartFile> files;
}
