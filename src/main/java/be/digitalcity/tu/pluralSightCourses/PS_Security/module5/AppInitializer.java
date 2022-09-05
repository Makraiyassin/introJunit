package be.digitalcity.tu.pluralSightCourses.PS_Security.module5;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

@Component("module5AppInitializer")
public class AppInitializer implements SmartInitializingSingleton {
	private final MusicRepository music;

	public AppInitializer(MusicRepository music) {
		this.music = music;
	}

	@Override
	public void afterSingletonsInstantiated() {
	}
}
