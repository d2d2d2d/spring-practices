package com.douzone.container.soundsystem;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	// Wiring01: 바이너리 주입(CGLib) 
	// @Inject (자바 표준 Wiring 어노테이션)
	// @Autowired (스프링 Wiring 어노테이션)
	@Qualifier("highSchoolRapper3Final")
	private CompactDisc cd;

	public CDPlayer() {
	}
	
	// Wiring02: 생성자 주입
	// @Autowired
	public CDPlayer(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
	// Wiring03: setter 사용
	// @Autowired
	public void setCompactDisc(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}

	// Wiring04: 일반 메소드 사용
	// @Autowired
	public void insertCompactDisc(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
	public void play() {
		cd.play();
	}
}