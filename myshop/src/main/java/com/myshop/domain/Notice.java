package com.myshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@TableGenerator(
		name = "NOTICE_SEQ_GENERATOR",
		table = "MY_SEQUENCES",
		pkColumnValue = "NOTICE_SEQ", allocationSize = 50)
public class Notice {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "NOTICE_SEQ_GENERATOR")
	@Column(name = "notice_id")
	private long id;
	private String title;
	private String content;
	private String img_src;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Notice() {}
	
	public Notice(String title, String content, String img_src, User user) {
		this.title = title;
		this.content = content;
		this.img_src = img_src;
		this.user = user;
	}
}
