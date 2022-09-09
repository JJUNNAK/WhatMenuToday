package com.example.navigation

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.location.*
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Align
import com.naver.maps.map.overlay.InfoWindow
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.Overlay
import com.naver.maps.map.util.FusedLocationSource
import com.naver.maps.map.util.MarkerIcons


class SnackBar : AppCompatActivity(), OnMapReadyCallback {

    var TAG:String = "로그"

    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mapview3)

        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient("j0prkubkyo")

        // 뷰 역할을 하는 프래그먼트 객체 얻기
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.Walkmap_view3) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.Walkmap_view3, it).commit()
            }

        // 인터페이스 역할을 하는 NaverMap 객체 얻기
        // 프래그먼트(MapFragment)의 getMapAsync() 메서드로 OnMapReadyCallback 을 등록하면 비동기로 NaverMap 객체를 얻을 수 있다고 한다.
        // NaverMap 객체가 준비되면 OnMapReady() 콜백 메서드 호출
        mapFragment.getMapAsync(this)

        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)


    }

    override fun onMapReady(naverMap: NaverMap) {
        Log.d(TAG, "MainActivity - onMapReady")
        this.naverMap = naverMap
        naverMap.locationSource = locationSource
        naverMap.uiSettings.isLocationButtonEnabled = true

        val infoWindow = InfoWindow()
        infoWindow.adapter = object : InfoWindow.DefaultTextAdapter(this) {
            override fun getText(infoWindow: InfoWindow): CharSequence {
                return infoWindow.marker?.tag as CharSequence? ?: ""
            }
        }
        // 지도를 클릭하면 정보 창을 닫음

        // 마커를 클릭하면:
        val listener = Overlay.OnClickListener { overlay ->
            val marker = overlay as Marker

            if (marker.infoWindow == null) {
                // 현재 마커에 정보 창이 열려있지 않을 경우 엶
                infoWindow.open(marker)
            } else {
                // 이미 현재 마커에 정보 창이 열려있을 경우 닫음
                infoWindow.close()
            }

            true
        }


        val marker = Marker()
        marker.icon = MarkerIcons.BLACK
        marker.iconTintColor = Color.BLACK
        marker.position = LatLng(37.5846465, 126.9251874)
        marker.map = naverMap
        marker.setCaptionAligns(Align.Top)
        marker.captionText = "명지 전문대학교"
        marker.width = 60
        marker.height = 80

        val cameraPosition = CameraPosition(
            LatLng(37.5846465, 126.9251874),  // 위치 지정
            15.0 // 줌 레벨
        )
        naverMap.cameraPosition = cameraPosition
        this.naverMap = naverMap


        //분식
        val marker83 = Marker()
        marker83.icon = MarkerIcons.BLACK //분식 마젠타
        marker83.iconTintColor = Color.MAGENTA //분식 마젠타
        marker83.setCaptionAligns(Align.Top)
        marker83.position = LatLng(37.584535, 126.9241684)
        marker83.map = naverMap
        marker83.captionText = "김밥천국"
        marker83.width = 60
        marker83.height = 80
        marker83.tag = "김밥천국"
        marker83.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker83)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EA%B9%80%EB%B0%A5%EC%B2%9C%EA%B5%AD/place/886375920?c=14127141.0320471,4520346.4845091,14,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }

        val marker84 = Marker()
        marker84.icon = MarkerIcons.BLACK //분식 마젠타
        marker84.iconTintColor = Color.MAGENTA //분식 마젠타
        marker84.setCaptionAligns(Align.Top)
        marker84.position = LatLng(37.5805013, 126.9251417)
        marker84.map = naverMap
        marker84.captionText = "봉구스밥버거"
        marker84.width = 60
        marker84.height = 80
        marker84.tag = "봉구스밥버거"

        marker84.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker84)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EB%B4%89%EA%B5%AC%EC%8A%A4%EB%B0%A5%EB%B2%84%EA%B1%B0/place/37891970?c=14127141.0320471,4520346.4845091,14,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }

        val marker85 = Marker()
        marker85.icon = MarkerIcons.BLACK
        marker85.iconTintColor = Color.MAGENTA
        marker85.setCaptionAligns(Align.Top)
        marker85.position = LatLng(37.5819576, 126.9240803)
        marker85.map = naverMap
        marker85.captionText = "응급실떡볶이"
        marker85.width = 60
        marker85.height = 80
        marker85.tag = "응급실떡볶이"
        marker85.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker85)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EC%9D%91%EA%B8%89%EC%8B%A4%EB%96%A1%EB%B3%B6%EC%9D%B4/place/1396516305?c=14128195.9623336,4520543.2804935,15,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }

