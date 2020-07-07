package com.gabriel.swarmintelligence.activity_lead

import android.annotation.SuppressLint
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.view.WindowManager
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.gabriel.swarmintelligence.R
import com.gabriel.swarmintelligence.activity_team.activity_team_main
import com.gabriel.swarmintelligence.activity_team.create_username.Create_UserName
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.fragment_warn.*

class activity_warn  : AppCompatActivity(), View.OnClickListener{

    private lateinit var mp: MediaPlayer
    private var totalTime: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.fragment_warn)

        nextswarmButton.setOnClickListener(this)
        playswarmButton.setOnClickListener(this)

        fab.setOnClickListener{v->
            mp.stop()
            val intent = Intent(this, activity_lead_main::class.java)
            startActivity(intent)
            AcTrans.Builder(this).performNoAnimation()
            finish()
        }
        teamButton.setOnClickListener{v->
            mp.stop()
            val intent = Intent(this, Create_UserName::class.java)
            startActivity(intent)
            AcTrans.Builder(this).performNoAnimation()
            finish()
        }

        mp = MediaPlayer.create(this, R.raw.sample)
//        mp = MediaPlayer().apply {
//            setAudioStreamType(AudioManager.STREAM_MUSIC)
//            setDataSource(this@activity_warn, Uri.parse("https://file-examples.com/wp-content/uploads/2017/11/file_example_MP3_700KB.mp3"))
//            prepare()
//        }
//        mp.isLooping = true
        mp.setVolume(1f, 1f)
        totalTime = mp.duration

//        positionBar bar
        positionBar.max = totalTime
        positionBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        mp.seekTo(progress)
                    }
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {
                }
                override fun onStopTrackingTouch(p0: SeekBar?) {
                }
            }
        )

//        Thread
        Thread(Runnable {
            while (mp != null){

                try {
                    var msg = Message()
                    msg.what = mp.currentPosition
                    handler.sendMessage(msg)
                    Thread.sleep(1000)
                }catch (e: InterruptedException){
                }
            }
        }).start()
    }
    @SuppressLint("HandlerLeak")
    var handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            var currentPosition = msg.what

            // Update positionBar
            positionBar.progress = currentPosition

            // Update Labels
            var elapsedTime = createTimeLabel(currentPosition)
            progressText.text = elapsedTime

//            var remainingTime = createTimeLabel(totalTime - currentPosition)
//            progressText.text = "-$remainingTime"
        }
    }

    fun createTimeLabel(time: Int): String {
        var timeLabel = ""
        var min = time / 1000 / 60
        var sec = time / 1000 % 60

        timeLabel = "$min:"
        if (sec < 10) timeLabel += "0"
        timeLabel += sec

        return timeLabel
    }


    fun playBtnClick(v:View){
        if (mp.isPlaying){
            mp.pause()
            playButton.setImageResource(R.drawable.ic_play_arrow)
        }
        else{
            mp.start()
            playButton.setImageResource(R.drawable.ic_pause)
        }
    }

    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
        when(v?.id){
            R.id.nextswarmButton -> {
//                Toast.makeText(context, "next clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.playswarmButton->{
                mp.stop()
                val intent = Intent(this, activity_play_swarm::class.java)
                startActivity(intent)
                AcTrans.Builder(this).performNoAnimation()
                finish()
            }
        }
    }
}
