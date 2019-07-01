package org.spring.cloud.WLC.notebook.provider.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.cloud.wlc.base.domain.notebook.NoteBook;


@Mapper
public interface NoteBookMapper {
    
	public List<NoteBook> findAllNoteBook();
	public boolean addNoteBook(NoteBook noteBook);
	public boolean delNoteBook(NoteBook noteBook);
	public boolean updateNoteBook(NoteBook noteBook);

}