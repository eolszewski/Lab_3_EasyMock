import java.util.ArrayList;

public class MockMp3Player implements Mp3Player {

	ArrayList<String> playlist;
	boolean playing;
	int songNumber;
	double position, startTime;

	MockMp3Player() {
		this.playlist = new ArrayList<String>();
		this.playing = false;
		this.position = 0;
		this.songNumber = 0;
		this.startTime = 0;
	}

	@Override
	public void play() {
		if (playlist.size() > 0) {
			startTime = position = System.nanoTime();
			playing = true;
		}
	}

	@Override
	public void pause() {
		if (playing) {
			playing = false;
			position = System.nanoTime();
		}
	}

	@Override
	public void stop() {
		playing = false;
		position = 0;
	}

	@Override
	public double currentPosition() {
		if (playing)
			return System.nanoTime() - startTime;
		else
			return position;
	}

	@Override
	public String currentSong() {
		return playlist.get(songNumber);
	}

	@Override
	public void next() {
		if (songNumber < playlist.size()) 
			songNumber++;
		startTime = System.nanoTime();
	}

	@Override
	public void prev() {
		if (songNumber > 0)
			songNumber--;
		startTime = System.nanoTime();
	}

	@Override
	public boolean isPlaying() {
		return playing;
	}

	@Override
	public void loadSongs(ArrayList names) {
		this.playlist = names;
	}
}
