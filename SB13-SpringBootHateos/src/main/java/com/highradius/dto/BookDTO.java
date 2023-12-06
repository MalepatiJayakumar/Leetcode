package com.highradius.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name="book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO extends RepresentationModel<BookDTO>{
	private String name;
	private String author;
}