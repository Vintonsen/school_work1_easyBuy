package cn.easybuy.service.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.easybuy.entity.News;
import cn.easybuy.mapper.NewsMapper;
import cn.easybuy.param.NewsParams;
import cn.easybuy.service.MyBaseService;

/**
 * @author chsm
 * @date  2018年4月16日上午10:59:10
 * @version 1.0
 */
public class MyNewsServiceImpl extends MyBaseService<NewsMapper> implements NewsService{

	
	@Override
	public void addNews(News news) {
		before();
		try {
			t.add(news);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
	}

	
	@Override
	public News findNewsById(String parameter) {
		News news = null;
		before();
		try {
			news = t.getNewsById(Integer.parseInt(parameter));
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return news;
	}

	
	@Override
	public void deleteNews(String parameter) {
		before();
		try {
			t.deleteById(Integer.parseInt(parameter));
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
	}

	
	@Override
	public List<News> queryNewsList(NewsParams param) {
		List<News> newsList = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", param.getTitle());
		map.put("sort", param.getSort());
		map.put("isPage", param.isPage());
		map.put("init", param.getStartIndex());
		map.put("pageSize", param.getPageSize());
		before();
		try {
			newsList = t.queryNewsList(map);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return newsList;
	}

	@Override
	public Integer queryNewsCount(NewsParams param) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", param.getTitle());
		int count = 0;
		before();
		try {
			count = t.queryNewsCount(map);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return count;
	}

}
