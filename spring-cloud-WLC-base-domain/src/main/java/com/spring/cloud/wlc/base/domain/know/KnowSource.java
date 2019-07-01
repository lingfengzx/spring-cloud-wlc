package com.spring.cloud.wlc.base.domain.know;

import java.io.Serializable;

public class KnowSource implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String INDEX_NAME = "know_source";
	
	private String type;
  
	private String id;
	
	private KnowContent content;

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public KnowContent getContent() {
		return content;
	}

	public void setContent(KnowContent content) {
		this.content = content;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

	public KnowSource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KnowSource(String type, KnowContent content) {
		super();
		this.type = type;
		this.content = content;
	}
	
	

	public KnowSource(String type, String id, KnowContent content) {
		super();
		this.type = type;
		this.id = id;
		this.content = content;
	}

	@Override
	public String toString() {
		return "KnowSource [type=" + type + ", content=" + content + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		KnowSource other = (KnowSource) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}
