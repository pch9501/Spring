package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieVO {
	private int mno;
	private String title;
	private String poster;
	private String genre;
	private String grade;
	private String director;
	private String actor;
	private String story;
	// 타이틀, 포스터, 장르, 그레이드, 디렉터, 액터, 스토리
}
