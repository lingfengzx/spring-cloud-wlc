package com.spring.cloud.wlc.base.domain.know;

public class KnowContent {
	private String cn_note_title;

	private String cn_note_tags;

	private String cn_note_content;

	private String cn_note_author;

	private String cn_note_creatTime;

	private String cn_note_modifyTime;

	public KnowContent() {
		super();
	}

	public String getCn_note_title() {
		return cn_note_title;
	}

	public void setCn_note_title(String cn_note_title) {
		this.cn_note_title = cn_note_title;
	}

	public String getCn_note_tags() {
		return cn_note_tags;
	}

	public void setCn_note_tags(String cn_note_tags) {
		this.cn_note_tags = cn_note_tags;
	}

	public String getCn_note_content() {
		return cn_note_content;
	}

	public void setCn_note_content(String cn_note_content) {
		this.cn_note_content = cn_note_content;
	}

	public String getCn_note_author() {
		return cn_note_author;
	}

	public void setCn_note_author(String cn_note_author) {
		this.cn_note_author = cn_note_author;
	}

	public String getCn_note_creatTime() {
		return cn_note_creatTime;
	}

	public void setCn_note_creatTime(String cn_note_creatTime) {
		this.cn_note_creatTime = cn_note_creatTime;
	}

	public String getCn_note_modifyTime() {
		return cn_note_modifyTime;
	}

	public void setCn_note_modifyTime(String cn_note_modifyTime) {
		this.cn_note_modifyTime = cn_note_modifyTime;
	}

	@Override
	public String toString() {
		return "KnowContent [cn_note_title=" + cn_note_title + ", cn_note_tags=" + cn_note_tags + ", cn_note_content="
				+ cn_note_content + ", cn_note_author=" + cn_note_author + ", cn_note_creatTime=" + cn_note_creatTime
				+ ", cn_note_modifyTime=" + cn_note_modifyTime + "]";
	}

	public KnowContent(String cn_note_title, String cn_note_tags, String cn_note_content, String cn_note_author,
			String cn_note_creatTime, String cn_note_modifyTime) {
		super();
		this.cn_note_title = cn_note_title;
		this.cn_note_tags = cn_note_tags;
		this.cn_note_content = cn_note_content;
		this.cn_note_author = cn_note_author;
		this.cn_note_creatTime = cn_note_creatTime;
		this.cn_note_modifyTime = cn_note_modifyTime;
	}

	
}
