package org.spring.cloud.WLC.notebook.provider.controller;

import java.util.List;

import org.spring.cloud.WLC.notebook.provider.service.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.wlc.base.domain.notebook.NoteBook;

@RestController
@RequestMapping("/notebook")
public class NoteBookController {

	@Autowired
	NoteBookService service;
	
    @GetMapping(value = "/findAllNoteBook")
    public List<NoteBook> findAllNoteBook(){
        return service.findAllNoteBook();
    }
    
    @PostMapping(value = "/addNoteBook")
    public boolean addNoteBook(@RequestBody NoteBook noteBook){
        return service.addNoteBook(noteBook);
    }
    
    @PostMapping(value = "/delNoteBook")
    public boolean delNoteBook(@RequestBody NoteBook noteBook){
    	
        return service.delNoteBook(noteBook);
    }
    
    @PostMapping(value = "/updateNoteBook")
    public boolean updateNoteBook(@RequestBody NoteBook noteBook){
    	
        return service.updateNoteBook(noteBook);
    }
}
