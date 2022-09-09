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


class ChinaFood : AppCompatActivity(), OnMapReadyCallback {

    var TAG:String = "로그"

    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mapview2)

        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient("j0prkubkyo")

        // 뷰 역할을 하는 프래그먼트 객체 얻기
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.Walkmap_view2) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.Walkmap_view2, it).commit()
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
            16.5 // 줌 레벨
        )
        naverMap.cameraPosition = cameraPosition
        this.naverMap = naverMap

        //중식

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

            infoWindow.open(marker)
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

            infoWindow.open(marker)
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

            infoWindow.open(marker)
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

            infoWindow.open(marker)
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

            infoWindow.open(marker)
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

            infoWindow.open(marker)
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

            infoWindow.open(marker)
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

            infoWindow.open(marker)
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

            infoWindow.open(marker)
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

            infoWindow.open(marker)
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

            infoWindow.open(marker)
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

            infoWindow.open(marker)
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

            infoWindow.open(marker)
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

            infoWindow.open(marker)
            true
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data =
                Uri.parse("https://map.naver.com/v5/search/%EB%9D%BD%ED%9D%AC%EC%95%88%20%EB%AA%85%EC%A7%80%EB%8C%80/place/1378496863?c=14129790.3802683,4520290.3259915,15,0,0,0,dh&isCorrectAnswer=true")
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