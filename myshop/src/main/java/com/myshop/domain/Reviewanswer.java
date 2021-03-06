package com.myshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
		name = "REVIEWANSWER_SEQ_GENERATOR",
		table = "MYSHOP_SEQUENCES",
		pkColumnValue = "REVIEWANSWER_SEQ", allocationSize = 50)
public class Reviewanswer {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "REVIEWANSWER_SEQ_GENERATOR")
	@Column(name = "reviewanswer_id")
	private long id;
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "review_id")
	private Review review;
	
	public Reviewanswer() {}
	
	public Reviewanswer(String content, User user, Review review) {
		this.content = content;
		this.user = user;
		this.review = review;
	}
}
