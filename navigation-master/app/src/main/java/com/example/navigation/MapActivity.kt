package com.example.navigation

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.*

import com.naver.maps.map.util.FusedLocationSource
import com.naver.maps.map.util.MarkerIcons

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    var TAG:String = "로그"

    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mapview)

        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient("j0prkubkyo")

        // 뷰 역할을 하는 프래그먼트 객체 얻기
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.Walkmap_view) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.Walkmap_view, it).commit()
            }

        // 인터페이스 역할을 하는 NaverMap 객체 얻기
        // 프래그먼트(MapFragment)의 getMapAsync() 메서드로 OnMapReadyCallback 을 등록하면 비동기로 NaverMap 객체를 얻을 수 있다고 한다.
        // NaverMap 객체가 준비되면 OnMapReady() 콜백 메서드 호출
        mapFragment.getMapAsync(this)

        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)


    }

    override fun onMapReady(naverMap: NaverMap) {
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

        Log.d(TAG, "MainActivity - onMapReady")
        this.naverMap = naverMap
        naverMap.locationSource = locationSource
        naverMap.uiSettings.isLocationButtonEnabled = true


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


        //중식

        val marker28 = Marker()
        marker28.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker28.iconTintColor = Color.RED //중식 마커 빨강색
        marker28.setCaptionAligns(Align.Top)
        marker28.position = LatLng(37.5846694, 126.9240447)
        marker28.map = naverMap
        marker28.captionText = "신흥대반점"
        marker28.width = 60
        marker28.height = 80
        marker28.tag = "신흥대반점"
        marker28.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EC%8B%A0%ED%9D%A5%EB%8C%80%EB%B0%98%EC%A0%90/place/13150732?c=14129790.3802683,4520290.3259915,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker29 = Marker()
        marker29.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker29.iconTintColor = Color.RED //중식 마커 빨강색
        marker29.setCaptionAligns(Align.Top)
        marker29.position = LatLng(37.5831877, 126.9234127)
        marker29.map = naverMap
        marker29.captionText = "진짜루"
        marker29.width = 60
        marker29.height = 80
        marker29.tag = "진짜루"
        marker29.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%A7%84%EC%A7%9C%EB%A3%A8/place/13150826?c=14129790.3802683,4520290.3259915,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker30 = Marker()
        marker30.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker30.iconTintColor = Color.RED //중식 마커 빨강색
        marker30.setCaptionAligns(Align.Top)
        marker30.position = LatLng(37.5819241, 126.9244567)
        marker30.map = naverMap
        marker30.captionText = "탕화쿵푸마라탕"
        marker30.width = 60
        marker30.height = 80
        marker30.tag = "탕화쿵푸마라탕"
        marker30.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%ED%83%95%ED%99%94%EC%BF%B5%ED%91%B8%EB%A7%88%EB%9D%BC%ED%83%95%20%EB%AA%85%EC%A7%80%EB%8C%80/place/1802590743?c=14128703.7907186,4520536.0463143,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }
        val marker31 = Marker()
        marker31.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker31.iconTintColor = Color.RED //중식 마커 빨강색
        marker31.setCaptionAligns(Align.Top)
        marker31.position = LatLng(37.5816024, 126.9252403)
        marker31.map = naverMap
        marker31.captionText = "수해복마라탕"
        marker31.width = 60
        marker31.height = 80
        marker31.tag = "수해복마라탕"
        marker31.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EC%88%98%ED%95%B4%EB%B3%B5%EB%A7%88%EB%9D%BC%ED%83%95%20%EB%AA%85%EC%A7%80%EB%8C%80/place/1921509975?c=14128703.7907186,4520536.0463143,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker32 = Marker()
        marker32.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker32.iconTintColor = Color.RED //중식 마커 빨강색
        marker32.setCaptionAligns(Align.Top)
        marker32.position = LatLng(37.5810288, 126.925878)
        marker32.map = naverMap
        marker32.captionText = "왕가주방"
        marker32.width = 60
        marker32.height = 80
        marker32.tag = "왕가주방"
        marker32.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EC%99%95%EA%B0%80%EC%A3%BC%EB%B0%A9%20%EB%AA%85%EC%A7%80%EB%8C%80/place/1314671448?c=14128790.5531298,4520493.8353296,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker33 = Marker()
        marker33.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker33.iconTintColor = Color.RED //중식 마커 빨강색
        marker33.setCaptionAligns(Align.Top)
        marker33.position = LatLng(37.580787, 126.9255463)
        marker33.map = naverMap
        marker33.captionText = "마라왕마라탕"
        marker33.width = 60
        marker33.height = 80
        marker33.tag = "마라왕마라탕"
        marker33.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%A7%88%EB%9D%BC%EC%99%95%EB%A7%88%EB%9D%BC%ED%83%95%20%EB%AA%85%EC%A7%80%EB%8C%80/place/1155499389?c=14128790.5531298,4520493.8353296,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker34 = Marker()
        marker34.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker34.iconTintColor = Color.RED //중식 마커 빨강색
        marker34.setCaptionAligns(Align.Top)
        marker34.position = LatLng(37.5603783, 126.9772643)
        marker34.map = naverMap
        marker34.captionText = "다복향 마라탕"
        marker34.width = 60
        marker34.height = 80
        marker34.tag = "다복향 마라탕"
        marker34.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%8B%A4%EB%B3%B5%ED%96%A5%20%EB%A7%88%EB%9D%BC%ED%83%95%20%EB%AA%85%EC%A7%80%EB%8C%80/place/1294254055?c=14128790.5531298,4520493.8353296,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker35 = Marker()
        marker35.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker35.iconTintColor = Color.RED //중식 마커 빨강색
        marker35.setCaptionAligns(Align.Top)
        marker35.position = LatLng(37.5796657, 126.9250123)
        marker35.map = naverMap
        marker35.captionText = "웨이"
        marker35.width = 60
        marker35.height = 80
        marker35.tag = "웨이"
        marker35.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EC%9B%A8%EC%9D%B4%20%EB%AA%85%EC%A7%80%EB%8C%80/place/1656856925?c=14128765.2836053,4520225.4167851,15,0,0,0,dh")
            startActivity(openURL)
            true
        }

        val marker36 = Marker()
        marker36.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker36.iconTintColor = Color.RED //중식 마커 빨강색
        marker36.setCaptionAligns(Align.Top)
        marker36.position = LatLng(37.5796449, 126.9245993)
        marker36.map = naverMap
        marker36.captionText = "청춘불뽕"
        marker36.width = 60
        marker36.height = 80
        marker36.tag = "청춘불뽕"
        marker36.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EC%B2%AD%EC%B6%98%EB%B6%88%EB%BD%95%20%EB%AA%85%EC%A7%80%EB%8C%80/place/35756677?c=14128765.2836053,4520225.4167851,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker37 = Marker()
        marker37.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker37.iconTintColor = Color.RED //중식 마커 빨강색
        marker37.setCaptionAligns(Align.Top)
        marker37.position = LatLng(37.5795609, 126.9244782)
        marker37.map = naverMap
        marker37.captionText = "명보성"
        marker37.width = 60
        marker37.height = 80
        marker37.tag = "명보성"
        marker37.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EB%B3%B4%EC%84%B1%20%EB%AA%85%EC%A7%80%EB%8C%80/place/18277579?c=14128765.2836053,4520225.4167851,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker38 = Marker()
        marker38.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker38.iconTintColor = Color.RED //중식 마커 빨강색
        marker38.setCaptionAligns(Align.Top)
        marker38.position = LatLng(37.5788815, 126.9238812)
        marker38.map = naverMap
        marker38.captionText = "세아짬뽕"
        marker38.width = 60
        marker38.height = 80
        marker37.tag = "세아짬뽕"
        marker37.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EC%84%B8%EC%95%84%EC%A7%AC%EB%BD%95%20%EB%AA%85%EC%A7%80%EB%8C%80/place/1606578305?c=14128765.2836053,4520225.4167851,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker39 = Marker()
        marker39.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker39.iconTintColor = Color.RED //중식 마커 빨강색
        marker39.setCaptionAligns(Align.Top)
        marker39.position = LatLng(37.578438, 126.8949889)
        marker39.map = naverMap
        marker39.captionText = "쏘핫마라탕마라샹궈"
        marker39.width = 60
        marker39.height = 80
        marker39.tag = "쏘핫마라탕마라샹궈"
        marker39.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EC%8F%98%ED%95%AB%EB%A7%88%EB%9D%BC%ED%83%95%EB%A7%88%EB%9D%BC%EC%83%B9%EA%B6%88%20%EB%AA%85%EC%A7%80%EB%8C%80/place/1412759026?c=14128784.7645162,4520206.0325947,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker40 = Marker()
        marker40.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker40.iconTintColor = Color.RED //중식 마커 빨강색
        marker40.setCaptionAligns(Align.Top)
        marker40.position = LatLng(37.58759, 126.918833)
        marker40.map = naverMap
        marker40.captionText = "만복래반점"
        marker40.height = 80
        marker40.width = 60
        marker40.tag = "만복래반점"
        marker40.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%A7%8C%EB%B3%B5%EB%9E%98%EB%B0%98%EC%A0%90%20%EB%AA%85%EC%A7%80%EB%8C%80/place/18112373?c=14127606.8484564,4521330.7402841,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker42 = Marker()
        marker42.icon = MarkerIcons.BLACK    //중식 마커 빨강색
        marker42.iconTintColor = Color.RED //중식 마커 빨강색
        marker42.setCaptionAligns(Align.Top)
        marker42.position = LatLng(37.5760537, 126.9241393)
        marker42.map = naverMap
        marker42.captionText = "락희안"
        marker42.width = 60
        marker42.height = 80
        marker42.tag = "락희안"
        marker42.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker1)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%9D%BD%ED%9D%AC%EC%95%88%20%EB%AA%85%EC%A7%80%EB%8C%80/place/1378496863?c=14129790.3802683,4520290.3259915,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        //일식
        val marker43 = Marker()
        marker43.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker43.iconTintColor = Color.YELLOW  //일식 마커 노랑색
        marker43.setCaptionAligns(Align.Top)
        marker43.position = LatLng(37.5814142, 126.9248637)
        marker43.map = naverMap
        marker43.captionText = "스시하나에"
        marker43.width = 60
        marker43.height = 80
        marker43.tag = "스시하나에"
        marker43.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker43)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%8A%A4%EC%8B%9C%ED%95%98%EB%82%98%EC%97%90/place/38299775?c=14129216.3598494,4520472.7470023,13,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker44 = Marker()
        marker44.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker44.iconTintColor = Color.YELLOW
        marker44.setCaptionAligns(Align.Top)
        marker44.position = LatLng(37.5831877, 126.9234127)
        marker44.map = naverMap
        marker44.captionText = "가타쯔무리"
        marker44.width = 60
        marker44.height = 80
        marker44.tag = "가타쯔무리"
        marker44.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker44)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EA%B0%80%ED%83%80%EC%AF%94%EB%AC%B4%EB%A6%AC/place/36351814?c=14129216.3598494,4520472.7470023,13,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker45 = Marker()
        marker45.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker45.iconTintColor = Color.YELLOW
        marker45.setCaptionAligns(Align.Top)
        marker45.position = LatLng(37.5823971, 126.9254428)
        marker45.map = naverMap
        marker45.captionText = "여기돈까스"
        marker45.width = 60
        marker45.height = 80
        marker45.tag = "여기돈까스"
        marker45.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker45)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%97%AC%EA%B8%B0%EB%8F%88%EA%B9%8C%EC%8A%A4/place/1406843223?c=14129216.3598494,4520472.7470023,13,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        val marker46 = Marker()
        marker46.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker46.iconTintColor = Color.YELLOW
        marker46.setCaptionAligns(Align.Top)
        marker46.position = LatLng(37.5832798, 126.9231295)
        marker46.map = naverMap
        marker46.captionText = "소소식탁"
        marker46.width = 60
        marker46.height = 80
        marker46.tag = "소소식탁"
        marker46.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker46)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%86%8C%EC%86%8C%EC%8B%9D%ED%83%81/place/1380694865?c=14128086.1790518,4520731.8063725,15,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }

        val marker47 = Marker()
        marker47.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker47.iconTintColor = Color.YELLOW
        marker47.setCaptionAligns(Align.Top)
        marker47.position = LatLng(37.5666478, 126.9314925)
        marker47.map = naverMap
        marker47.captionText = "긴자료코"
        marker47.width = 60
        marker47.height = 80
        marker47.tag = "긴자료코"
        marker47.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker47)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EA%B8%B4%EC%9E%90%EB%A3%8C%EC%BD%94/place/1122448171?c=14127141.0320471,4520346.4845091,14,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }

        val marker48 = Marker()
        marker48.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker48.iconTintColor = Color.YELLOW
        marker48.setCaptionAligns(Align.Top)
        marker48.position = LatLng(37.5786389, 126.9235643)
        marker48.map = naverMap
        marker48.captionText = "아쯔다무라"
        marker48.width = 60
        marker48.height = 80
        marker48.tag = "아쯔다무라"
        marker48.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker48)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EC%95%84%EC%AF%94%EB%8B%A4%EB%AC%B4%EB%9D%BC/place/1988507137?c=14127141.0320471,4520346.4845091,14,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker49 = Marker()
        marker49.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker49.iconTintColor = Color.YELLOW
        marker49.setCaptionAligns(Align.Top)
        marker49.position = LatLng(37.5815418, 126.9249173)
        marker49.map = naverMap
        marker49.captionText = "생선구이와 돈까스"
        marker49.width = 60
        marker49.height = 80
        marker49.tag = "생선구이와 돈까스"
        marker49.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker49)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%83%9D%EC%84%A0%EA%B5%AC%EC%9D%B4%EC%99%80%20%EB%8F%88%EA%B9%8C%EC%8A%A4/place/774318560?c=14128137.6086565,4520075.7240095,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker50 = Marker()
        marker50.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker50.iconTintColor = Color.YELLOW
        marker50.setCaptionAligns(Align.Top)
        marker50.position = LatLng(37.5791362, 126.923587)
        marker50.map = naverMap
        marker50.captionText = "나라비"
        marker50.width = 60
        marker50.height = 80
        marker50.tag = "나라비"
        marker50.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker50)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%82%98%EB%9D%BC%EB%B9%84/place/33876033?c=14128137.6086565,4520075.7240095,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        val marker52 = Marker()
        marker52.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker52.iconTintColor = Color.YELLOW
        marker52.setCaptionAligns(Align.Top)
        marker52.position = LatLng(37.5792142, 126.9240021)
        marker52.map = naverMap
        marker52.captionText = "화전"
        marker52.width = 60
        marker52.height = 80
        marker52.tag = "화전"
        marker52.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker52)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%ED%99%94%EC%A0%84/place/1057511754?c=14127448.0066749,4521241.8869820,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        val marker12 = Marker()
        marker12.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker12.iconTintColor = Color.YELLOW
        marker12.setCaptionAligns(Align.Top)
        marker12.position = LatLng(37.5823971, 126.9254428)
        marker12.map = naverMap
        marker12.captionText = "고씨네"
        marker12.width = 60
        marker12.height = 80
        marker12.tag = "고씨네"

        marker12.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker12)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EA%B3%A0%EC%94%A8%EB%84%A4/place/37021202?c=14128341.3121927,4520603.4156797,15,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }

        val marker54 = Marker()
        marker54.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker54.iconTintColor = Color.YELLOW
        marker54.setCaptionAligns(Align.Top)
        marker54.position = LatLng(37.5817969, 126.9252341)
        marker54.map = naverMap
        marker54.captionText = "도쿄총각"
        marker54.width = 60
        marker54.height = 80
        marker54.tag = "도쿄총각"

        marker54.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker54)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%8F%84%EC%BF%84%EC%B4%9D%EA%B0%81/place/1462072082?c=14128341.3121927,4520603.4156797,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker55 = Marker()
        marker55.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker55.iconTintColor = Color.YELLOW
        marker55.setCaptionAligns(Align.Top)
        marker55.position = LatLng(37.5789687, 126.9235686)
        marker55.map = naverMap
        marker55.captionText = "오빠네초밥"
        marker55.width = 60
        marker55.height = 80
        marker55.tag = "오빠네초밥"

        marker55.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker55)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%98%A4%EB%B9%A0%EB%84%A4%EC%B4%88%EB%B0%A5/place/1741097867?c=14128341.3121927,4520603.4156797,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker56 = Marker()
        marker56.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker56.iconTintColor = Color.YELLOW
        marker56.setCaptionAligns(Align.Top)
        marker56.position = LatLng(37.5878777, 126.9201726)
        marker56.map = naverMap
        marker56.captionText = "히카리우동"
        marker56.width = 60
        marker56.height = 80
        marker56.tag = "히카리우동"

        marker56.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker56)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%ED%9E%88%EC%B9%B4%EB%A6%AC%EC%9A%B0%EB%8F%99/place/38676249?c=14128341.3121927,4520603.4156797,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker57 = Marker()
        marker57.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker57.iconTintColor = Color.YELLOW
        marker57.setCaptionAligns(Align.Top)
        marker57.position = LatLng(37.5874469, 126.9202116)
        marker57.map = naverMap
        marker57.captionText = "정거장뒤"
        marker57.width = 60
        marker57.height = 80
        marker57.tag = "정거장뒤"

        marker57.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker57)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%A0%95%EA%B1%B0%EC%9E%A5%EB%92%A4/place/1389150767?c=14128341.3121927,4520603.4156797,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker58 = Marker()
        marker58.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker58.iconTintColor = Color.YELLOW
        marker58.setCaptionAligns(Align.Top)
        marker58.position = LatLng(37.579911, 126.9252204)
        marker58.map = naverMap
        marker58.captionText = "두번째부엌"
        marker58.width = 60
        marker58.height = 80
        marker58.tag = "두번째부엌"
        marker58.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker58)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EB%91%90%EB%B2%88%EC%A7%B8%EB%B6%80%EC%97%8C/place/1490082624?c=14128341.3121927,4520603.4156797,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker59 = Marker()
        marker59.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker59.iconTintColor = Color.YELLOW
        marker59.setCaptionAligns(Align.Top)
        marker59.position = LatLng(37.5813475, 126.9250571)
        marker59.map = naverMap
        marker59.captionText = "인라면"
        marker59.width = 60
        marker59.height = 80
        marker59.tag = "인라면"
        marker59.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker59)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EC%9D%B8%EB%9D%BC%EB%A9%B4/place/34678368?c=14128341.3121927,4520603.4156797,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker60 = Marker()
        marker60.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker60.iconTintColor = Color.YELLOW
        marker60.setCaptionAligns(Align.Top)
        marker60.position = LatLng(37.5810246, 126.9265087)
        marker60.map = naverMap
        marker60.captionText = "정수산"
        marker60.width = 60
        marker60.height = 80
        marker60.tag = "정수산"
        marker60.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker60)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EC%A0%95%EC%88%98%EC%82%B0/place/1332300628?c=14127212.8776465,4519033.3137703,15,0,0,0,dh&entry=plt&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }

        val marker61 = Marker()
        marker61.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker61.iconTintColor = Color.YELLOW
        marker61.setCaptionAligns(Align.Top)
        marker61.position = LatLng(37.5792142, 126.9240021)
        marker61.map = naverMap
        marker61.captionText = "네코노키친"
        marker61.width = 60
        marker61.height = 80
        marker61.tag = "네코노키친"
        marker61.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker61)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EB%84%A4%EC%BD%94%EB%85%B8%ED%82%A4%EC%B9%9C/place/36342590?c=14128185.6207529,4520159.7775666,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker62 = Marker()
        marker62.icon = MarkerIcons.BLACK       //일식 마커 노랑색
        marker62.iconTintColor = Color.YELLOW
        marker62.setCaptionAligns(Align.Top)
        marker62.position = LatLng(37.5817854, 126.9243681)
        marker62.map = naverMap
        marker62.captionText = "완숙"
        marker62.width = 60
        marker62.height = 80
        marker62.tag = "완숙"
        marker62.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker62)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%EC%99%84%EC%88%99/place/851692816?c=14128185.6207529,4520159.7775666,15,0,0,0,dh&entry=plt&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        //양식

        val marker63 = Marker()
        marker63.icon = MarkerIcons.BLACK //양식 마커 파랑색
        marker63.iconTintColor = Color.BLUE //양식 마커 파랑색
        marker63.setCaptionAligns(Align.Top)
        marker63.position = LatLng(37.5825997, 126.9259677)
        marker63.map = naverMap
        marker63.captionText = "쏘렌토"
        marker63.width = 60
        marker63.height = 80

        marker63.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker63)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%8F%98%EB%A0%8C%ED%86%A0/place/18753190?c=14127475.2799502,4520644.8545166,14,0,0,0,dh&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }

        val marker64 = Marker()
        marker64.icon = MarkerIcons.BLACK
        marker64.iconTintColor = Color.BLUE
        marker64.setCaptionAligns(Align.Top)
        marker64.position = LatLng(37.5836073, 126.9217933)
        marker64.map = naverMap
        marker64.captionText = "비스트로아느로"
        marker64.width = 60
        marker64.height = 80

        marker64.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker64)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%B9%84%EC%8A%A4%ED%8A%B8%EB%A1%9C%EC%95%84%EB%8A%90%EB%A1%9C/place/36943894?c=14127475.2799502,4520644.8545166,14,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker65 = Marker()
        marker65.icon = MarkerIcons.BLACK
        marker65.iconTintColor = Color.BLUE
        marker65.setCaptionAligns(Align.Top)
        marker65.position = LatLng(37.5794693, 126.9249086)
        marker65.map = naverMap
        marker65.captionText = "주인백파스타"
        marker65.width = 60
        marker65.height = 80

        marker65.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker65)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%A3%BC%EC%9D%B8%EB%B0%B1%ED%8C%8C%EC%8A%A4%ED%83%80/place/31161270?c=14127475.2799502,4520644.8545166,14,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker66 = Marker()
        marker66.icon = MarkerIcons.BLACK
        marker66.iconTintColor = Color.BLUE
        marker66.setCaptionAligns(Align.Top)
        marker66.position = LatLng(37.5817745, 126.9244147)
        marker66.captionText = "BISTRO35"
        marker66.map = naverMap
        marker66.width = 60
        marker66.height = 80

        marker66.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker66)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20BISTRO35/place/1046679100?c=14128228.7904514,4520517.2093780,15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }


        val marker67 = Marker()
        marker67.icon = MarkerIcons.BLACK
        marker67.iconTintColor = Color.BLUE
        marker67.setCaptionAligns(Align.Top)
        marker67.position = LatLng(37.5811807, 126.9250414)
        marker67.map = naverMap
        marker67.captionText = "위더스"
        marker67.width = 60
        marker67.height = 80
        marker67.tag = "위더스"

        marker67.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker67)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%9C%84%EB%8D%94%EC%8A%A4/place/1018893325?c=14128295.7268612,4520436.8332121,15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }

        val marker68 = Marker()
        marker68.icon = MarkerIcons.BLACK
        marker68.iconTintColor = Color.BLUE
        marker68.setCaptionAligns(Align.Top)
        marker68.position = LatLng(37.5791717, 126.9255673)
        marker68.map = naverMap
        marker68.captionText = "꾸오레베로"
        marker68.width = 60
        marker68.height = 80
        marker68.tag = "꾸오레베로"

        marker68.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker68)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EA%BE%B8%EC%98%A4%EB%A0%88%EB%B2%A0%EB%A1%9C/place/983172457?c=14128354.0248786,4520146.8969894,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker69 = Marker()
        marker69.icon = MarkerIcons.BLACK
        marker69.iconTintColor = Color.BLUE
        marker69.setCaptionAligns(Align.Top)
        marker69.position = LatLng(37.5812559, 126.924498)
        marker69.map = naverMap
        marker69.captionText = "리코부리또"
        marker69.width = 60
        marker69.height = 80
        marker69.tag = "리코부리또"

        marker69.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker69)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%A6%AC%EC%BD%94%EB%B6%80%EB%A6%AC%EB%98%90/place/1417547113?c=14128354.0248786,4520146.8969894,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker70 = Marker()
        marker70.icon = MarkerIcons.BLACK
        marker70.iconTintColor = Color.BLUE
        marker70.setCaptionAligns(Align.Top)
        marker70.position = LatLng(37.5792116, 126.9245275)
        marker70.map = naverMap
        marker70.captionText = "포크"
        marker70.width = 60
        marker70.height = 80
        marker70.tag = "포크"

        marker70.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker70)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%ED%8F%AC%ED%81%AC/place/1589959360?c=14128243.2397213,4520153.8780636,15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }

        val marker71 = Marker()
        marker71.icon = MarkerIcons.BLACK
        marker71.iconTintColor = Color.BLUE
        marker71.setCaptionAligns(Align.Top)
        marker71.position = LatLng(37.5776772, 126.9243242)
        marker71.map = naverMap
        marker71.captionText = "밀"
        marker71.width = 60
        marker71.height = 80
        marker71.tag = "밀"

        marker71.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker71)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%B0%80/place/1829507635?c=14125419.4093303,4519941.0346495,13,0,0,0,dh")
            startActivity(openURL)
            true
        }

        val marker72 = Marker()
        marker72.icon = MarkerIcons.BLACK
        marker72.iconTintColor = Color.BLUE
        marker72.setCaptionAligns(Align.Top)
        marker72.position = LatLng(37.5776366, 126.926596)
        marker72.map = naverMap
        marker72.captionText = "어라우즈"
        marker72.width = 60
        marker72.height = 80
        marker69.tag = "어라우즈"

        marker72.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker72)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%96%B4%EB%9D%BC%EC%9A%B0%EC%A6%88/place/1678054540?c=14125674.8652978,4519927.7610501,13,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker73 = Marker()
        marker73.icon = MarkerIcons.BLACK
        marker73.iconTintColor = Color.BLUE
        marker73.setCaptionAligns(Align.Top)
        marker73.position = LatLng(37.5813352, 126.9250512)
        marker73.map = naverMap
        marker73.captionText = "왕창"
        marker73.width = 60
        marker73.height = 80
        marker73.tag = "왕창"

        marker73.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker73)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%99%95%EC%B0%BD/place/1534874569?c=14125674.8652978,4519927.7610501,13,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker74 = Marker()
        marker74.icon = MarkerIcons.BLACK
        marker74.iconTintColor = Color.BLUE
        marker74.setCaptionAligns(Align.Top)
        marker74.position = LatLng(37.5779588, 126.9259527)
        marker74.map = naverMap
        marker74.captionText = "라스투어"
        marker74.width = 60
        marker74.height = 80
        marker74.tag = "라스투어"

        marker74.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker74)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EB%9D%BC%EC%8A%A4%ED%88%AC%EC%96%B4/place/1997582936?c=14125604.9455256,4519981.5719050,13,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker75 = Marker()
        marker75.icon = MarkerIcons.BLACK
        marker75.iconTintColor = Color.BLUE
        marker75.setCaptionAligns(Align.Top)
        marker75.position = LatLng(37.5782305, 126.9231445)
        marker75.map = naverMap
        marker75.captionText = "UNCLE LEE"
        marker75.width = 60
        marker75.height = 80
        marker75.tag = "UNCLE LEE"

        marker75.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker75)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20UNCLE%20LEE/place/1163911610?c=14125604.9455256,4519981.5719050,13,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker76 = Marker()
        marker76.icon = MarkerIcons.BLACK
        marker76.iconTintColor = Color.BLUE
        marker76.setCaptionAligns(Align.Top)
        marker76.position = LatLng(37.582819, 126.9190467)
        marker76.map = naverMap
        marker76.captionText = "신대방미쓰리"
        marker76.width = 60
        marker76.height = 80
        marker76.tag = "신대방미쓰리"

        marker76.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker76)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%EC%8B%A0%EB%8C%80%EB%B0%A9%EB%AF%B8%EC%93%B0%EB%A6%AC/place/37420778?c=14125604.9455256,4519981.5719050,13,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker77 = Marker()
        marker77.icon = MarkerIcons.BLACK
        marker77.iconTintColor = Color.BLUE
        marker77.setCaptionAligns(Align.Top)
        marker77.position = LatLng(37.5791454, 126.9240642)
        marker77.map = naverMap
        marker77.captionText = "뽀뽀핫도그"
        marker77.width = 60
        marker77.height = 80
        marker77.tag = "뽀뽀핫도그"

        marker77.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker77)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%20%EB%BD%80%EB%BD%80%ED%95%AB%EB%8F%84%EA%B7%B8/place/1707274688?c=14125604.9455256,4519981.5719050,13,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }


        val marker79 = Marker()
        marker79.icon = MarkerIcons.BLACK
        marker79.iconTintColor = Color.BLUE
        marker79.setCaptionAligns(Align.Top)
        marker79.position = LatLng(37.5800724, 126.9249453)
        marker79.map = naverMap
        marker79.captionText = "프랭크버거"
        marker79.width = 60
        marker79.height = 80
        marker79.tag = "프랭크버거"

        marker79.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker79)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%20%ED%94%84%EB%9E%AD%ED%81%AC%EB%B2%84%EA%B1%B0/place/1758466113?c=14125492.8467984,4520284.1876226,13,0,0,0,dh&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }

        val marker80 = Marker()
        marker80.icon = MarkerIcons.BLACK
        marker80.iconTintColor = Color.BLUE
        marker80.setCaptionAligns(Align.Top)
        marker80.position = LatLng(37.5795238, 126.9241751)
        marker80.map = naverMap
        marker80.captionText = "노브랜드버거"
        marker80.width = 60
        marker80.height = 80
        marker80.tag = "노브랜드버거"

        marker80.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker80)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%20%EB%85%B8%EB%B8%8C%EB%9E%9C%EB%93%9C%EB%B2%84%EA%B1%B0?c=14128197.5764662,4520200.5965999,15,0,0,0,dh")
            startActivity(openURL)
            true
        }

        val marker81 = Marker()
        marker81.icon = MarkerIcons.BLACK
        marker81.iconTintColor = Color.BLUE
        marker81.setCaptionAligns(Align.Top)
        marker81.position = LatLng(37.579898, 126.9247504)
        marker81.map = naverMap
        marker81.captionText = "맥도날드"
        marker81.width = 60
        marker81.height = 80
        marker81.tag = "맥도날드"

        marker81.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker81)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%20%EB%A7%A5%EB%8F%84%EB%82%A0%EB%93%9C/place/35929872?c=14128263.8449591,4520259.9010677,15,0,0,0,dh&isCorrectAnswer=true")
            startActivity(openURL)
            true
        }

        val marker82 = Marker()
        marker82.icon = MarkerIcons.BLACK
        marker82.iconTintColor = Color.BLUE
        marker82.setCaptionAligns(Align.Top)
        marker82.position = LatLng(37.5796077, 126.9243125)
        marker82.map = naverMap
        marker82.captionText = "롯데리아"
        marker82.width = 60
        marker82.height = 80
        marker82.tag = "롯데리아"

        marker82.setOnClickListener {
            // 마커를 클릭할 때 정보창을 엶

            infoWindow.open(marker82)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%AA%85%EC%A7%80%EB%8C%80%20%20%EB%A1%AF%EB%8D%B0%EB%A6%AC%EC%95%84/place/11824926?c=14127282.4634602,4520209.8111043,14,0,0,0,dh&placePath=%3Fentry%253Dbmp")
            startActivity(openURL)
            true
        }


        //분식
        val marker83 = Marker()
        marker83.icon = MarkerIcons.BLACK
        marker83.iconTintColor = Color.MAGENTA
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
        marker84.icon = MarkerIcons.BLACK
        marker84.iconTintColor = Color.MAGENTA
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