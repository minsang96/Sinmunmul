package com.newsbig.sinmunmul.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newsbig.sinmunmul.dto.TodayNewsDto;
import com.newsbig.sinmunmul.entity.QCommonCodeGroup;
import com.newsbig.sinmunmul.entity.QNews;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class NewsRepositorySupport {

	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	 
	QNews qNews = QNews.news;
	QCommonCodeGroup qCommonCodeGroup = QCommonCodeGroup.commonCodeGroup;

	public List<TodayNewsDto> todayNews(String start, String end) {
		List<Tuple> todayNews = jpaQueryFactory
				.select(qCommonCodeGroup.cgValue, qNews.count())
				.from(qNews)
				
				.where(qNews.delYn.eq("n"), qNews.newsRegDt.between(start, end)).groupBy(qNews.commonCodeGroup).fetch();
		
		List<TodayNewsDto> result = new ArrayList<>();
		for (int i = 0; i < todayNews.size(); i++) {
			result.add(new TodayNewsDto(todayNews.get(i).get(qCommonCodeGroup.cgValue).toString(), Integer.parseInt(todayNews.get(i).get(qNews.count()).toString())));
		}
		
		return result;
	}
}