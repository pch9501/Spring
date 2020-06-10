package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;

@RestController
public class MusicController {
	@Autowired
	private MusicDAO dao;
	
	@RequestMapping("main/music.do")
	public String main_list()
	{
		String result="";
		
		List<MusicVO> list=dao.musicListData();
		// jsonarray는 [{},{},{}..]의 배열형태를 만들어준다, {}<< 이런 단일객체는 jsonobject
		JSONArray arr=new JSONArray();
		// 오라클에서 가져온 list의 vo를 jsonobject의 형태에 넣은 후, jsonarray에 추가한다.
		for(MusicVO vo:list)
		{
			JSONObject obj=new JSONObject();
			
			obj.put("mno",vo.getMno());
			obj.put("title", vo.getTitle());
			obj.put("singer", vo.getSinger());
			obj.put("album", vo.getAlbum());
			obj.put("state", vo.getState());
			obj.put("idcrement", vo.getIdcrement());
			obj.put("poster", vo.getPoster());
			
			arr.add(obj);
		}
		// 추가한 jsonarray를 String에 담은 후
		result=arr.toJSONString();
		System.out.println(result);
		// return한다
		return result;
	}
	@RequestMapping("main/detail_data.do")
	public String detail_data(int mno)
	{
		MusicVO vo=dao.musicDetailData(mno);
		JSONObject obj=new JSONObject();
		obj.put("mno", vo.getMno());
		obj.put("title", vo.getTitle());
		obj.put("singer", vo.getSinger());
		obj.put("album", vo.getAlbum());
		obj.put("state", vo.getState());
		obj.put("idcrement", vo.getIdcrement());
		obj.put("poster", vo.getPoster());
		obj.put("key", vo.getKey());
		
		return obj.toJSONString();
	}
}
