package xyz.doikki.dkplayer.util;

import android.content.Context;

import xyz.doikki.dkplayer.bean.TiktokBean;
import xyz.doikki.dkplayer.bean.VideoBean;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    public static final String SAMPLE_URL = "http://vfx.mtime.cn/Video/2019/03/14/mp4/190314223540373995.mp4";
//    public static final String SAMPLE_URL = "file:///mnt/sdcard/out.webm";

//    public static List<VideoBean> getVideoList() {
//        List<VideoBean> videoList = new ArrayList<>();
//        videoList.add(new VideoBean("七舅脑爷| 脑爷烧脑三重奏，谁动了我的蛋糕",
//                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2018/03/2018-03-30_10-1782811316-750x420.jpg",
//                "http://cdnxdc.tanzi88.com/XDC/dvideo/2018/03/29/8b5ecf95be5c5928b6a89f589f5e3637.mp4"));
//
//        videoList.add(new VideoBean("七舅脑爷| 你会不会在爱情中迷失了自我，从而遗忘你正拥有的美好？",
//                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2018/02/2018-02-09_23-573150677-750x420.jpg",
//                "http://cdnxdc.tanzi88.com/XDC/dvideo/2018/02/29/056bf3fabc41a1c1257ea7f69b5ee787.mp4"));
//
//        videoList.add(new VideoBean("七舅脑爷| 别因为你的患得患失，就怀疑爱情的重量",
//                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2018/02/2018-02-23_57-2208169443-750x420.jpg",
//                "http://cdnxdc.tanzi88.com/XDC/dvideo/2018/02/29/db48634c0e7e3eaa4583aa48b4b3180f.mp4"));
//
//        videoList.add(new VideoBean("七舅脑爷| 女员工遭老板调戏，被同事陷害，双面夹击路在何方？",
//                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/12/2017-12-08_39-829276539-750x420.jpg",
//                "http://cdnxdc.tanzi88.com/XDC/dvideo/2017/12/29/fc821f9a8673d2994f9c2cb9b27233a3.mp4"));
//
//        videoList.add(new VideoBean("七舅脑爷| 夺人女友，帮人作弊，不正经的学霸比校霸都可怕。",
//                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2018/01/2018-01-05_49-2212350172-750x420.jpg",
//                "http://cdnxdc.tanzi88.com/XDC/dvideo/2018/01/29/bc95044a9c40ec2d8bdf4ac9f8c50f44.mp4"));
//
//        videoList.add(new VideoBean("七舅脑爷| 男子被困秘密房间上演绝命游戏, 背后凶手竟是他?",
//                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/11/2017-11-10_10-320769792-750x420.jpg",
//                "http://cdnxdc.tanzi88.com/XDC/dvideo/2017/11/29/15f22f48466180232ca50ec25b0711a7.mp4"));
//
//        videoList.add(new VideoBean("七舅脑爷| 男人玩心机，真真假假，我究竟变成了谁？",
//                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/11/2017-11-03_37-744135043-750x420.jpg",
//                "http://cdnxdc.tanzi88.com/XDC/dvideo/2017/11/29/7c21c43ba0817742ff0224e9bcdf12b6.mp4"));
//
//        return videoList;
//    }

    public static List<VideoBean> getVideoList() {
        List<VideoBean> videoList = new ArrayList<>();
        videoList.add(new VideoBean("预告片1",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://192.168.24.239:20158/play/m3u8/754/v_754_npBo.m3u8?sign=a816be779a83cc203e3cb6ff68daeff44a2767fe30562ea97d2b990ef63f71eb9b7cdbe59102798cbf068c616ff0145f&rSign=98964aaf1df0837eee0befc7d84d4496"
                ));

        videoList.add(new VideoBean("预告片2",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://192.168.24.239:20158/play/m3u8/830/v_830_64xM.m3u8?sign=a816be779a83cc203e3cb6ff68daeff401171f6680730c5086d2fa01763556a4a671a9037f157f5f1b69a4e2d293e448&rSign=281bcd38e963286558d5522432946fff"
                ));

        videoList.add(new VideoBean("预告片3",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://192.168.24.239:20158/play/m3u8/889/v_889_J2hU.m3u8?sign=a816be779a83cc203e3cb6ff68daeff4a7c5699fd3025fc5385265c5ed5b5253aeaa79a57a12ea08cea4cfbe4a8fc73d&rSign=04a9bcf8b4573a58d56f6ede70b9e71c"
                ));

        videoList.add(new VideoBean("预告片4",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://192.168.24.239:20158/play/m3u8/763/v_763_ms5u.m3u8?sign=a816be779a83cc203e3cb6ff68daeff49ef1a6496f303024f29c058d2e0741f670bfc01a20afbf19b7eb280bb1ca5eca&rSign=68e4864b5765aca92313f1edb9b72e8a"
        ));

        videoList.add(new VideoBean("预告片5",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://192.168.24.239:20158/play/m3u8/765/v_765_Xa6F.m3u8?sign=a816be779a83cc203e3cb6ff68daeff416326e2e8dd8d7bc81d58759a847c164a94f0860b8164f9efa83a83e0defe18c&rSign=7c668b025e1964354aa1cf7537d374a0"
                ));

        videoList.add(new VideoBean("预告片6",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://192.168.24.239:20158/play/m3u8/833/v_833_a5Ah.m3u8?sign=a816be779a83cc203e3cb6ff68daeff42e8a44dcbd2c28be3ef84ed8ecf1adaf8aa34ebc02d4812fd9590022b94ec872&rSign=c9d493ca412c646f74e0de7765be7e88"
                ));

        videoList.add(new VideoBean("预告片7",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://192.168.24.239:20158/play/m3u8/854/v_854_6oaE.m3u8?sign=a816be779a83cc203e3cb6ff68daeff47ebb77a2826068edd122bba260813285a83cc31455adf2d4eb61ae19382e7b22&rSign=af53b88661db42b0f3509cea1b5f6bc4"
                ));

        videoList.add(new VideoBean("预告片8",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://192.168.24.239:20158/play/m3u8/809/v_809_QvLx.m3u8?sign=a816be779a83cc203e3cb6ff68daeff4f293a829ae007b2ba9406569e38d7cd32dae49da549a403a519ed60bcf559d33&rSign=fccffa5c182de25221e8805873456acd"
                ));

        videoList.add(new VideoBean("预告片9",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://192.168.24.210:2100/20240612/1RXJme64/index.m3u8?sign=a816be779a83cc203e3cb6ff68daeff4f293a829ae007b2ba9406569e38d7cd32dae49da549a403a519ed60bcf559d33&rSign=26e520246dc7c95241b4e256f653f7e7d755825beedb98f919a6593f21fbad1a"
                ));

        videoList.add(new VideoBean("预告片10",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://192.168.24.239:20158/play/m3u8/813/v_813_Fhum.m3u8?sign=a816be779a83cc203e3cb6ff68daeff4cbc75ce06160b098822e5b55762dbb51b8d66957c4a014d31cef8283541b704a&rSign=bd87736bab8b67e0cd27d980855a008b"
                ));

        videoList.add(new VideoBean("预告片11",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://192.168.24.210:20158/play/m3u8/861/v_861_mbRS.m3u8?sign=a816be779a83cc203e3cb6ff68daeff4e62d9152fe90e7c68dcd0d581658e3a55001ff092e9bc58b3df475941971edb7&rSign=ea12c036fb832c4cba96ed40434de109"
                ));

        videoList.add(new VideoBean("预告片12",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://192.168.24.239:20158/play/m3u8/787/v_787_69WC.m3u8?sign=a816be779a83cc203e3cb6ff68daeff4070dfefdb461ee52221ad3d36b4b3472879f7cade4703463cd138a4eb38642c0&rSign=34b1a4db26a2fbb91ec612f2cbceb30c"
                ));

        videoList.add(new VideoBean("预告片13",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://192.168.24.239:20158/play/m3u8/814/v_814_LmUH.m3u8?sign=a816be779a83cc203e3cb6ff68daeff479ddaa19bdad8f8b2c61fb3a5766309abaecebfc2e4483c1628b2827698538c7&rSign=0f4938e0e10187fb117a18d5745f8b02"
                ));

        videoList.add(new VideoBean("预告片14",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://192.168.24.210:20158/play/20240603/TZieeUvt/index.m3u8?sign=a816be779a83cc203e3cb6ff68daeff4798ef916cc2fe8143f7bbb6d9b850df75f41a18947187409b6ef17378d73f698&rSign=23732e4f0ac1baf4a395e07a165a76657bbc2baab0b1bb5f2b6f23b9759ebdde"
                ));

        return videoList;
    }

