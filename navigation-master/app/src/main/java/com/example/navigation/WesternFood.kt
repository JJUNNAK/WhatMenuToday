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


class WesternFood : AppCompatActivity(), OnMapReadyCallback {

    var TAG:String = "로그"

    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mapview5)

        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient("j0prkubkyo")

        // 뷰 역할을 하는 프래그먼트 객체 얻기
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.Walkmap_view5) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.Walkmap_view5, it).commit()
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