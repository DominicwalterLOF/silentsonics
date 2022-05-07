package com.google.appinventor.components.runtime.util;

import android.media.AudioManager;
import com.google.appinventor.components.runtime.Player;

public class FroyoUtil {
    private FroyoUtil() {
    }

    public static Object setAudioFocusChangeListener(Player player) {
        Object obj;
        final Player player2 = player;
        new AudioManager.OnAudioFocusChangeListener() {
            private boolean vzOZHmUO5BPgEzqFqapthv9IfOCdoiue7DhwcposBCrplFafOlnwvaDCI1FzofZg = false;

            public final void onAudioFocusChange(int i) {
                switch (i) {
                    case -3:
                    case -2:
                        if (player2 != null && player2.playerState == Player.State.PLAYING) {
                            player2.pause();
                            this.vzOZHmUO5BPgEzqFqapthv9IfOCdoiue7DhwcposBCrplFafOlnwvaDCI1FzofZg = true;
                            return;
                        }
                        return;
                    case -1:
                        this.vzOZHmUO5BPgEzqFqapthv9IfOCdoiue7DhwcposBCrplFafOlnwvaDCI1FzofZg = false;
                        player2.OtherPlayerStarted();
                        return;
                    case 1:
                        if (player2 != null && this.vzOZHmUO5BPgEzqFqapthv9IfOCdoiue7DhwcposBCrplFafOlnwvaDCI1FzofZg && player2.playerState == Player.State.PAUSED_BY_EVENT) {
                            player2.Start();
                            this.vzOZHmUO5BPgEzqFqapthv9IfOCdoiue7DhwcposBCrplFafOlnwvaDCI1FzofZg = false;
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        return obj;
    }

    public static boolean focusRequestGranted(AudioManager audioManager, Object obj) {
        return audioManager.requestAudioFocus((AudioManager.OnAudioFocusChangeListener) obj, 3, 1) == 1;
    }

    public static void abandonFocus(AudioManager audioManager, Object obj) {
        int abandonAudioFocus = audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) obj);
    }
}
