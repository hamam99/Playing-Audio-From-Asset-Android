package com.avaloncode.playaudioasset;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	MediaPlayer mp;
	AssetFileDescriptor afd;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		// media player
		mp = new MediaPlayer();

		// setting button
		Button play = (Button) findViewById(R.id.btnPlay);
		play.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					// afd --> for open file audio in asset folder
					afd = getAssets().openFd("horror.mp3");

					// setting data source for media player
					mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
					mp.prepare();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// audio
				mp.start();

			}
		});

	}

}