//여기부터
        val marker86 = Marker()
        marker86.icon = MarkerIcons.BLACK
        marker86.iconTintColor = Color.MAGENTA
        marker86.setCaptionAligns(Align.Top)
        marker86.position = LatLng(37.5817969, 126.9252341)
        marker86.map = naverMap
        marker86.captionText = "쏘울푸드"
        marker86.width = 60
        marker86.height = 80
        marker86.tag = "쏘울푸드"

        marker86.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker86)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EC%8F%98%EC%9A%B8%ED%91%B8%EB%93%9C/place/1887405517?c=14128195.9623336,4520543.2804935,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        val marker87 = Marker()
        marker87.icon = MarkerIcons.BLACK
        marker87.iconTintColor = Color.MAGENTA
        marker87.setCaptionAligns(Align.Top)
        marker87.position = LatLng(37.5818949, 126.9267905)
        marker87.map = naverMap
        marker87.captionText = "엽기떡볶이"
        marker87.width = 60
        marker87.height = 80
        marker87.tag = "엽기떡볶이"

        marker87.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker87)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EC%97%BD%EA%B8%B0%EB%96%A1%EB%B3%B6%EC%9D%B4/place/20818395?c=14128492.8625475,4520536.6362860,15,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }


        val marker88 = Marker()
        marker88.icon = MarkerIcons.BLACK
        marker88.iconTintColor = Color.MAGENTA
        marker88.setCaptionAligns(Align.Top)
        marker88.position = LatLng(337.5813796, 126.9264039)
        marker88.map = naverMap
        marker88.captionText = "오달매"
        marker88.width = 60
        marker88.height = 80
        marker88.tag = "오달매"

        marker88.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker88)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EC%98%A4%EB%8B%AC%EB%A7%A4/place/36517160?c=14128459.0659501,4520464.7021238,15,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }


        val marker89 = Marker()
        marker89.icon = MarkerIcons.BLACK
        marker89.iconTintColor = Color.MAGENTA
        marker89.setCaptionAligns(Align.Top)
        marker89.position = LatLng(37.5811807, 126.9250414)
        marker89.map = naverMap
        marker89.captionText = "신전떡볶이"
        marker89.width = 60
        marker89.height = 80
        marker89.tag = "신전떡볶이"

        marker89.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker89)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EC%8B%A0%EC%A0%84%EB%96%A1%EB%B3%B6%EC%9D%B4/place/36680436?c=14127141.0320471,4520346.4845091,14,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }


        val marker90 = Marker()
        marker90.icon = MarkerIcons.BLACK
        marker90.iconTintColor = Color.MAGENTA
        marker90.setCaptionAligns(Align.Top)
        marker90.position = LatLng(37.5812538, 126.9262461)
        marker90.map = naverMap
        marker90.captionText = "애플토스트"
        marker90.width = 60
        marker90.height = 80
        marker90.tag = "애플토스트"

        marker90.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker90)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EC%95%A0%ED%94%8C%ED%86%A0%EC%8A%A4%ED%8A%B8/place/38275872?c=14128436.0450794,4520440.7241797,15,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }


        val marker91 = Marker()
        marker91.icon = MarkerIcons.BLACK
        marker91.iconTintColor = Color.MAGENTA
        marker91.setCaptionAligns(Align.Top)
        marker91.position = LatLng(37.5843443, 126.9191367)
        marker91.map = naverMap
        marker91.captionText = "떡깨비"
        marker91.width = 60
        marker91.height = 80
        marker91.tag = "떡깨비"

        marker91.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker91)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EB%96%A1%EA%B9%A8%EB%B9%84/place/1137389134?c=14128389.7918310,4520358.5084830,15,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }


        val marker92 = Marker()
        marker92.icon = MarkerIcons.BLACK
        marker92.iconTintColor = Color.MAGENTA
        marker92.setCaptionAligns(Align.Top)
        marker92.position = LatLng(37.5804549, 126.9255276)
        marker92.map = naverMap
        marker92.captionText = "순이네고릴라떡볶이"
        marker92.width = 60
        marker92.height = 80
        marker92.tag = "순이네고릴라떡볶이"

        marker92.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker92)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%88%9C%EC%9D%B4%EB%84%A4%EA%B3%A0%EB%A6%B4%EB%9D%BC%EB%96%A1%EB%B3%B6%EC%9D%B4/place/553841929?c=14128389.7918310,4520358.5084830,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        val marker93 = Marker()
        marker93.icon = MarkerIcons.BLACK
        marker93.iconTintColor = Color.MAGENTA
        marker93.setCaptionAligns(Align.Top)
        marker93.position = LatLng(37.5790517, 126.9239716)
        marker93.map = naverMap
        marker93.captionText = "서호분식"
        marker93.width = 60
        marker93.height = 80
        marker93.tag = "서호분식"

        marker93.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker93)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%84%9C%ED%98%B8%EB%B6%84%EC%8B%9D/place/1214399217?c=14128389.7918310,4520358.5084830,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        val marker95 = Marker()
        marker95.icon = MarkerIcons.BLACK
        marker95.iconTintColor = Color.MAGENTA
        marker95.setCaptionAligns(Align.Top)
        marker95.position = LatLng(37.5791304, 126.9235066)
        marker95.map = naverMap
        marker95.captionText = "이삭토스트"
        marker95.width = 60
        marker95.height = 80
        marker95.tag = "이삭토스트"

        marker95.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker95)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%9D%B4%EC%82%AD%ED%86%A0%EC%8A%A4%ED%8A%B8/place/1902140274?c=14128073.8003244,4520346.4845091,15,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }


        val marker96 = Marker()
        marker96.icon = MarkerIcons.BLACK
        marker96.iconTintColor = Color.MAGENTA
        marker96.setCaptionAligns(Align.Top)
        marker96.position = LatLng(37.5861056, 126.9183232)
        marker96.map = naverMap
        marker96.captionText = "상미김밥"
        marker96.width = 60
        marker96.height = 80
        marker96.tag = "상미김밥"

        marker96.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker96)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%83%81%EB%AF%B8%EA%B9%80%EB%B0%A5/place/688794437?c=14128073.8003244,4520346.4845091,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        val marker97 = Marker()
        marker97.icon = MarkerIcons.BLACK
        marker97.iconTintColor = Color.MAGENTA
        marker97.setCaptionAligns(Align.Top)
        marker97.position = LatLng(37.5780556, 126.9233333)
        marker97.map = naverMap
        marker97.captionText = "이정희 떡볶이"
        marker97.width = 60
        marker97.height = 80
        marker97.tag = "이정희 떡볶이"

        marker97.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker97)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%9D%B4%EC%A0%95%ED%9D%AC%20%EB%96%A1%EB%B3%B6%EC%9D%B4/place/11856504?c=14128073.8003244,4520346.4845091,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        val marker98 = Marker()
        marker98.icon = MarkerIcons.BLACK
        marker98.iconTintColor = Color.MAGENTA
        marker98.setCaptionAligns(Align.Top)
        marker98.position = LatLng(37.5877057, 126.9179162)
        marker98.map = naverMap
        marker98.captionText = "고씨네 빨간오뎅"
        marker98.width = 60
        marker98.height = 80
        marker98.tag = "고씨네 빨간오뎅"

        marker98.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker98)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EA%B3%A0%EC%94%A8%EB%84%A4%20%EB%B9%A8%EA%B0%84%EC%98%A4%EB%8E%85/place/1142392785?c=14127508.4531584,4521352.7113988,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        val marker99 = Marker()
        marker99.icon = MarkerIcons.BLACK
        marker99.iconTintColor = Color.MAGENTA
        marker99.setCaptionAligns(Align.Top)
        marker99.position = LatLng(37.5781382, 126.9227077)
        marker99.map = naverMap
        marker99.captionText = "레드 후라이팬"
        marker99.width = 60
        marker99.height = 80
        marker99.tag = "레드 후라이팬"

        marker99.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker99)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%A0%88%EB%93%9C%20%ED%9B%84%EB%9D%BC%EC%9D%B4%ED%8C%AC/place/19886529?c=14128026.3670894,4520013.6394295,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        val marker101 = Marker()
        marker101.icon = MarkerIcons.BLACK
        marker101.iconTintColor = Color.MAGENTA
        marker101.setCaptionAligns(Align.Top)
        marker101.position = LatLng(37.5780802, 126.9220734)
        marker101.map = naverMap
        marker101.captionText = "마리김밥"
        marker101.width = 60
        marker101.height = 80
        marker101.tag = "마리김밥"

        marker101.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker101)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%A7%88%EB%A6%AC%EA%B9%80%EB%B0%A5/place/1161581650?c=14128026.3670894,4520013.6394295,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker102 = Marker()
        marker102.icon = MarkerIcons.BLACK
        marker102.iconTintColor = Color.MAGENTA
        marker102.setCaptionAligns(Align.Top)
        marker102.position = LatLng(37.5868514, 126.9177112)
        marker102.map = naverMap
        marker102.captionText = "대림손만두"
        marker102.width = 60
        marker102.height = 80
        marker102.tag = "대림손만두"

        marker102.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker102)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EB%8C%80%EB%A6%BC%EC%86%90%EB%A7%8C%EB%91%90/place/1429578529?c=14127468.5005932,4521181.2283550,15,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }

        val marker103 = Marker()
        marker103.icon = MarkerIcons.BLACK
        marker103.iconTintColor = Color.MAGENTA
        marker103.setCaptionAligns(Align.Top)
        marker103.position = LatLng(37.5901084, 126.9189797)
        marker103.map = naverMap
        marker103.captionText = "웁스떡볶이"
        marker103.width = 60
        marker103.height = 80
        marker103.tag = "웁스떡볶이"

        marker103.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker103)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EC%9B%81%EC%8A%A4%EB%96%A1%EB%B3%B6%EC%9D%B4/place/35085069?c=14127623.5352480,4521687.4394556,15,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }

        val marker104 = Marker()
        marker104.icon = MarkerIcons.BLACK
        marker104.iconTintColor = Color.MAGENTA
        marker104.setCaptionAligns(Align.Top)
        marker104.position = LatLng(37.5902205, 126.9186033)
        marker104.map = naverMap
        marker104.captionText = "림분식"
        marker104.width = 60
        marker104.height = 80
        marker104.tag = "림분식"

        marker104.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker104)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EB%A6%BC%EB%B6%84%EC%8B%9D/place/1274477362?c=14127623.5352480,4521687.4394556,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        Log.d(TAG, "MainActivity - onRequestPermissionsResult")
        if (locationSource.onRequestPermissionsResult(requestCode, permissions,
                grantResults)) {
            if (!locationSource.isActivated) { // 권한 거부됨
                Log.d(TAG, "MainActivity - onRequestPermissionsResult 권한 거부됨")
                naverMap.locationTrackingMode = LocationTrackingMode.None
            } else {
                Log.d(TAG, "MainActivity - onRequestPermissionsResult 권한 승인됨")
                naverMap.locationTrackingMode = LocationTrackingMode.Follow // 현위치 버튼 컨트롤 활성
            }
            return
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }

}