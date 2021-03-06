package org.spring.cloud.WLC.notebook.provider.service;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import com.spring.cloud.wlc.base.domain.notebook.NoteBook;

public interface NoteBookService {
	/**
     * 根据接口查询所用的用户
     */
    public List<NoteBook> findAllNoteBook();
    
    /**
     * 添加笔记本
     * @param noteBook
     * @return
     */
    public boolean addNoteBook(NoteBook noteBook);
    
    /**
     * 删除笔记本
     * @param noteBook
     * @return
     */
    public boolean delNoteBook(NoteBook noteBook);
    
    /**
     * 重命名笔记本
     * @param noteBook
     * @return
     */
    public boolean updateNoteBook(NoteBook noteBook);
    	
}
