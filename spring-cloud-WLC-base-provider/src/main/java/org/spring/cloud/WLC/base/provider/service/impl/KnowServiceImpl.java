package org.spring.cloud.WLC.base.provider.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.search.suggest.SortBy;
import org.spring.cloud.WLC.base.provider.dao.ElasticSearchDao;
import org.spring.cloud.WLC.base.provider.domain.KnowContent;
import org.spring.cloud.WLC.base.provider.domain.KnowSource;
import org.spring.cloud.WLC.base.provider.service.KnowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import io.searchbox.client.JestResult;
import io.searchbox.core.SearchResult.Hit;
import io.searchbox.core.search.sort.Sort;
import io.searchbox.core.search.sort.Sort.Sorting;

/**
 * 
 * @author zxk
 *
 */
@Service
public class KnowServiceImpl implements KnowService {

	@Autowired
	private ElasticSearchDao esDao;
	
	@Override
	public JestResult saveKnowSource(KnowSource source) {
		try {
			return esDao.createIndex(source.getContent(), source.INDEX_NAME, source.getType(),source.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 批量保存内容到ES
	 * @return 
	 */
	@Override
	public boolean saveKnowSource(List<KnowSource> knowSourceList) {
		String indexname="";
		String type="";
		List<KnowContent> list=new ArrayList<>();
		if(knowSourceList!=null&&knowSourceList.size()>0) {
			KnowSource knowSource=knowSourceList.get(0);
			indexname=knowSource.INDEX_NAME;
			type=knowSource.getType();
			for (KnowSource source : knowSourceList) {
				list.add(source.getContent());
			}
		}else {
			return false;
		}
		try {
			esDao.bulkIndex(indexname, type, list);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 在ES中搜索内容
	 */
	@Override
	public List<KnowSource> searchKnowSource(String searchContent){
		List<KnowSource> list=new ArrayList<>();
		try {
			List<Hit<KnowContent, Void>> result = esDao.createSearch(searchContent, KnowSource.INDEX_NAME, new KnowContent(),"title","tags","content");
			for (Hit<KnowContent, Void> hit : result) {
				KnowSource source=new KnowSource(hit.type,hit.id, hit.source);
				list.add(source);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}


	@Override
	public List<KnowSource> listKnowSources(String type) {
		List<KnowSource> list=new ArrayList<>();
		Sort sort = new Sort("note_modifyTime", Sorting.DESC);
		try {
			List<Hit<KnowContent, Void>> result = esDao.searchAll(KnowSource.INDEX_NAME, type,sort,new KnowContent());
			for (Hit<KnowContent, Void> hit : result) {
				KnowSource source=new KnowSource(hit.type,hit.id, hit.source);
				list.add(source);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}


	@Override
	public JestResult delKnowSource(KnowSource content) {
		// TODO Auto-generated method stub
		return esDao.deleteDocument(KnowSource.INDEX_NAME, content.getType(), content.getId());
	}


	@Override
	public JestResult updateKnowSource(KnowSource content) {
		// TODO Auto-generated method stub
		return esDao.updateDocument(JSON.toJSONString(content.getContent()),KnowSource.INDEX_NAME, content.getType(), content.getId());
	}

}
