package org.spring.cloud.WLC.base.provider.service;

import java.util.List;

import com.spring.cloud.wlc.base.domain.know.KnowSource;

import io.searchbox.client.JestResult;

public interface KnowService {
	
	JestResult saveKnowSource(KnowSource content);
	
	boolean saveKnowSource(List<KnowSource> contentList);
	
	List<KnowSource> searchKnowSource(String searchContent);
	
	List<KnowSource> listKnowSources(String searchContent);
	
	JestResult delKnowSource(KnowSource content);
	
	JestResult updateKnowSource(KnowSource content);


}
