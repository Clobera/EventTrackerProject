package com.skilldistillery.austinevents.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Picture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String url;

	@Column(name = "picture_description")
	private String pictureDescription;

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	public Picture() {
		super();
	}

	public Picture(int id, String url, String pictureDescription, Event event) {
		super();
		this.id = id;
		this.url = url;
		this.pictureDescription = pictureDescription;
		this.event = event;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPictureDescription() {
		return pictureDescription;
	}

	public void setPictureDescription(String pictureDescription) {
		this.pictureDescription = pictureDescription;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Picture other = (Picture) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", url=" + url + ", pictureDescription=" + pictureDescription + ", event=" + event
				+ "]";
	}

	
}