//    /**
//     * 抖音演示数据
//     */
//    public static List<VideoBean> getTikTokVideoList() {
//        List<VideoBean> videoList = new ArrayList<>();
//        videoList.add(new VideoBean("",
//                "https://p9.pstatp.com/large/4c87000639ab0f21c285.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=97022dc18711411ead17e8dcb75bccd2&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p1.pstatp.com/large/4bea0014e31708ecb03e.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=374e166692ee4ebfae030ceae117a9d0&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p1.pstatp.com/large/4bb500130248a3bcdad0.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=8a55161f84cb4b6aab70cf9e84810ad2&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p9.pstatp.com/large/4b8300007d1906573584.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=47a9d69fe7d94280a59e639f39e4b8f4&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p9.pstatp.com/large/4b61000b6a4187626dda.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=3fdb4876a7f34bad8fa957db4b5ed159&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p9.pstatp.com/large/4c87000639ab0f21c285.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=97022dc18711411ead17e8dcb75bccd2&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p1.pstatp.com/large/4bea0014e31708ecb03e.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=374e166692ee4ebfae030ceae117a9d0&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p1.pstatp.com/large/4bb500130248a3bcdad0.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=8a55161f84cb4b6aab70cf9e84810ad2&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p9.pstatp.com/large/4b8300007d1906573584.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=47a9d69fe7d94280a59e639f39e4b8f4&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p9.pstatp.com/large/4b61000b6a4187626dda.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=3fdb4876a7f34bad8fa957db4b5ed159&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p9.pstatp.com/large/4c87000639ab0f21c285.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=97022dc18711411ead17e8dcb75bccd2&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p1.pstatp.com/large/4bea0014e31708ecb03e.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=374e166692ee4ebfae030ceae117a9d0&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p1.pstatp.com/large/4bb500130248a3bcdad0.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=8a55161f84cb4b6aab70cf9e84810ad2&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p9.pstatp.com/large/4b8300007d1906573584.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=47a9d69fe7d94280a59e639f39e4b8f4&line=0&ratio=720p&media_type=4&vr_type=0"));
//
//        videoList.add(new VideoBean("",
//                "https://p9.pstatp.com/large/4b61000b6a4187626dda.jpeg",
//                "https://aweme.snssdk.com/aweme/v1/play/?video_id=3fdb4876a7f34bad8fa957db4b5ed159&line=0&ratio=720p&media_type=4&vr_type=0"));
//        return videoList;
//    }

    public static List<TiktokBean> tiktokData;

    public static List<TiktokBean> getTiktokDataFromAssets(Context context) {
        try {
            if (tiktokData == null) {
                InputStream is = context.getAssets().open("tiktok_data");
                int length = is.available();
                byte[] buffer = new byte[length];
                is.read(buffer);
                is.close();
                String result = new String(buffer, Charset.forName("UTF-8"));
                tiktokData = TiktokBean.arrayTiktokBeanFromData(result);
            }
            return tiktokData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
