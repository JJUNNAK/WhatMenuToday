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


class KoreanFood : AppCompatActivity(), OnMapReadyCallback {

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

//한식
        val marker1 = Marker()
        marker1.setCaptionAligns(Align.Top)
        marker1.captionText = "다래 칼국수"
        marker1.position = LatLng(37.5848274, 126.923294)
        marker1.map = naverMap
        marker1.width = 60
        marker1.height = 80
        marker1.tag = "다래 칼국수"

        marker1.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%8B%A4%EB%9E%98%EC%B9%BC%EA%B5%AD%EC%88%98/place/13150719?c=14128575.5172694,4520946.0706310,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker2 = Marker()
        marker2.setCaptionAligns(Align.Top)
        marker2.position = LatLng(37.5836036, 126.923066)
        marker2.map = naverMap
        marker2.captionText = "미소그릴 한돈"
        marker2.width = 60
        marker2.height = 80
        marker2.tag = "미소그릴 한돈"

        marker2.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker2)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%AF%B8%EC%86%8C%EA%B7%B8%EB%A6%B4%20%ED%95%9C%EB%8F%88/place/1014037406?c=14128575.5172694,4520946.0706310,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker3 = Marker()
        marker3.setCaptionAligns(Align.Top)
        marker3.position = LatLng(37.5824332, 126.9238606)
        marker3.map = naverMap
        marker3.captionText = "닭발상점"
        marker3.width = 60
        marker3.height = 80
        marker3.tag = "닭발상점"

        marker3.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker3)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%8B%AD%EB%B0%9C%EC%83%81%EC%A0%90/place/1530891370?c=14128575.5172694,4520946.0706310,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker4 = Marker()
        marker4.setCaptionAligns(Align.Top)
        marker4.position = LatLng(37.5820381, 126.9236172)
        marker4.map = naverMap
        marker4.captionText = "수인김치찜"
        marker4.width = 60
        marker4.height = 80
        marker4.tag = "수인김치찜"

        marker4.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker4)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EC%88%98%EC%9D%B8%EA%B9%80%EC%B9%98%EC%B0%9C/place/35781718?c=14128575.5172694,4520946.0706310,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker5 = Marker()
        marker5.setCaptionAligns(Align.Top)
        marker5.position = LatLng(37.5815844, 126.9249931)
        marker5.map = naverMap
        marker5.captionText = "생선구이와 돈까스"
        marker5.width = 60
        marker5.height = 80
        marker5.tag = "생선구이와 돈까스"

        marker5.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker5)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%83%9D%EC%84%A0%EA%B5%AC%EC%9D%B4%EC%99%80%20%EB%8F%88%EA%B9%8C%EC%8A%A4/place/774318560?c=14128575.5172694,4520946.0706310,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker6 = Marker()
        marker6.setCaptionAligns(Align.Top)
        marker6.position = LatLng(37.5812859, 126.9259864)
        marker6.map = naverMap
        marker6.captionText = "보리향기"
        marker6.width = 60
        marker6.height = 80
        marker6.tag = "보리향기"

        marker6.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker6)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%B3%B4%EB%A6%AC%ED%96%A5%EA%B8%B0/place/1609774904?c=14128575.5172694,4520946.0706310,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        val marker7 = Marker()
        marker7.setCaptionAligns(Align.Top)
        marker7.position = LatLng(37.5813937, 126.926469)
        marker7.map = naverMap
        marker7.captionText = "소반"
        marker7.width = 60
        marker7.height = 80
        marker7.tag = "소반"

        marker7.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker7)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%86%8C%EB%B0%98?c=14128924.1699146,4520458.7041209,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker8 = Marker()
        marker8.setCaptionAligns(Align.Top)
        marker8.position = LatLng(37.5806391, 126.9258315)
        marker8.map = naverMap
        marker8.captionText = "장수촌"
        marker8.width = 60
        marker8.height = 80
        marker8.tag = "장수촌"

        marker8.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker8)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%9E%A5%EC%88%98%EC%B4%8C?c=14128540.7855883,4520346.4845091,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker9 = Marker()
        marker9.setCaptionAligns(Align.Top)
        marker9.position = LatLng(37.5809097, 126.9257608)
        marker9.map = naverMap
        marker9.captionText = "구공탄"
        marker9.width = 60
        marker9.height = 80
        marker9.tag = "구공탄"

        marker9.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker9)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EA%B5%AC%EA%B3%B5%ED%83%84/place/1039079229?c=14128540.7855883,4520346.4845091,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker10 = Marker()
        marker10.setCaptionAligns(Align.Top)
        marker10.position = LatLng(37.5806071, 126.9252993)
        marker10.map = naverMap
        marker10.captionText = "육쌈냉면"
        marker10.width = 60
        marker10.height = 80
        marker10.tag = "육쌈냉면"

        marker10.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker10)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%9C%A1%EC%8C%88%EB%83%89%EB%A9%B4/place/1933266163?c=14128540.7855883,4520346.4845091,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker11 = Marker()
        marker11.setCaptionAligns(Align.Top)
        marker11.position = LatLng(37.5842382, 126.9292432)
        marker11.map = naverMap
        marker11.captionText = "백년약수골"
        marker11.width = 60
        marker11.height = 80
        marker11.tag = "백년약수골"

        marker11.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker11)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%B0%B1%EB%85%84%EC%95%BD%EC%88%98%EA%B3%A8/place/18756106?c=14129326.3672348,4520742.4260672,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker13 = Marker()
        marker13.setCaptionAligns(Align.Top)
        marker13.position = LatLng(37.5791191, 126.9247461)
        marker13.map = naverMap
        marker13.captionText = "봉구네 가마솥순대국"
        marker13.width = 60
        marker13.height = 80
        marker13.tag = "봉구네 가마솥순대국"

        marker13.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker13)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EA%B0%80%EB%A7%88%EC%86%A5%EC%88%9C%EB%8C%80%EA%B5%AD?c=14128733.6911339,4520147.5431248,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker14 = Marker()
        marker14.setCaptionAligns(Align.Top)
        marker14.position = LatLng(37.5788861, 126.9236966)
        marker14.map = naverMap
        marker14.captionText = "만득이네 두루치기"
        marker14.width = 60
        marker14.height = 80
        marker14.tag = "만득이네 두루치기"

        marker14.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker14)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%A7%8C%EB%93%9D%EC%9D%B4%EB%84%A4%20%EB%91%90%EB%A3%A8%EC%B9%98%EA%B8%B0/place/31806559?c=14128733.6911339,4520147.5431248,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker15 = Marker()
        marker15.setCaptionAligns(Align.Top)
        marker15.position = LatLng(37.5871762, 126.9442206)
        marker15.map = naverMap
        marker15.captionText = "여리네 닭갈비"
        marker15.width = 60
        marker15.height = 80
        marker15.tag = "여리네 닭갈비"

        marker15.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker15)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%97%AC%EB%A6%AC%EB%84%A4%20%EB%8B%AD%EA%B0%88%EB%B9%84?c=14128687.8163717,4520089.6439286,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker16 = Marker()
        marker16.setCaptionAligns(Align.Top)
        marker16.position = LatLng(37.5780169, 126.92304)
        marker16.map = naverMap
        marker16.captionText = "들향기가"
        marker16.width = 60
        marker16.height = 80
        marker16.tag = "들향기가"

        marker16.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker16)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%93%A4%ED%96%A5%EA%B8%B0%EA%B0%80/place/36721134?c=14128687.8163717,4520089.6439286,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker17 = Marker()
        marker17.setCaptionAligns(Align.Top)
        marker17.position = LatLng(37.5781483, 126.9228789)
        marker17.map = naverMap
        marker17.captionText = "군산식당"
        marker17.width = 60
        marker17.height = 80
        marker17.tag = "군산식당"

        marker17.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker17)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EA%B5%B0%EC%82%B0%EC%8B%9D%EB%8B%B9?c=14128536.7892185,4520006.5320328,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker18 = Marker()
        marker18.setCaptionAligns(Align.Top)
        marker18.position = LatLng(37.586990, 126.917392)
        marker18.map = naverMap
        marker18.captionText = "불티나 이모네전"
        marker18.width = 60
        marker18.height = 80
        marker18.tag = "불티나 이모네전"

        marker18.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker18)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%B6%88%ED%8B%B0%EB%82%98%20%EC%9D%B4%EB%AA%A8%EB%84%A4%EC%A0%84/place/1814735805?c=14127914.9919388,4521241.8869820,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker19 = Marker()
        marker19.setCaptionAligns(Align.Bottom)
        marker19.position = LatLng(37.587480, 126.916940)
        marker19.map = naverMap
        marker19.captionText = "원조 이화 감자국"
        marker19.width = 60
        marker19.height = 80
        marker19.tag = "원조 이화 감자국"

        marker19.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker19)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%9B%90%EC%A1%B0%20%EC%9D%B4%ED%99%94%20%EA%B0%90%EC%9E%90%EA%B5%AD/place/11601101?c=14127914.9919388,4521241.8869820,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker20 = Marker()
        marker20.setCaptionAligns(Align.Bottom)
        marker20.position = LatLng(37.5872222, 126.9166667)
        marker20.map = naverMap
        marker20.captionText = "태조대림감자국"
        marker20.width = 60
        marker20.height = 80
        marker20.tag = "태조대림감자국"

        marker20.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker20)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%ED%83%9C%EC%A1%B0%EB%8C%80%EB%A6%BC%EA%B0%90%EC%9E%90%EA%B5%AD/place/11601857?c=14127914.9919388,4521241.8869820,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker21 = Marker()
        marker21.setCaptionAligns(Align.Bottom)
        marker21.position = LatLng(37.587390, 126.916802)
        marker21.map = naverMap
        marker21.captionText = "시골감자국"
        marker21.width = 60
        marker21.height = 80
        marker21.tag = "시골감자국"

        marker21.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker21)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%8B%9C%EA%B3%A8%EA%B0%90%EC%9E%90%EA%B5%AD/place/11816284?c=14127914.9919388,4521241.8869820,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker22 = Marker()
        marker22.setCaptionAligns(Align.Bottom)
        marker22.position = LatLng(37.5871423, 126.916836)
        marker22.map = naverMap
        marker22.captionText = "불맛감자국"
        marker22.width = 60
        marker22.height = 80
        marker22.tag = "불맛감자국"

        marker22.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker22)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%B6%88%EB%A7%9B%EA%B0%90%EC%9E%90%EA%B5%AD/place/12068162?c=14127914.9919388,4521241.8869820,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker23 = Marker()
        marker23.setCaptionAligns(Align.Top)
        marker23.position = LatLng(37.587418, 126.916913)
        marker23.map = naverMap
        marker23.captionText = "홍두깨손칼국수"
        marker23.width = 60
        marker23.height = 80
        marker23.tag = "홍두깨손칼국수"

        marker23.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker23)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%ED%99%8D%EB%91%90%EA%B9%A8%EC%86%90%EC%B9%BC%EA%B5%AD%EC%88%98/place/96924958?c=14127914.9919388,4521241.8869820,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker24 = Marker()
        marker24.setCaptionAligns(Align.Bottom)
        marker24.position = LatLng(37.587964, 126.917459)
        marker24.map = naverMap
        marker24.captionText = "옹심이메밀칼국수"
        marker24.width = 60
        marker24.height = 80
        marker24.tag = "옹심이메밀칼국수"

        marker24.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker24)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%98%B9%EC%8B%AC%EC%9D%B4%EB%A9%94%EB%B0%80%EC%B9%BC%EA%B5%AD%EC%88%98/place/1572498316?c=14127914.9919388,4521241.8869820,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker25 = Marker()
        marker25.setCaptionAligns(Align.Top)
        marker25.position = LatLng(37.587940, 126.917422)
        marker25.map = naverMap
        marker25.captionText = "옛날토답집"
        marker25.width = 60
        marker25.height = 80

        marker25.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker25)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%98%9B%EB%82%A0%ED%86%A0%EB%8B%B4%EC%A7%91/place/13575328?c=14127914.9919388,4521241.8869820,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker26 = Marker()
        marker26.setCaptionAligns(Align.Top)
        marker26.position = LatLng(37.4949704, 126.7644113)
        marker26.map = naverMap
        marker26.captionText = "땅스부대찌개"
        marker26.width = 60
        marker26.height = 80

        marker26.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker26)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%95%85%EC%8A%A4%EB%B6%80%EB%8C%80%EC%B0%8C%EA%B0%9C?c=14127919.2220795,4521407.9765425,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker27 = Marker()
        marker27.setCaptionAligns(Align.Top)
        marker27.position = LatLng(37.588255, 126.9179841)
        marker27.map = naverMap
        marker27.captionText = "대림팥칼국수"
        marker27.width = 60
        marker27.height = 80

        marker27.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker27)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%8C%80%EB%A6%BC%ED%8C%A5%EC%B9%BC%EA%B5%AD%EC%88%98/place/20933828?c=14127919.2220795,4521407.9765425,15,0,0,0,dh&isCorrectAnswer=true")
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