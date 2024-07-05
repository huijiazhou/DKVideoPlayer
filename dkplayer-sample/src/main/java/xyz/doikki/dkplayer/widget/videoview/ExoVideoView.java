package xyz.doikki.dkplayer.widget.videoview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.TrackSelector;

import xyz.doikki.dkplayer.widget.player.CustomExoMediaPlayer;
import xyz.doikki.videoplayer.exo.ExoMediaPlayer;
import xyz.doikki.videoplayer.player.BaseVideoView;
import xyz.doikki.videoplayer.player.PlayerFactory;
import xyz.doikki.videoplayer.util.PlayerSettings;

@UnstableApi
public class ExoVideoView extends BaseVideoView<ExoMediaPlayer> {

    private MediaSource mMediaSource;

    private boolean mIsCacheEnabled;

//    private LoadControl mLoadControl;
    private RenderersFactory mRenderersFactory;
    private TrackSelector mTrackSelector;


    protected PlayerSettings mPlayerSettings;

    public ExoVideoView(Context context) {
        super(context);
    }

    public ExoVideoView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ExoVideoView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        //由于传递了泛型，必须将CustomExoMediaPlayer设置进来，否者报错
        setPlayerFactory(new PlayerFactory<CustomExoMediaPlayer>() {
            @Override
            public CustomExoMediaPlayer createPlayer(Context context) {
                return new CustomExoMediaPlayer(context);
            }
        });
    }

    @Override
    protected void setInitOptions() {
        super.setInitOptions();
        mMediaPlayer.initPlayerSettings(mPlayerSettings);
        mMediaPlayer.setRenderersFactory(mRenderersFactory);
        mMediaPlayer.setTrackSelector(mTrackSelector);
    }


    /**
     * 设置ExoPlayer的MediaSource
     */
    public void setMediaSource(MediaSource mediaSource) {
        mMediaSource = mediaSource;
    }

    /**
     * 是否打开缓存
     */
    public void setCacheEnabled(boolean isEnabled) {
        mIsCacheEnabled = isEnabled;
    }

//    public void setLoadControl(LoadControl loadControl) {
//        mLoadControl = loadControl;
//    }
    public void initPlayerSettings(PlayerSettings playerSettings){
        this.mPlayerSettings = playerSettings;
    }

    public void setRenderersFactory(RenderersFactory renderersFactory) {
        mRenderersFactory = renderersFactory;
    }

    public void setTrackSelector(TrackSelector trackSelector) {
        mTrackSelector = trackSelector;
    }
}
