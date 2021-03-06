package com.newsbig.sinmunmul.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newsbig.sinmunmul.dto.KeywordTrendMonth;
import com.newsbig.sinmunmul.dto.KeywordTrendWeek;
import com.newsbig.sinmunmul.exception.NotExistsNewsException;
import com.newsbig.sinmunmul.repository.ScrapRepositorySupport;
import com.newsbig.sinmunmul.response.AdvancedResponseBody;
import com.newsbig.sinmunmul.response.BaseResponseBody;
import com.newsbig.sinmunmul.service.NewsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/news")
@Api("뉴스 API")
public class NewsController {
	
	@Autowired
	NewsService newsService;
	@Autowired
	ScrapRepositorySupport scrapRepositorySupport;
	
	@PostMapping("/{news_seq}/scrap")
	@ApiImplicitParam(name = "news_seq", value = "news_seq")
	@ApiOperation(value = "뉴스 스크랩", notes = "스크랩을 원하는 뉴스를 DB에 저장")
	@ApiResponses(
			{ @ApiResponse(code = 200, message = "스크랩 성공"),
			  @ApiResponse(code = 400, message = "잘못된 요청입니다."),
			  @ApiResponse(code = 500, message = "서버 오류")
			})
	public ResponseEntity<? extends BaseResponseBody> scrap(@PathVariable("news_seq") int newsSeq, @RequestParam("user_Seq") int userSeq) {
		
		if(scrapRepositorySupport.checkScrap(userSeq, newsSeq))
			return ResponseEntity.status(409).body(BaseResponseBody.of(409, "이미 존재하는 뉴스 스크랩 입니다."));
		
		newsService.scrap(newsSeq, userSeq);
		
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "스크랩 성공"));
	}
	
	@GetMapping("/today")
	@ApiOperation(value = "오늘의 뉴스 현황 조회", notes = "전체, 정치, 경제, 사회, 생활/문화, 세계, 과학 별 기사 개수와 전체 대비 퍼센트를 반환한다.")
	@ApiResponses(
			{ @ApiResponse(code = 200, message = "오늘의 뉴스 현황 조회 성공"),
			  @ApiResponse(code = 400, message = "잘못된 요청입니다."),
			  @ApiResponse(code = 500, message = "서버 오류")
			})
	public ResponseEntity<? extends BaseResponseBody> todayNews() {
		return ResponseEntity.status(200).body(AdvancedResponseBody.of(200, "오늘의 뉴스 현황 조회 성공", newsService.todayNews()));
	}
	
	@GetMapping("/keyword")
	@ApiOperation(value = "키워드로 뉴스 검색", notes = "워드 클라우드 키워드, 검색 키워드가 포함된 뉴스 기사를 반환한다.")
	@ApiResponses(
			{ @ApiResponse(code = 200, message = "뉴스 검색 성공"),
			  @ApiResponse(code = 400, message = "잘못된 요청입니다."),
			  @ApiResponse(code = 500, message = "서버 오류")
			})
	public ResponseEntity<? extends BaseResponseBody> searchNews(String keyword, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "3") int size) {
		return ResponseEntity.status(200).body(AdvancedResponseBody.of(200, "뉴스 검색 성공", newsService.searchNews(keyword, page, size)));
	}
	
	@GetMapping("/detail")
	@ApiOperation(value = "뉴스 상세정보 조회", notes = "뉴스 상세정보를 조회한다.")
	@ApiResponses(
			{ @ApiResponse(code = 200, message = "뉴스 검색 성공"),
			  @ApiResponse(code = 400, message = "잘못된 요청입니다."),
			  @ApiResponse(code = 500, message = "서버 오류"),
			  @ApiResponse(code = 202, message = "뉴스 시퀀스 오류"),
			})
	public ResponseEntity<? extends BaseResponseBody> detailNews(@RequestParam long newsSeq) {
		Map<String, Object> result = new HashMap<>();
		
		try {
			result = newsService.newsDetail(newsSeq);
			return ResponseEntity.status(200).body(AdvancedResponseBody.of(200, "뉴스 검색 성공", result));
		}
		catch(NotExistsNewsException e) {
			return ResponseEntity.status(202).body(BaseResponseBody.of(202, "존재하지 않는 뉴스 번호입니다."));
		}
	}
	
	@GetMapping("/keyword/trend/week")
	@ApiOperation(value = "주간 키워드 언급 기사량 조회", notes = "주간 키워드 언급 기사량을 조회한다.")
	@ApiResponses(
			{ @ApiResponse(code = 200, message = "주간 키워드 언급 기사량 조회 성공"),
			  @ApiResponse(code = 400, message = "잘못된 요청입니다."),
			  @ApiResponse(code = 500, message = "서버 오류"),
			})
	public ResponseEntity<? extends BaseResponseBody> keywordTrendWeek(@RequestParam (required = true) String[] keywords) {
		List<Map<String, Object>> trendList = new ArrayList<>();
		
		for (String keyword : keywords) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<KeywordTrendWeek> list = newsService.keywordTrendWeek(keyword);
			map.put("keyword", keyword);
			map.put("stat", list);
			trendList.add(map);
		}
		return ResponseEntity.status(200).body(AdvancedResponseBody.of(200, "주간 키워드 언급 기사량 조회 성공", trendList));
	}
	
	@GetMapping("/keyword/trend/month")
	@ApiOperation(value = "월간 키워드 언급 기사량 조회", notes = "월간 키워드 언급 기사량을 조회한다.")
	@ApiResponses(
			{ @ApiResponse(code = 200, message = "월간 키워드 언급 기사량 조회 성공"),
			  @ApiResponse(code = 400, message = "잘못된 요청입니다."),
			  @ApiResponse(code = 500, message = "서버 오류"),
			})
	public ResponseEntity<? extends BaseResponseBody> keywordTrendMonth(@RequestParam (required = true) String[] keywords) {
		List<Map<String, Object>> trendList = new ArrayList<>();
		
		for (String keyword : keywords) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<KeywordTrendMonth> list = newsService.keywordTrendMonth(keyword);
			map.put("keyword", keyword);
			map.put("stat", list);
			trendList.add(map);
		}
		return ResponseEntity.status(200).body(AdvancedResponseBody.of(200, "월간 키워드 언급 기사량 조회 성공", trendList));
	}
	
	@GetMapping("/main/wordcloud")
	@ApiOperation(value = "메인 페이지 워드클라우드 ", notes = "codeGroup - 0 : 전체, 100 : 정치, 101 : 경제, 102 : 사회, 103 : 생활/문화, 104 : 세계, 105 : IT/과학")
	@ApiResponses(
			{ @ApiResponse(code = 200, message = "메인 페이지 워드클라우드 조회 성공"),
			  @ApiResponse(code = 400, message = "잘못된 요청입니다."),
			  @ApiResponse(code = 500, message = "서버 오류"),
			})
	public ResponseEntity<? extends BaseResponseBody> mainWordcloud(@RequestParam (required = true) int codeGroup) {
		JSONArray wordcloud = null;
		try {
			wordcloud = newsService.mainWordcloud(codeGroup);
		} catch (ParseException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(BaseResponseBody.of(500, "서버 오류입니다."));
		}
		 
		return ResponseEntity.status(200).body(AdvancedResponseBody.of(200, "메인 페이지 워드클라우드 조회 성공", wordcloud));
	}
	
}