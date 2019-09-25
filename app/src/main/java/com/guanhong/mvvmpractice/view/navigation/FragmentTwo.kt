package com.guanhong.mvvmpractice.view.navigation

import android.app.NotificationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.guanhong.mvvmpractice.R
import kotlinx.android.synthetic.main.fragment_navigation_two.*

class FragmentTwo : Fragment(), FragmentTwoAdapter.FragmentTwoAdapterListener {

    private lateinit var adapter: FragmentTwoAdapter

    private var args: String? = null
    private val stringList = listOf("111", "222", "333", "444", "555")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("Huang"," FragmentTwo onCreate")

        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("Huang"," FragmentTwo onCreateView")

        return inflater.inflate(R.layout.fragment_navigation_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FragmentTwoAdapter(this)
        recyclerView.adapter = adapter

        adapter.setStringList(stringList)

        arguments?.let {
            args = it.getString("key")
        }

        textView.setOnClickListener {


            val args = Bundle()
            args.putString("args", "1111")

            val pendingIntent = NavDeepLinkBuilder(context!!)
                .setGraph(R.navigation.nav_graph_main)
                .setDestination(R.id.page3Fragment)
                .setArguments(args)
                .createPendingIntent()

            val builder = NotificationCompat.Builder(context)
                .setContentTitle("標題")
                .setContentText("内容")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

            val notificationManager = context!!.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as (NotificationManager)

            notificationManager.notify(0, builder.build())

//            Navigation.findNavController(it).navigate(R.id.action_page3)
        }
    }

    override fun itemClick(title: String) {

        val bundle = Bundle()

        bundle.putString("titleKey", title)

        findNavController().navigate(R.id.action_page2_to_action_page3, bundle)
    }
}