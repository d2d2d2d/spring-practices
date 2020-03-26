package config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {
	
	@Bean
	public Avengers avengers() {
		return new Avengers();
	}
	
	// 주입하기1
	@Bean
	public DVDPlayer dvdPlayers01() {
		return new DVDPlayer(avengers());
	}
	
	// 주입하기02
	@Bean
	public DVDPlayer dvdPlayers02(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	
	// 주입하기03 : 파라미터로 Bean 전달하기 : setter 주입
	@Bean
	public DVDPlayer dvdPlayers03(DigitalVideoDisc dvd) {
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		return dvdPlayer;
	}
	
	// 주입하기04 : 파라미터로 Bean 전달하기 : setter 주입
	@Bean(name="dvdPlayer04")
	public DVDPlayer dvdPlayers04(DigitalVideoDisc dvd) {
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		return dvdPlayer;
	}

}
