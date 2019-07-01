package org.spring.cloud.WLC.notebook.provider.service.impl;

import java.util.List;

import org.spring.cloud.WLC.notebook.provider.domain.NoteBook;
import org.spring.cloud.WLC.notebook.provider.mapper.NoteBookMapper;
import org.spring.cloud.WLC.notebook.provider.service.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NoteBookServiceImpl implements NoteBookService {

	@Autowired
	NoteBookMapper mapper;
	@Override
	public List<NoteBook> findAllNoteBook() {
		// TODO Auto-generated method stub
		return mapper.findAllNoteBook();
	}
	@Override
	public boolean addNoteBook(NoteBook noteBook) {
		// TODO Auto-generated method stub
		return mapper.addNoteBook(noteBook);
	}
	@Override
	public boolean delNoteBook(NoteBook noteBook) {
		// TODO Auto-generated method stub
		return mapper.delNoteBook(noteBook);
	}
	@Override
	public boolean updateNoteBook(NoteBook noteBook) {
		// TODO Auto-generated method stub
		return mapper.updateNoteBook(noteBook);
	}

}
