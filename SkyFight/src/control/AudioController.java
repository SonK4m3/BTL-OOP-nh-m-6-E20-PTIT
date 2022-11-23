package control;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioController {
	private String main_menu_path = "audio\\main_menu.wav";
	private String waiting1_path = "audio\\waiting1.wav";
	private String waiting2_path = "audio\\waiting2.wav";
	private String fight_path = "audio\\fight.wav";
	private String crash_path = "audio\\crash.wav";
	private String hit_part_path = "audio\\hit_part.wav";
	private String miss_path = "audio\\miss.wav";
	private String error_path = "audio\\error.wav";
	private String place_aircraft_path = "audio\\place_aircraft.wav";
	private String rotate_aircraft_path = "audio\\rotate_aircraft.wav";
	
	private Clip main_menu_audio;
	private Clip waiting1_audio;
	private Clip waiting2_audio;
	private Clip fight_audio;
	private Clip crash_audio;
	private Clip hit_part_audio;
	private Clip miss_audio;
	private Clip error_audio;
	private Clip place_aircraft_audio;
	private Clip rotate_aircraft_audio;
	public AudioController() {
		
	}
	public Clip readAudio(String file_path) {
		AudioInputStream audioInputStream;
		Clip clip = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(file_path).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (Exception e) {
			System.out.println("can't load audio");
			e.printStackTrace();
		}
		return clip;
	}
	public void playMainMenu() {
		main_menu_audio = readAudio(main_menu_path);
		main_menu_audio.start();
	}
	public void stopMainMenu() {
		main_menu_audio.close();
	}
	public void playWaiting1() {
		waiting1_audio = readAudio(waiting1_path);
		waiting1_audio.start();
	}
	public void stopWaiting1() {
		waiting1_audio.close();
	}
	public void playWaiting2() {
		waiting2_audio = readAudio(waiting2_path);
		waiting2_audio.start();
	}
	public void stopWaiting2() {
		waiting2_audio.close();
	}
	public void playFight() {
		fight_audio = readAudio(fight_path);
		fight_audio.start();
	}
	public void playError() {
		error_audio = readAudio(error_path);
		error_audio.start();
	}
	public void playCrash() {
		crash_audio = readAudio(crash_path);
		crash_audio.start();
	}
	public void playHitPart() {
		hit_part_audio = readAudio(hit_part_path);
		hit_part_audio.start();
	}
	public void playMiss() {
		miss_audio = readAudio(miss_path);
		miss_audio.start();
	}
	public void playPlaceAircraft() {
		place_aircraft_audio = readAudio(place_aircraft_path);
		place_aircraft_audio.start();
	}
	public void playRotateAircraft() {
		rotate_aircraft_audio = readAudio(rotate_aircraft_path);
		rotate_aircraft_audio.start();
	}
}
