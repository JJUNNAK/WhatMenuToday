 package com.example.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.CheckBox
import kotlinx.android.synthetic.main.fragment_home.*


 class HomeFragment : Fragment(){
    companion object {
        const val TAG: String = "로그"

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }

    }

    //메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Log.d(TAG, "HomeFragment - onCreate:() called")

    }

    //프레그먼트를 안고있는 엑티비티에 붙었을때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "HomeFragment - onCreate:() called")
    }


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_home, container, false)

        return rootView
    }

    //fragment에서 버튼 기능 활용하기 위한 변수설정
    lateinit var bannerButton: Button
    lateinit var mapButton: Button
    lateinit var KoreanButton: Button
    lateinit var ChinaButton: Button
    lateinit var JapanButton: Button
    lateinit var WesternButton: Button
    lateinit var SnackButton: Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //버튼 아이디 설정

        bannerButton = view.findViewById(R.id.btn_banner)
        mapButton = view.findViewById(R.id.btn_map)
        KoreanButton = view.findViewById(R.id.cb2)
        ChinaButton = view.findViewById(R.id.cb1)
        JapanButton = view.findViewById(R.id.cb3)
        WesternButton = view.findViewById(R.id.cb4)
        SnackButton = view.findViewById(R.id.cb5)

        //배너로 넘어가기 위한 인텐트 코드
        activity?.let {
            val banner = Intent(context, Banner::class.java)
            bannerButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    startActivity(banner)
                }
            })

        }
        //지도 전체
        activity?.let {
            val map = Intent(context, MapActivity::class.java)
            mapButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    startActivity(map)
                }
            })
        }
        //중식 체크 후 지도
        activity?.let {

            val ChinaBFood = Intent(context, ChinaFood::class.java)
            ChinaButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    startActivity(ChinaBFood)
                }
            })
        }
        //한식 체크 후 지도
        activity?.let {

            val KoreanFood = Intent(context, KoreanFood::class.java)
            KoreanButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    startActivity(KoreanFood)
                }
            })
        }

        activity?.let {

            val JapanFood = Intent(context, JapanFood::class.java)
            JapanButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    startActivity(JapanFood)
                }
            })
        }
        activity?.let {

            val westernFood = Intent(context, WesternFood::class.java)
            WesternButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    startActivity(westernFood)
                }
            })
        }
        activity?.let {

            val snackBar = Intent(context, SnackBar::class.java)
            SnackButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    startActivity(snackBar)
                }
            })
        }
    }
}
