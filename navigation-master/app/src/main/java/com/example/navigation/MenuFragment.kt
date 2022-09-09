package com.example.navigation

import android.content.ClipData.newIntent
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_menu.*
import android.content.Intent as Intent1

class MenuFragment : Fragment() {

    companion object {

        //로그데이터 확인하기 위한 프로그램
        const val TAG: String = "로그"

        //fragmentMenu 시작부분
        fun newInstance(): MenuFragment {
            return MenuFragment()
        }
    }

    //메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MenuFragment - onCreate:() called")
    }

    //프레그먼트를 안고있는 엑티비티에 붙었을때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "MenuFragment - onCreate:() called")
    }

    //뷰가 생성되었을때
    //프레그먼트와 레이아웃을 연결시켜주는 부분이다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "MenuFragment - onCreate:() called")
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        return view
    }

    //fragment에서 버튼 기능 활용하기 위한 변수설정
    lateinit var noticeButton: Button
    lateinit var gameButton: Button
    lateinit var foodButton: Button
    lateinit var boardButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //버튼 아이디 설정
        noticeButton = view.findViewById(R.id.btn_notice)
        gameButton = view.findViewById(R.id.btn_game)
        foodButton = view.findViewById(R.id.btn_schoolmeal)
        boardButton = view.findViewById(R.id.btn_freeboard)

        //학사공지 버튼 이벤트
        noticeButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {

                var intent = Intent1(
                    Intent1.ACTION_VIEW,
                    Uri.parse("https://www.mjc.ac.kr/bbs/data/list.do?menu_idx=66")
                )
                startActivity(intent)
            }
        })

        //학식 버튼 이벤트
        foodButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {

                var food = Intent1(
                    Intent1.ACTION_VIEW,
                    Uri.parse("https://www.mjc.ac.kr/ibuilder.do?menu_idx=278&sso=ok")
                )
                startActivity(food)
            }
        })

        //자유게시판으로 넘어가기 위한 인텐트 코드
        activity?.let {
            val board = Intent1(context, CommentMainActivity::class.java)
            boardButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    startActivity(board)
                }
            })

        }

        //fragment -> intent 넘어가기 위한 기능(버튼 클릭 이벤트 통해서)
        activity?.let{

            val game = Intent1(context, Game_menu_effect::class.java) //넘어갈 엑티비티
            gameButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    startActivity(game)
                }
            })
        }

    }
}













