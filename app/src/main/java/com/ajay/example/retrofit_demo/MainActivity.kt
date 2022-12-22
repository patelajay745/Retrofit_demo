package com.ajay.example.retrofit_demo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    lateinit var retService: AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view)

        retService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)


        getRequestWithQuery()
        getRequestWithPathParameters()

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
        val album=AlbumsItem(0,"my data",3)
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