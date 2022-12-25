package com.ajay.example.retrofit_demo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.ajay.example.retrofit_demo.album.AlbumService
import com.ajay.example.retrofit_demo.album.Albums
import com.ajay.example.retrofit_demo.album.AlbumsItem
import com.ajay.example.retrofit_demo.cricket.CricketApi
import com.ajay.example.retrofit_demo.cricket.RetroFitHelper

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    lateinit var retService: AlbumService



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view)

        //retService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)



        val cricketApi= RetroFitHelper.getInstance().create(CricketApi::class.java)

        GlobalScope.launch {
            val result=cricketApi.getCurrentMatches("9a27591c-3fe7-4a56-8611-40c992d062eb","2")
            withContext(Main){
                if(result!==null){
                    val matchlist=result.body()
                    matchlist?.match?.forEach {
                        var score_info=""
                        var counter=1
                        it.score.forEach { score ->
                            if(counter==1){
                                score_info= score.inning+" : "+ score.r+"/"+score.w+"("+score.o+" Overs)"
                            }else{
                                score_info=score_info+"\n"+score.inning+" : "+ score.r+"/"+score.w+"("+score.o+"Overs)"
                            }
                            counter++
                        }


                        val result = " " + "venue : ${it.venue}" + "\n" +
                                " " + "matchType : ${it.matchType}" + "\n" +
                                " " + "Match Between : ${it.teams[0]} vs ${it.teams[1]}" + "\n" +
                                " " + "Score : ${score_info}" + "\n" +
                                " " + "Status : ${it.status}" + "\n\n\n"
                        textView.append(result)
                    }
                }
            }
        }

/*
        getRequestWithQuery()
        getRequestWithPathParameters()


 */

    }



    private fun getRequestWithQuery() {

        val resposeLiveData: LiveData<Response<Albums>> = liveData {
            //val response = retService.getAlbums()
            val response = retService.getSortedAlbums(3)
            emit(response)
        }

        resposeLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumItem = albumsList.next()
                    Log.i("MyTAG", albumItem.title)
                    val result = " " + "Album id : ${albumItem.id}" + "\n" +
                            " " + "Album Title : ${albumItem.title}" + "\n" +
                            " " + "User id : ${albumItem.userId}" + "\n\n\n"
                    textView.append(result)

                }
            }
        })

    }

    private fun getRequestWithPathParameters() {

        //path parameter example
        val pathRespose: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.getAlbum(3)

            emit(response)
        }

        pathRespose.observe(this, Observer {
            val title = it.body()?.title


        })

    }

    private fun uploadAlbum(){
        val album= AlbumsItem(0,"my data",3)
        val postResponse:LiveData<Response<AlbumsItem>> = liveData {
            val response=retService.uploadAlbum(album)
            emit(response)
        }
        postResponse.observe(this, Observer {
            val recievedAlbumItem = it.body()

            val result = " " + "Album id : ${recievedAlbumItem?.id}" + "\n" +
                    " " + "Album Title : ${recievedAlbumItem?.title}" + "\n" +
                    " " + "User id : ${recievedAlbumItem?.userId}" + "\n\n\n"

            textView.append(result)

        })
    }
}