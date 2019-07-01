package org.spring.cloud.WLC.base.consumer.domian;

public class KnowContent {
	private String note_id;
	private String notebook_id;
	private String user_id;
	private String note_status;
	private String note_type;
	private String note_title;

	private String note_tags;

	private String note_content;

	private String note_author;

	private String note_creatTime;

	private String note_modifyTime;

	public KnowContent() {
		super();
	}

	public String getNote_id() {
		return note_id;
	}

	public void setNote_id(String note_id) {
		this.note_id = note_id;
	}

	public String getNotebook_id() {
		return notebook_id;
	}

	public void setNotebook_id(String notebook_id) {
		this.notebook_id = notebook_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getNote_status() {
		return note_status;
	}

	public void setNote_status(String note_status) {
		this.note_status = note_status;
	}

	public String getNote_type() {
		return note_type;
	}

	public void setNote_type(String note_type) {
		this.note_type = note_type;
	}

	public String getNote_title() {
		return note_title;
	}

	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}

	public String getNote_tags() {
		return note_tags;
	}

	public void setNote_tags(String note_tags) {
		this.note_tags = note_tags;
	}

	public String getNote_content() {
		return note_content;
	}

	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}

	public String getNote_author() {
		return note_author;
	}

	public void setNote_author(String note_author) {
		this.note_author = note_author;
	}

	public String getNote_creatTime() {
		return note_creatTime;
	}

	public void setNote_creatTime(String note_creatTime) {
		this.note_creatTime = note_creatTime;
	}

	public String getNote_modifyTime() {
		return note_modifyTime;
	}

	public void setNote_modifyTime(String note_modifyTime) {
		this.note_modifyTime = note_modifyTime;
	}

	public KnowContent(String note_id, String notebook_id, String user_id, String note_status, String note_type,
			String note_title, String note_tags, String note_content, String note_author, String note_creatTime,
			String note_modifyTime) {
		super();
		this.note_id = note_id;
		this.notebook_id = notebook_id;
		this.user_id = user_id;
		this.note_status = note_status;
		this.note_type = note_type;
		this.note_title = note_title;
		this.note_tags = note_tags;
		this.note_content = note_content;
		this.note_author = note_author;
		this.note_creatTime = note_creatTime;
		this.note_modifyTime = note_modifyTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((note_author == null) ? 0 : note_author.hashCode());
		result = prime * result + ((note_content == null) ? 0 : note_content.hashCode());
		result = prime * result + ((note_creatTime == null) ? 0 : note_creatTime.hashCode());
		result = prime * result + ((note_id == null) ? 0 : note_id.hashCode());
		result = prime * result + ((note_modifyTime == null) ? 0 : note_modifyTime.hashCode());
		result = prime * result + ((note_status == null) ? 0 : note_status.hashCode());
		result = prime * result + ((note_tags == null) ? 0 : note_tags.hashCode());
		result = prime * result + ((note_title == null) ? 0 : note_title.hashCode());
		result = prime * result + ((note_type == null) ? 0 : note_type.hashCode());
		result = prime * result + ((notebook_id == null) ? 0 : notebook_id.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KnowContent other = (KnowContent) obj;
		if (note_author == null) {
			if (other.note_author != null)
				return false;
		} else if (!note_author.equals(other.note_author))
			return false;
		if (note_content == null) {
			if (other.note_content != null)
				return false;
		} else if (!note_content.equals(other.note_content))
			return false;
		if (note_creatTime == null) {
			if (other.note_creatTime != null)
				return false;
		} else if (!note_creatTime.equals(other.note_creatTime))
			return false;
		if (note_id == null) {
			if (other.note_id != null)
				return false;
		} else if (!note_id.equals(other.note_id))
			return false;
		if (note_modifyTime == null) {
			if (other.note_modifyTime != null)
				return false;
		} else if (!note_modifyTime.equals(other.note_modifyTime))
			return false;
		if (note_status == null) {
			if (other.note_status != null)
				return false;
		} else if (!note_status.equals(other.note_status))
			return false;
		if (note_tags == null) {
			if (other.note_tags != null)
				return false;
		} else if (!note_tags.equals(other.note_tags))
			return false;
		if (note_title == null) {
			if (other.note_title != null)
				return false;
		} else if (!note_title.equals(other.note_title))
			return false;
		if (note_type == null) {
			if (other.note_type != null)
				return false;
		} else if (!note_type.equals(other.note_type))
			return false;
		if (notebook_id == null) {
			if (other.notebook_id != null)
				return false;
		} else if (!notebook_id.equals(other.notebook_id))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KnowContent [note_id=" + note_id + ", notebook_id=" + notebook_id + ", user_id=" + user_id
				+ ", note_status=" + note_status + ", note_type=" + note_type + ", note_title=" + note_title
				+ ", note_tags=" + note_tags + ", note_content=" + note_content + ", note_author=" + note_author
				+ ", note_creatTime=" + note_creatTime + ", note_modifyTime=" + note_modifyTime + "]";
	}

}
