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


class JapanFood : AppCompatActivity(), OnMapReadyCallback {

    var TAG:String = "로그"

    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mapview4)

        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient("j0prkubkyo")

        // 뷰 역할을 하는 프래그먼트 객체 얻기
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.Walkmap_view4) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.Walkmap_view4, it).commit()
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