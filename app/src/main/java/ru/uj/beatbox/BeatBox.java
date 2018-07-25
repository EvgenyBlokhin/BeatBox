package ru.uj.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blokhin Evgeny on 12.07.2018.
 */
public class BeatBox {
    private static final String TAG = "BeatBox";

    private static final String SOUND_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS = 1;

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;
//    private MediaPlayer mMediaPlayer;
    private float mSoundRate;

    public BeatBox(Context context) {
        mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC,0);
//        mMediaPlayer = new MediaPlayer();
//        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        loadSounds();
    }

    public void play(Sound sound) {
        Integer soundId = sound.getSoundId();
        if (soundId == null) {
            return;
        }
        mSoundPool.play(soundId,1.0f, 1.0f, 1, 0, mSoundRate);
//        mMediaPlayer = MediaPlayer.create(this, );
//        mMediaPlayer.start();
    }

    public void release() {
        mSoundPool.release();
    }

    private void loadSounds() {
        String[] soundNames;
        try {
            soundNames = mAssets.list(SOUND_FOLDER);
            Log.i(TAG, "Found " + soundNames.length + " sounds");
        } catch (IOException ioe) {
            Log.e(TAG, "Could not list assets", ioe);
            return;
        }
        for (String filename :
                soundNames) {
            try {
                String assetPath = SOUND_FOLDER + "/" + filename;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSounds.add(sound);
            } catch (IOException ioe) {
                Log.e(TAG, "Could not load sound " + filename, ioe);
            }
        }
    }

    private void load(Sound sound) throws IOException {
        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath());
//        FileDescriptor fd = afd.getFileDescriptor();
//        mMediaPlayer.setDataSource(fd);
//        int ID = mMediaPlayer.getAudioSessionId();
        int soundId = mSoundPool.load(afd, 1);
        Log.i("TAG_ID", String.valueOf(soundId));
//        Log.i("TAG_ID", String.valueOf(ID));
//        int soundId = mMediaPlayer.
        sound.setSoundId(soundId);
    }
    public List<Sound> getSounds() {
        return mSounds;
    }

    public void setSoundRate(float soundRate) {
        mSoundRate = soundRate == 0.0f ? 0.1f : soundRate/10;
        Log.i("TAG", String.valueOf(mSoundRate));
    }
}
