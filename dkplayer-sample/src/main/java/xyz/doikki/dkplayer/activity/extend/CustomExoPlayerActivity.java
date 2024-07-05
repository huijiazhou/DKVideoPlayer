package xyz.doikki.dkplayer.activity.extend;

import android.view.View;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.ClippingMediaSource;
import androidx.media3.exoplayer.source.ConcatenatingMediaSource2;
import androidx.media3.exoplayer.source.MediaSource;

import xyz.doikki.dkplayer.R;
import xyz.doikki.dkplayer.activity.BaseActivity;
import xyz.doikki.dkplayer.widget.videoview.ExoVideoView;
import xyz.doikki.videocontroller.StandardVideoController;
import xyz.doikki.videoplayer.exo.ExoMediaPlayer;
import xyz.doikki.videoplayer.exo.ExoMediaSourceHelper;
import xyz.doikki.videoplayer.player.AbstractPlayer;
import xyz.doikki.videoplayer.util.PlayerSettings;

/**
 * 自定义MediaPlayer，有多种情形：
 * 第一：继承某个现成的MediaPlayer，对其功能进行扩展，此demo就演示了通过继承{@link ExoMediaPlayer}
 * 对其功能进行扩展。
 * 第二：通过继承{@link AbstractPlayer}扩展一些其他的播放器。
 */
@UnstableApi
public class CustomExoPlayerActivity extends BaseActivity<ExoVideoView> {

    private ExoMediaSourceHelper mHelper;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_custom_exo_player;
    }

    @Override
    protected void initView() {
        super.initView();
        mVideoView = findViewById(R.id.vv);
        StandardVideoController controller = new StandardVideoController(this);
        controller.addDefaultControlComponent("custom exo", false);
        mVideoView.setVideoController(controller);
        mHelper = ExoMediaSourceHelper.getInstance(this);
    }

  public void onButtonClick(View view) {
        mVideoView.release();
        mVideoView.setCacheEnabled(false);
        switch (view.getId()) {
            case R.id.btn_cache: {
                PlayerSettings playerSettings = new PlayerSettings();
                playerSettings.setLocalProxyEnable(true);
                mVideoView.initPlayerSettings(playerSettings);
                mVideoView.setCacheEnabled(true);
//                mVideoView.setUrl("http://192.168.24.239:20158/play/m3u8/870/4000kb/hls/v_870_1080_dhxr.m3u8?sign=f3047f3984ab41877c704fd5d41fddb338de611df425034cd2d79f26e1480d1db403bdbb3d5e2f38956149f2e7e6a634&rSign=fb9e4d6283425e47ffb2039b1907bed0");
                mVideoView.setUrl("http://192.168.24.239:20158/play/m3u8/805/500kb/hls/v_805_360_1cB6.m3u8?sign=8b96826ce45b1376c30961c812f7d9b0066051e592ce92e8aaba07a9c3f19044ceb2a6ef5cd566e4a71f283a00e9f35b&rSign=ba88a78ed1e49538aaa3b5ca7317961f");
                break;
            }
            case R.id.btn_concat: {
                //将多个视频拼接在一起播放

                MediaSource mediaSource1 = mHelper.getMediaSource("http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4");
                MediaSource mediaSource2 = mHelper.getMediaSource("http://vfx.mtime.cn/Video/2019/03/21/mp4/190321153853126488.mp4");
                MediaSource mediaSource3 = mHelper.getMediaSource("http://vfx.mtime.cn/Video/2019/03/19/mp4/190319222227698228.mp4");
                mVideoView.setMediaSource(new ConcatenatingMediaSource2.Builder()
                        .add(mediaSource1)
                        .add(mediaSource2)
                        .add(mediaSource3).build());
                break;
            }
            case R.id.btn_clip: {
                MediaSource mediaSource = mHelper.getMediaSource("http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4");
                //裁剪10-15秒的内容进行播放
                ClippingMediaSource clippingMediaSource = new ClippingMediaSource(mediaSource, 10_000_000, 15_000_000);
                mVideoView.setMediaSource(clippingMediaSource);
                break;
            }
            case R.id.btn_dash: {
                mVideoView.setUrl("http://www.bok.net/dash/tears_of_steel/cleartext/stream.mpd");
                break;
            }
            case R.id.btn_rtsp: {
                mVideoView.setUrl("rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov");
                break;
            }
        }

        mVideoView.start();
    }
}
