package cn.easybuy.mapper;

import java.util.List;
import java.util.Map;

import cn.easybuy.entity.News;

/**
 * @author chsm
 * @date  2018年4月16日上午8:57:37
 * @version 1.0
 */
public interface NewsMapper {
	
	/**
	 * 添加公告
	 * @param news
	 * @return
	 */
	int add(News news);
	
	/**
	 * 更新公告
	 * @param news
	 * @return
	 */
	int update(News news);
	
	/**
	 * 通过id删除公告
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);
	
	/**
	 * 通过id获取公告
	 * @param id
	 * @return
	 */
	News getNewsById(Integer id);
	
	/**
	 * 按条件查询公告并分页
	 * @param map
	 * @return
	 */
	List<News> queryNewsList(Map<String, Object> map);
	
	/**
	 * 按条件查询公告数量
	 * @param map
	 * @return
	 */
	int queryNewsCount(Map<String, Object> map);
	
}
